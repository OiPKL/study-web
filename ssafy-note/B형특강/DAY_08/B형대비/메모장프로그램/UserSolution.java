package DAY_08.B형대비.메모장프로그램;

import java.util.*;

public class UserSolution {
    private static final int CMD_INIT = 100;
    private static final int CMD_INSERT = 200;
    private static final int CMD_MOVECURSOR = 300;
    private static final int CMD_COUNT = 400;

    static class Editor {
        LinkedList<Character>[] grid = new LinkedList[303];
        int[][] counting = new int[303][26];
        int h, w;
        int curR, curC;
        int len;

        public Editor() {
            for (int i = 0; i < 303; i++) {
                grid[i] = new LinkedList<>();
            }
        }

        void init(int H, int W, String str) {
            len = 0;
            h = H;
            w = W;
            for (int i = 0; i < 303; i++) {
                Arrays.fill(counting[i], 0);
                grid[i].clear();
            }
            int idx = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (idx < str.length()) {
                        char c = str.charAt(idx++);
                        counting[i][c - 'a']++;
                        grid[i].add(c);
                        len++;
                    } else {
                        break;
                    }
                }
            }
            curR = curC = 0;
        }

        void insert(char c) {
            grid[curR].add(curC, c);
            counting[curR][c - 'a']++;
            curC++;
            len++;
            if (curC == w) {
                curC = 0;
                curR++;
            }
            int row = curR;
            while (grid[row].size() > w) {
                char overflow = grid[row].removeLast();
                counting[row][overflow - 'a']--;
                if (row + 1 < 303) {
                    counting[row + 1][overflow - 'a']++;
                    grid[row + 1].addFirst(overflow);
                    row++;
                }
            }
        }

        char moveCursor(int row, int col) {
            row--;
            col--;
            if (row * w + col >= len) {
                curR = len / w;
                curC = len % w;
                return '$';
            }
            curR = row;
            curC = col;
            return grid[row].get(col);
        }

        int countCharacter(char c) {
            int row = curR, col = curC;
            int ret = 0;

            if (col < grid[row].size()) {
                for (int i = col; i < grid[row].size(); i++) {
                    if (grid[row].get(i) == c) {
                        ret++;
                    }
                }
                row++;
            }
            for (int i = row; i < h; i++) {
                ret += counting[i][c - 'a'];
            }
            return ret;
        }
    }

    public static boolean run(Scanner sc, Editor editor) {
        boolean correct = false;
        int queryCnt = sc.nextInt();
        int H, W;
        char mChar;
        String mStr;

        while (queryCnt-- > 0) {
            int cmd = sc.nextInt();
            if (cmd == CMD_INIT) {
                H = sc.nextInt();
                W = sc.nextInt();
                mStr = sc.next();
                editor.init(H, W, mStr);
                correct = true;
            } else if (cmd == CMD_INSERT) {
                mChar = sc.next().charAt(0);
                editor.insert(mChar);
            } else if (cmd == CMD_MOVECURSOR) {
                int mRow = sc.nextInt();
                int mCol = sc.nextInt();
                char ret = editor.moveCursor(mRow, mCol);
                char ans = sc.next().charAt(0);
                if (ret != ans) {
                    correct = false;
                }
            } else if (cmd == CMD_COUNT) {
                mChar = sc.next().charAt(0);
                int ret = editor.countCharacter(mChar);
                int ans = sc.nextInt();
                if (ret != ans) {
                    correct = false;
                }
            }
        }
        return correct;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int MARK = sc.nextInt();

        Editor editor = new Editor();

        for (int tc = 1; tc <= T; tc++) {
            boolean result = run(sc, editor);
            int score = result ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }
    }
}
