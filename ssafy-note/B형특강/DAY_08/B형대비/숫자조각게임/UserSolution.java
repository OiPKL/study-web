package DAY_08.B형대비.숫자조각게임;

import java.util.*;

public class UserSolution{

    private static final int MAX_ROW = 40;
    private static final int MAX_COL = 30;
    private static final int CMD_INIT = 1;
    private static final int CMD_PUT = 2;
    private static final int CMD_CLR = 3;

    static class Result {
        int row, col;

        public Result(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final int INF = Integer.MAX_VALUE;
    private static final List<int[][]> PATTERNS = Arrays.asList(
            new int[][]{{0, 0}, {1, 0}, {1, 1}, {1, 2}, {2, 2}},
            new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            new int[][]{{0, 0}, {0, 1}, {0, 2}},
            new int[][]{{0, 0}, {1, 0}, {2, 0}},
            new int[][]{{0, 0}, {0, 1}}
    );

    static class PatternData {
        int type, hash;
        List<int[]> positions;

        public PatternData(int type, int hash, List<int[]> positions) {
            this.type = type;
            this.hash = hash;
            this.positions = positions;
        }
    }

    private static int H, W;
    private static BitSet[] gridOccupied = new BitSet[MAX_ROW];
    private static List<PatternData> data = new ArrayList<>();
    private static Map<String, LinkedList<int[]>> patternMap = new HashMap<>();

    static {
        for (int i = 0; i < MAX_ROW; i++) {
            gridOccupied[i] = new BitSet(MAX_COL);
        }
    }

    public static void init(int mRows, int mCols, int[][] mCells) {
        H = mRows;
        W = mCols;

        // Reset data
        for (int i = 0; i < H; i++) {
            gridOccupied[i].clear();
        }
        data.clear();
        patternMap.clear();

        // Preprocess patterns
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int type = 0; type < PATTERNS.size(); type++) {
                    int[][] pattern = PATTERNS.get(type);
                    int minVal = INF;
                    boolean valid = true;

                    for (int[] offset : pattern) {
                        int ni = i + offset[0];
                        int nj = j + offset[1];
                        if (ni >= H || nj >= W) {
                            valid = false;
                            break;
                        }
                        minVal = Math.min(minVal, mCells[ni][nj]);
                    }

                    if (!valid) continue;

                    int hash = 0;
                    for (int[] offset : pattern) {
                        int ni = i + offset[0];
                        int nj = j + offset[1];
                        hash = (hash << 3) | (mCells[ni][nj] - minVal);
                    }

                    String key = type + ":" + hash;
                    patternMap.putIfAbsent(key, new LinkedList<>());
                    patternMap.get(key).add(new int[]{i, j});
                }
            }
        }

        // Save pattern data
        for (Map.Entry<String, LinkedList<int[]>> entry : patternMap.entrySet()) {
            String[] parts = entry.getKey().split(":");
            int type = Integer.parseInt(parts[0]);
            int hash = Integer.parseInt(parts[1]);
            List<int[]> positions = entry.getValue();
            positions.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
            data.add(new PatternData(type, hash, positions));
        }
    }

    public static Result putPuzzle(int[][] mPuzzle) {
        int type = -1;

        // Determine the pattern type
        for (int t = 0; t < PATTERNS.size(); t++) {
            boolean matches = true;
            for (int[] offset : PATTERNS.get(t)) {
                if (mPuzzle[offset[0]][offset[1]] == 0) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                type = t;
                break;
            }
        }

        if (type == -1) return new Result(-1, -1);

        // Calculate hash for the given puzzle
        int minVal = INF;
        for (int[] offset : PATTERNS.get(type)) {
            minVal = Math.min(minVal, mPuzzle[offset[0]][offset[1]]);
        }

        int hash = 0;
        for (int[] offset : PATTERNS.get(type)) {
            hash = (hash << 3) | (mPuzzle[offset[0]][offset[1]] - minVal);
        }

        String key = type + ":" + hash;
        LinkedList<int[]> positions = patternMap.get(key);
        if (positions == null || positions.isEmpty()) return new Result(-1, -1);

        while (!positions.isEmpty()) {
            int[] pos = positions.removeLast();
            int r = pos[0];
            int c = pos[1];
            boolean canPlace = true;

            for (int[] offset : PATTERNS.get(type)) {
                int nr = r + offset[0];
                int nc = c + offset[1];
                if (gridOccupied[nr].get(nc)) {
                    canPlace = false;
                    break;
                }
            }

            if (canPlace) {
                for (int[] offset : PATTERNS.get(type)) {
                    int nr = r + offset[0];
                    int nc = c + offset[1];
                    gridOccupied[nr].set(nc);
                }
                return new Result(r, c);
            }
        }

        return new Result(-1, -1);
    }

    public static void clearPuzzles() {
        for (int i = 0; i < H; i++) {
            gridOccupied[i].clear();
        }
        for (PatternData d : data) {
            String key = d.type + ":" + d.hash;
            patternMap.put(key, new LinkedList<>(d.positions));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int MARK = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int queryNum = sc.nextInt();
            boolean ok = true;

            for (int q = 0; q < queryNum; q++) {
                int query = sc.nextInt();
                if (query == CMD_INIT) {
                    int mRows = sc.nextInt();
                    int mCols = sc.nextInt();
                    int[][] mCells = new int[mRows][mCols];
                    for (int i = 0; i < mRows; i++) {
                        for (int j = 0; j < mCols; j++) {
                            mCells[i][j] = sc.nextInt();
                        }
                    }
                    init(mRows, mCols, mCells);
                } else if (query == CMD_PUT) {
                    String strPuzzle = sc.next();
                    int[][] mPuzzle = new int[3][3];
                    for (int i = 0, cnt = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            mPuzzle[i][j] = strPuzzle.charAt(cnt++) - '0';
                        }
                    }
                    Result res = putPuzzle(mPuzzle);
                    int ansRow = sc.nextInt();
                    int ansCol = sc.nextInt();
                    if (res.row != ansRow || res.col != ansCol) {
                        ok = false;
                    }
                } else if (query == CMD_CLR) {
                    clearPuzzles();
                }
            }

            int score = ok ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }
        sc.close();
    }
}
