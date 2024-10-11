package swea.B형대비.승강제리그;

import java.util.ArrayList;
import java.util.TreeMap;

class UserSolution {

	static TreeMap<Integer, Integer>[] tm;
	static int players, leagues, leaguePlayers, middleIdx;
	static int[] stats;
	
    void init(int N, int L, int mAbility[]) {
    	
    	players = N;
    	leagues = L;
    	leaguePlayers = players / leagues;
    	middleIdx = leaguePlayers / 2;
    	
    	tm = new TreeMap[leagues];
    	
    	for (int i = 0; i < leagues; i++)
    		tm[i] = new TreeMap<>();
    	
    	int playerId = 0;
    	for (int i = 0; i < leagues; i++)
    		for (int j = 0; j < leaguePlayers; j++)
    			tm[i].put(playerId, mAbility[playerId++]);
    }

    int move() {
    	
    	int sum = 0;
    	
    	for (int i = 0; i < leagues - 1; i++) {
    		int outId = tm[i].firstKey();
    		int outStat = tm[i].get(outId);
    		int inId = tm[i + 1].lastKey();
    		int inStat = tm[i + 1].get(inId);
    		
    		sum += outId;
    		tm[i].remove(outId);
    		tm[i + 1].put(outId, outStat);
    		sum += inId;
    		tm[i + 1].remove(inId);
    		tm[i].put(inId, inStat);
    	}
    	
        return sum;
    }

    int trade() {
    	
    	int sum = 0;
    	
    	for (int i = 0; i < leagues - 1; i++) {
    		int outId = new ArrayList<>(tm[i].keySet()).get(middleIdx);
    		int outStat = tm[i].get(outId);
    		int inId = tm[i + 1].lastKey();
    		int inStat = tm[i + 1].get(inId);
    		
    		sum += outId;
    		tm[i].remove(outId);
    		tm[i + 1].put(outId, outStat);
    		sum += inId;
    		tm[i + 1].remove(inId);
    		tm[i].put(inId, inStat);
    	}
    	
        return sum;
    }

}