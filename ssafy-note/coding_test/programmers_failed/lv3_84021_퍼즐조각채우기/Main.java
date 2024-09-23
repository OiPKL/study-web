package programmers_failed.lv3_84021_퍼즐조각채우기;

public class Main {
    public static void main(String[] args) {
        // First test case
        int[][] game_board1 = {
            {1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0}
        };

        int[][] table1 = {
            {1, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0}
        };

        Solution solution = new Solution();
        int result1 = solution.solution(game_board1, table1);
        System.out.println("Result for Test Case 1: " + result1);
        // 14

        // Second test case
        int[][] game_board2 = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 1}
        };

        int[][] table2 = {
            {1, 1, 1},
            {1, 0, 0},
            {0, 0, 0}
        };

        int result2 = solution.solution(game_board2, table2);
        System.out.println("Result for Test Case 2: " + result2);
        // 0
    }
}