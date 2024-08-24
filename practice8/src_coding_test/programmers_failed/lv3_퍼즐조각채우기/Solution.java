package programmers_failed.lv3_퍼즐조각채우기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[][] table) {
    	
    	int[] dn = new int[] {-1, 0, 1, 0};
    	int[] dm = new int[] {0, 1, 0, -1};
    	
    	int answer = 0;
    	int N = board.length;
    	boolean[][] boardVisited = new boolean[N][N];
    	boolean[][] tableVisited = new boolean[N][N];
    	
    	Stack<int[]> stack = new Stack<>();					// DFS 탐색용
    	List<List<int[]>> blocksList = new ArrayList<>();	// 블럭 리스트 (블럭당 4개)
    	List<int[]> blockFlag = new ArrayList<>();			// 블럭좌표저장
    	List<int[]> blockInfo1 = new ArrayList<>();			// 블럭정보저장
    	List<int[]> blockInfo2 = new ArrayList<>();			// - 첫번째 블럭 기준 좌표'변화' 저장
    	List<int[]> blockInfo3 = new ArrayList<>();
    	List<int[]> blockInfo4 = new ArrayList<>();
    	List<int[]> boardFlag = new ArrayList<>();			// 보드좌표저장
    	List<int[]> blockInfo = new ArrayList<>();			// 블럭정보로드

    	// 테이블 블럭 탐색
    	for (int n = 0; n < N; n++) {
    		for (int m = 0; m < N; m++) {
    			if (table[n][m] == 1 && !tableVisited[n][m]) {
    				
    				tableVisited[n][m] = true;
    				stack.push(new int[] {n, m});
    				blockFlag.clear();
    				blockFlag.add(new int[] {n, m});
    				blockInfo1.clear();
    				blockInfo1.add(new int[] {0});			// (임시) 사이즈 저장용
    				blockInfo2.clear();
    				blockInfo2.add(new int[] {0});
    				blockInfo3.clear();
    				blockInfo3.add(new int[] {0});
    				blockInfo4.clear();
    				blockInfo4.add(new int[] {0});
    																
    				while (!stack.isEmpty()) {
    					int[] now = stack.pop();
    					int nNow = now[0];
    					int mNow = now[1];
    					
    					for (int d = 0; d < 4; d++) {
    						int nNext = nNow + dn[d];
    						int mNext = mNow + dm[d];
    						
    						if (nNext < 0 || nNext == N) continue;
    						if (mNext < 0 || mNext == N) continue;
    						if (table[nNext][mNext] == 0) continue;
    						if (tableVisited[nNext][mNext]) continue;
    						
    						tableVisited[nNext][mNext] = true;
    						stack.push(new int[] {nNext, mNext});
    						blockFlag.add(new int[] {nNext, mNext});
    					}
    				}
    				// 블럭정보저장	 (블럭 사이즈 -1 생성됨 주의!!!!)
    				// blockInfo [{size}, {원점블럭기준n변화량,m변화량}, {원점블럭기준n변화량,m변화량}, ... ]
    				for (int b = 1; b < blockFlag.size(); b++) {
    					int blockChangeN = blockFlag.get(b)[0] - blockFlag.get(0)[0];
    					int blockChangeM = blockFlag.get(b)[1] - blockFlag.get(0)[1];
    					blockInfo1.add(new int[] {blockChangeN, blockChangeM});
    					blockInfo2.add(new int[] {-blockChangeM, blockChangeN});
    					blockInfo3.add(new int[] {-blockChangeN, -blockChangeM});
    					blockInfo4.add(new int[] {blockChangeM, -blockChangeN});
    				}
    				int[] blockSize = new int[] {blockFlag.size()};
    				blockInfo1.set(0, blockSize);
    				blockInfo2.set(0, blockSize);
    				blockInfo3.set(0, blockSize);
    				blockInfo4.set(0, blockSize);
    				blocksList.add(blockInfo1);
    				blocksList.add(blockInfo2);
    				blocksList.add(blockInfo3);
    				blocksList.add(blockInfo4);
    			}
    		}
    	}
    	
    	// 보드 빈칸 딱맞는 블럭 탐색
    	for (int n = 0; n < N; n++) {
    		for (int m = 0; m < N; m++) {
    			if (board[n][m] == 0 && !boardVisited[n][m]) {
    				
    				boardVisited[n][m] = true;
    				stack.push(new int[] {n, m});
    				boardFlag.clear();
    				boardFlag.add(new int[] {n, m});
    				
    				while (!stack.isEmpty()) {
    					int[] now = stack.pop();
    					int nNow = now[0];
    					int mNow = now[1];
    					
    					for (int d = 0; d < 4; d++) {
    						int nNext = nNow + dn[d];
    						int mNext = mNow + dm[d];
    						
    						if (nNext < 0 || nNext >= N) continue;
    						if (mNext < 0 || mNext >= N) continue;
    						if (board[nNext][mNext] == 1) continue;
    						if (boardVisited[nNext][mNext]) continue;
    						
    						boardVisited[nNext][mNext] = true;
    						stack.push(new int[] {nNext, mNext});
    						boardFlag.add(new int[] {nNext, mNext});
    					}
    				}
    				// 빈칸 좌표 순회하면서 일치하는 blocksList<blockInfo[nd,md]>
    				clear:
    				for (int bl = 0; bl < blocksList.size(); bl++) {	// blockInfo.get(0) = size
    					blockInfo = blocksList.get(bl);
    					// 블럭 중복 선택 방지
    					if (blockInfo.isEmpty()) continue clear;
    					
    					check:
    					for (int bf = 0; bf < boardFlag.size(); bf++) {	// blockInfo.get(1) = 두번째블럭 상대좌표
    						int nNow = boardFlag.get(bf)[0];
    						int mNow = boardFlag.get(bf)[1];
    						// 보드빈칸 사이즈 == 블럭 사이즈 인 경우에만 진행
    						if (boardFlag.size() != blocksList.get(bl).get(0)[0]) continue;
    						
    						for (int bi = 1; bi < blockInfo.size(); bi++) {
    							int nNext = nNow + blockInfo.get(bi)[0];
    							int mNext = mNow + blockInfo.get(bi)[1];
    							
    							if (nNext < 0 || nNext >= N) continue check;
        						if (mNext < 0 || mNext >= N) continue check;
        						if (board[nNext][mNext] == 1) continue check;
    						}
    						// 여기까지 도달 -> 보드 빈칸 == 블럭 일치 -> 중복 방지
    						for (int bl2 = bl / 4 * 4; bl2 < bl / 4 * 4 + 4; bl2++) {
    							blocksList.get(bl2).clear();
    						}
    						answer += boardFlag.size();
    						break clear;
    					}
    				}
    				
    			}
    		}
    	}
    	return answer;
    }
    
}

/*
 * 퍼즐1 빈칸0
 * 퍼즐/빈칸 최대6칸
 * 퍼즐 한번에 하나씩
 * 회전O 뒤집기X
 * 새로채워넣은조각 인접=비어있음X
 * ~~ 최대 몇칸?
 */