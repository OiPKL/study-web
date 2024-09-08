package baekjoon;

import java.util.Scanner;

public class Main {

    static int[] dn = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dm = {0, 1, 0, -1};
    static int N, M, maxSum;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                map[n][m] = sc.nextInt();

        maxSum = 0;
        for (int nNow = 0; nNow < N; nNow++) {
            for (int mNow = 0; mNow < M - 1; mNow++) { // 가로 2개를 먼저 고름
                visited[nNow][mNow] = true;
                visited[nNow][mNow + 1] = true; // 가로로 연속된 두 칸 선택

                btk1(nNow, mNow, 2, map[nNow][mNow] + map[nNow][mNow + 1]); // 가로 두 개 선택 후 주변에서 2개 픽
                btk2(nNow, mNow, 2, map[nNow][mNow] + map[nNow][mNow + 1], 1); // 가로 두 개 선택 후 주변에서 1개 픽, 그다음 2칸 떨어진 곳에서 1개 픽

                visited[nNow][mNow] = false;
                visited[nNow][mNow + 1] = false;
            }
        }

        System.out.println(maxSum);
    }

    // btk1: 가로 2개를 둘러싼 블록에서 2개를 고르는 함수
    static void btk1(int nNow, int mNow, int cnt, int sum) {
        if (cnt == 4) { // 4개의 칸을 채웠을 때
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // 가로로 연속된 두 블록을 둘러싸는 블록 중 모서리를 제외하고 선택
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 2; j++) {
                int nNext = nNow + i;
                int mNext = mNow + j;

                // 모서리 블록 제외 조건 추가
                // i와 j 값의 조합에 따라 모서리인지 체크
                if ((i == -1 && j == -1) || (i == -1 && j == 2) || (i == 1 && j == -1) || (i == 1 && j == 2)) {
                    continue; // 모서리의 네 곳은 무시
                }

                if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext) continue;
                if (visited[nNext][mNext]) continue;

                visited[nNext][mNext] = true;
                btk1(nNow, mNow, cnt + 1, sum + map[nNext][mNext]); // 현재 위치 기준으로 주변에서 고르기
                visited[nNext][mNext] = false;
            }
        }
    }
    
 // btk2: 가로 2개를 둘러싼 블록에서 1개 고르고, 그 블록에서 다시 1칸 떨어진 곳에서 1개를 고르는 함수
    static void btk2(int nNow, int mNow, int cnt, int sum, int level) {
        if (cnt == 4) { // 4개의 칸을 채웠을 때
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // 1단계에서는 주변에서 1개 픽
        if (level == 1) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 2; j++) {
                    int nNext = nNow + i;
                    int mNext = mNow + j;

                    // 모서리 블록 제외 조건 추가
                    if ((i == -1 && j == -1) || (i == -1 && j == 2) || (i == 1 && j == -1) || (i == 1 && j == 2)) {
                        continue; // 모서리의 네 곳은 무시
                    }

                    if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext) continue;
                    if (visited[nNext][mNext]) continue;

                    visited[nNext][mNext] = true;
                    btk2(nNext, mNext, cnt + 1, sum + map[nNext][mNext], 2); // 다음 단계로 이동
                    visited[nNext][mNext] = false;
                }
            }
        }
        // 2단계에서는 현재 선택한 블록에서 상하좌우로 이동한 후 다시 꺾어서 선택하여 L 모양을 만든다
        else if (level == 2) {
            for (int d = 0; d < 4; d++) {
                int nNext = nNow + dn[d];  // 한 칸 이동
                int mNext = mNow + dm[d];
                if (nNext < 0 || N <= nNext || mNext < 0 || M <= mNext) continue;
                if (visited[nNext][mNext]) continue;

                visited[nNext][mNext] = true;

                // 2단계에서 선택한 블록을 기준으로 다시 꺾어서 이동
                for (int k = 0; k < 4; k++) {
                    if (k == (d + 2) % 4) continue; // 반대 방향은 제외
                    int nnNext = nNext + dn[k];
                    int mmNext = mNext + dm[k];
                    if (nnNext < 0 || N <= nnNext || mmNext < 0 || M <= mmNext) continue;
                    if (visited[nnNext][mmNext]) continue;

                    visited[nnNext][mmNext] = true;
                    btk2(nnNext, mmNext, cnt + 1, sum + map[nnNext][mmNext], 3); // L 모양 완성
                    visited[nnNext][mmNext] = false;
                }

                visited[nNext][mNext] = false;
            }
        }
    }
}
