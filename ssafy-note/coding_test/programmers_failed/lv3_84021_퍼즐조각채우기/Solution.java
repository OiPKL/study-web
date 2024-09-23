package programmers_failed.lv3_84021_퍼즐조각채우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    static int[] dn = new int[] {0, 1, 0, -1};
    static int[] dm = new int[] {1, 0, -1, 0};
    
    static int N;
    static boolean[][] tableVisited, boardVisited;
    static List<List<Integer>> tableList, boardList;

    public int solution(int[][] board, int[][] table) {
        
        int answer = 0;
        
        N = board.length;
        tableVisited = new boolean[N][N];
        boardVisited = new boolean[N][N];
        
        tableList = new ArrayList<>();    // 사이즈, 가로길이, 세로길이, {0 or 1}
        boardList = new ArrayList<>();
        
        // tableInfo
        for (int n = 0; n < N; n++)
            for (int m = 0; m < N; m++)
                if (table[n][m] == 1 && !tableVisited[n][m])
                    searchBlock(n, m, table, true);
        
        // boardInfo
        for (int n = 0; n < N; n++)
            for (int m = 0; m < N; m++)
                if (board[n][m] == 0 && !boardVisited[n][m])
                    searchBlock(n, m, board, false);
        
        for (List<Integer> boardInfo : boardList) {
            
            int boardSize = boardInfo.get(0);
            int boardHeight = boardInfo.get(1);
            int boardLength = boardInfo.get(2);
            
            for (int i = 0; i < tableList.size(); i++) {
                List<Integer> tableInfo = tableList.get(i);

                if (boardSize != tableInfo.get(0)) continue;
                if (boardHeight != tableInfo.get(1)) continue;
                if (boardLength != tableInfo.get(2)) continue;
                
                boolean match = true;
                for (int j = 3; j < boardInfo.size(); j++) {
                    if (boardInfo.get(j) != tableInfo.get(j)) {
                        match = false;
                        break;
                    }
                }
                
                if (match) {
                    answer += boardSize;
                    tableList.remove(i);
                    break;
                }
                
                for (int turn = 0; turn < 4; turn++) {
                    
                    List<Integer> rotatedTableInfo = rotate(tableInfo);
                    
                    if (boardSize != rotatedTableInfo.get(0)) continue;
                    if (boardHeight != rotatedTableInfo.get(1)) continue;
                    if (boardLength != rotatedTableInfo.get(2)) continue;
                    
                    match = true;
                    for (int j = 3; j < boardInfo.size(); j++) {
                        if (boardInfo.get(j) != rotatedTableInfo.get(j)) {
                            match = false;
                            break;
                        }
                    }
                    
                    if (match) {
                        answer += boardSize;
                        tableList.remove(i);
                        break;
                    }
                    
                    tableInfo = rotatedTableInfo;
                }
            }
        }
        
        return answer;
    }
    
    static void searchBlock(int n, int m, int[][] map, boolean isTable) {
        
        int target = isTable ? 1 : 0;
        int nonTarget = isTable ? 0 : 1;
        boolean[][] visited = isTable ? tableVisited : boardVisited;
        List<List<Integer>> infoList = isTable ? tableList : boardList;
        
        int limitL = n;
        int limitR = n;
        int limitT = m;
        int limitB = m;
        int size = 0;
        Queue<int[]> bfs = new LinkedList<>();
        List<int[]> realBlocks = new ArrayList<>();
        
        bfs.add(new int[] {n, m, 1});
        visited[n][m] = true;
        
        while (!bfs.isEmpty()) {
            
            int[] now = bfs.poll();
            int nNow = now[0];
            int mNow = now[1];
            
            limitL = Math.min(limitL, nNow);
            limitR = Math.max(limitR, nNow);
            limitT = Math.min(limitT, mNow);
            limitB = Math.max(limitB, mNow);
            realBlocks.add(new int[] {nNow, mNow});
            ++size;
            
            for (int d = 0; d < 4; d++) {
                int nNext = nNow + dn[d];
                int mNext = mNow + dm[d];
                
                if (nNext < 0 || N <= nNext) continue;
                if (mNext < 0 || N <= mNext) continue;
                if (visited[nNext][mNext]) continue;
                if (map[nNext][mNext] != target) continue;
                
                bfs.add(new int[] {nNext, mNext});
                visited[nNext][mNext] = true;
            }
        }
        
        int height = limitB - limitT + 1;
        int length = limitR - limitL + 1;
        List<Integer> info = new ArrayList<>();
        
        info.add(size);
        info.add(height);
        info.add(length);
        
        boolean[][] blockMap = new boolean[height][length];
        
        for (int[] block : realBlocks) {
            int blockN = block[0] - limitL;
            int blockM = block[1] - limitT;
            if (blockN >= 0 && blockN < height && blockM >= 0 && blockM < length)
            	blockMap[blockN][blockM] = true;
        }
        
        for (int nn = 0; nn < height; nn++)
        	for (int mm = 0; mm < length; mm++)
            	info.add(blockMap[nn][mm] ? target : nonTarget);
        
        infoList.add(info);
    }
    
    static List<Integer> rotate(List<Integer> info) {
        
        int size = info.get(0);
        int height = info.get(1);
        int length = info.get(2);
        List<Integer> rotatedInfo = new ArrayList<>();
        
        rotatedInfo.add(size);
        rotatedInfo.add(length);
        rotatedInfo.add(height);
        
        int[][] original = new int[height][length];
        for (int n = 0; n < height; n++)
            for (int m = 0; m < length; m++)
                original[n][m] = info.get(3 + n * length + m);
        
        for (int m = 0; m < length; m++)
            for (int n = height - 1; n >= 0; n--)
                rotatedInfo.add(original[n][m]);

        return rotatedInfo;
    }
}