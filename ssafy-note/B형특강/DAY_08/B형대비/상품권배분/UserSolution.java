package DAY_08.B형대비.상품권배분;

import java.util.*;

public class UserSolution {
    static Map<Integer, Integer> cmp = new HashMap<>();
    static int C;
    static int[] p;
    static int[] sub;
    static int[] deg;
    static boolean[] isDead;
    static int nGroup;

    public static void init(int n, int[] id, int[] si) {
        cmp.clear();
        C = 0;
        nGroup = n;
        p = new int[18000];
        sub = new int[18000];
        deg = new int[18000];
        isDead = new boolean[18000];
        Arrays.fill(p, -1);
        Arrays.fill(deg, 0);
        Arrays.fill(isDead, false);

        for (int i = 0; i < n; i++) {
            int my = cmp.put(id[i], C++);
            p[my] = -1;
            sub[my] = si[i];
        }
    }

    public static int add(int id, int si, int par) {
        if (!cmp.containsKey(par)) {
            return -1;
        }
        par = cmp.get(par);
        if (deg[par] >= 3) {
            return -1;
        }
        id = cmp.put(id, C++);
        deg[par]++;
        p[id] = par;
        sub[id] = 0;
        deg[id] = 0;

        int current = id;
        while (current != -1) {
            sub[current] += si;
            current = p[current];
        }
        return sub[par];
    }

    public static int remove(int id) {
        if (!cmp.containsKey(id)) {
            return -1;
        }
        id = cmp.get(id);

        int current = id;
        while (current != -1) {
            if (isDead[current]) {
                return -1;
            }
            current = p[current];
        }

        isDead[id] = true;
        if (p[id] != -1) {
            deg[p[id]]--;
        }

        int si = sub[id];
        current = id;
        while (current != -1) {
            sub[current] -= si;
            current = p[current];
        }
        return si;
    }

    public static int distribute(int K) {
        List<Integer> siList = new ArrayList<>();
        for (int i = 0; i < nGroup; i++) {
            siList.add(sub[i]);
        }
        siList.sort(Comparator.naturalOrder());

        int pref = siList.stream().mapToInt(Integer::intValue).sum();
        if (pref <= K) {
            return siList.get(siList.size() - 1);
        }

        for (int i = nGroup - 1; i >= 0; i--) {
            pref -= siList.get(i);
            int L = (K - pref) / (nGroup - i);
            if ((i > 0 ? siList.get(i - 1) : 0) <= L) {
                return L;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int MARK = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            boolean result = run(sc);
            System.out.println("#" + tc + " " + (result ? MARK : 0));
        }
    }

    private static boolean run(Scanner sc) {
        int q = sc.nextInt();
        int[] midArr = new int[1000];
        int[] mnumArr = new int[1000];
        boolean okay = true;

        for (int i = 0; i < q; i++) {
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1: // CMD_INIT
                    int n = sc.nextInt();
                    for (int j = 0; j < n; j++) {
                        midArr[j] = sc.nextInt();
                        mnumArr[j] = sc.nextInt();
                    }
                    init(n, midArr, mnumArr);
                    break;
                case 2: // CMD_ADD
                    int mid = sc.nextInt();
                    int mnum = sc.nextInt();
                    int mparent = sc.nextInt();
                    int ansAdd = sc.nextInt();
                    int retAdd = add(mid, mnum, mparent);
                    if (ansAdd != retAdd) {
                        okay = false;
                    }
                    break;
                case 3: // CMD_REMOVE
                    int rmId = sc.nextInt();
                    int ansRemove = sc.nextInt();
                    int retRemove = remove(rmId);
                    if (ansRemove != retRemove) {
                        okay = false;
                    }
                    break;
                case 4: // CMD_DISTRIBUTE
                    int k = sc.nextInt();
                    int ansDistribute = sc.nextInt();
                    int retDistribute = distribute(k);
                    if (ansDistribute != retDistribute) {
                        okay = false;
                    }
                    break;
                default:
                    okay = false;
                    break;
            }
        }
        return okay;
    }
}
