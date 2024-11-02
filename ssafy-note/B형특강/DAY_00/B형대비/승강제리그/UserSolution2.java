package DAY_00.B형대비.승강제리그;

import java.util.Arrays;

class UserSolution2 {
    static int l, nl;
    static Player league[][];

    void init(int N, int L, int mAbility[]) {
        l = L;
        nl = N / L;
        league = new Player[l][nl];
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < nl; j++) {
                league[i][j] = new Player(i * nl + j, mAbility[i * nl + j]);
            }
            Arrays.sort(league[i]);
        }
    }

    int move() {
        // 상위 리그의 nl-1 번과 하위 리그의 0번 교환
        int res = 0;
        for (int i = 0; i < l - 1; i++) {
            res += (league[i][nl - 1].id + league[i + 1][0].id);
            Player tmp = league[i][nl - 1];
            league[i][nl - 1] = league[i + 1][0];
            league[i + 1][0] = tmp;
        }

        // swap한 선수들 정렬
        for (int i = 0; i < l; i++) {
            sortLast(league[i]);
            sortFirst(league[i]);
        }
        return res;
    }

    int trade() {
        // 상위 리그의 nl/2 번과 하위 리그의 0번 교환
        int res = 0;
        for (int i = 0; i < l - 1; i++) {
            res += (league[i][nl / 2].id + league[i + 1][0].id);
            Player tmp = league[i][nl / 2];
            league[i][nl / 2] = league[i + 1][0];
            league[i + 1][0] = tmp;
        }

        // swap한 선수들 정렬
        for (int i = 0; i < l; i++) {
            sortMid(league[i]);
            sortFirst(league[i]);
        }
        return res;
    }

    // leg번 리그의 1~nl-2까지는 정렬되어있음
    void sortLast(Player[] leg) {
        Player target = leg[nl - 1];
        int i = nl - 1;
        for (; i > 1; i--) {
            if (target.compareTo(leg[i - 1]) < 0) {
                leg[i] = leg[i - 1];
            } else {
                break;
            }
        }
        leg[i] = target;
        
    }

    void sortFirst(Player[] leg) {
        Player target = leg[0];
        int i = 0;
        for (; i < nl - 1; i++) {
            if (target.compareTo(leg[i + 1]) > 0) {
                leg[i] = leg[i + 1];
            } else {
                break;
            }
        }
        leg[i] = target;
    }

    void sortMid(Player[] leg) {
        Player target = leg[nl / 2];
        int i = nl / 2;
        for (; i > 1; i--) {
            if (target.compareTo(leg[i - 1]) < 0) {
                leg[i] = leg[i - 1];
            } else {
                break;
            }
        }
        for (; i < nl - 1; i++) {
            if (target.compareTo(leg[i + 1]) > 0) {
                leg[i] = leg[i + 1];
            } else {
                break;
            }
        }
        leg[i] = target;
    }
}

class Player implements Comparable<Player> {
    int id;
    int ability;

    public Player(int id, int ability) {
        this.id = id;
        this.ability = ability;
    }

    @Override
    public int compareTo(Player o) {
        if (this.ability == o.ability) {
            return this.id - o.id;
        }
        return o.ability - this.ability;
    }

}