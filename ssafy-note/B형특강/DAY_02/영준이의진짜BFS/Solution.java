package DAY_02.영준이의진짜BFS;

import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static List<Integer>[] graph;
    static int[][] par;
    static int[] d;
    static boolean[] visit;

    public static void init() {
        for (int i = 0; i <= N; i++) {
            graph[i].clear();
        }
        Arrays.fill(d, 0);
        Arrays.fill(visit, false);
    }

    public static int LCA(int x, int y, int cnt) {
        if (d[x] > d[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (par[y][0] == x) {
            return 1;
        }
        for (int i = 19; i >= 0; i--) {
            if (d[y] - d[x] >= (1 << i)) {
                y = par[y][i];
                cnt += (1 << i);
            }
        }
        if (par[y][0] != par[x][0]) {
            for (int i = 19; i >= 0; i--) {
                if (par[x][i] != par[y][i]) {
                    cnt += 2 * (1 << i);
                    x = par[x][i];
                    y = par[y][i];
                }
            }
        }
        if (par[x][0] == par[y][0]) {
            return cnt + 2;
        }
        return cnt;
    }

    public static long bfs() {
        long result = 0;
        int pre = 1, cur;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : graph[x]) {
                if (visit[y]) continue;
                q.add(y);
                cur = y;
                visit[y] = true;
                result += LCA(pre, cur, 0);
                pre = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            graph = new ArrayList[N + 1];
            par = new int[N + 1][20];
            d = new int[N + 1];
            visit = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            init();
            par[1][0] = 0;
            d[1] = 0;

            for (int i = 2; i <= N; i++) {
                int k = Integer.parseInt(br.readLine());
                graph[k].add(i);
                par[i][0] = k;
                d[i] = d[k] + 1;
            }

            for (int y = 1; y < 20; y++) {
                for (int x = 1; x <= N; x++) {
                    par[x][y] = par[par[x][y - 1]][y - 1];
                }
            }

            System.out.println("#" + tc + " " + bfs());
        }
    }
}
