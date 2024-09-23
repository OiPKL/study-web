package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] initInfo = br.readLine().split(" ");
        int N = Integer.parseInt(initInfo[0]);
        long heroPwr = Integer.parseInt(initInfo[1]);

        long[][] rooms = new long[N][3];

        for (int n = 0; n < N; n++) {
            String[] roomInfo = br.readLine().split(" ");
            rooms[n][0] = Integer.parseInt(roomInfo[0]); // ROOM: 1Monster 2Healing
            rooms[n][1] = Integer.parseInt(roomInfo[1]); // POWER
            rooms[n][2] = Integer.parseInt(roomInfo[2]); // HP
        }
        
        long heroMaxHpBtm = 1;
        long heroMaxHpTop = 1_000_000_000_000L;

        while (heroMaxHpBtm < heroMaxHpTop) {
            
        	long heroMaxHp = (heroMaxHpBtm + heroMaxHpTop) / 2;
            long heroHp = heroMaxHp;
            
            dungeon:
            for (int n = 0; n < N; n++) {
                
                // Monster
                if (rooms[n][0] == 1) {
                	long mopPwr = rooms[n][1];
                	long mopHp = rooms[n][2] - heroPwr;				// 선빵
                	long heroAtkCnt = (mopHp + heroPwr) / heroPwr;
                	long mopAtkCnt = (heroHp + mopPwr) / mopPwr;
                	long AtkCnt = Math.min(heroAtkCnt, mopAtkCnt);
                	
                	heroHp -= AtkCnt * mopPwr;
                	
                	if (heroHp < 1) {
                		heroMaxHpBtm = heroMaxHp + 1;
                		break dungeon;
                	}
                // Healing
                } else {
                    heroPwr += rooms[n][1];
                    heroHp = Math.min(heroMaxHp, heroHp + rooms[n][2]);
                }
            }
            
            heroMaxHpTop = heroMaxHp;
            
        }
        
        System.out.println(heroMaxHpBtm);
    }
}