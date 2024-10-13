package baekjoon_failed.G2_29760_건물방문하기;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();

        boolean[] visited = new boolean[N];
        int[][] rooms = new int[N][2];
        for (int i = 0; i < N; i++) {
            rooms[i][0] = sc.nextInt();
            rooms[i][1] = sc.nextInt();
        }
        
        int nowH = 1;
        int nowW = 1;
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);

        for (int i = 0; i < N; i++) {
            int nextH = rooms[i][0];
            int nextW = rooms[i][1];
            
            int time = Math.abs(nowH - nextH) * 100 + Math.abs(nowW - nextW);
            pq.add(new int[] {i, nextH, nextW, time});
        }
        
        for (int i = 0; i < N; i++) {
        	int[] next = pq.poll();
        	int nextI = next[0];
        	int nextH = next[1];
        	int nextW = next[2];
        	int time = next[3];
        	
        	nowH = nextH;
        	nowW = nextW;
        	answer += time;
        	visited[nextI] = true;
        	
        	pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        	
            for (int j = 0; j < N; j++) {
            	if (visited[j]) continue;
            	
                nextH = rooms[j][0];
                nextW = rooms[j][1];
                
                time = Math.abs(nowH - nextH) * 100 + Math.abs(nowW - nextW);
                pq.add(new int[] {j, nextH, nextW, time});
            }
        }

        System.out.println(answer);
    }
}
