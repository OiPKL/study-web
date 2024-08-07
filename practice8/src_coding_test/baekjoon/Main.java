package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] arrN = new int[N];
        for (int n = 0; n < N; n++)
        	arrN[n] = n + 1;
        								// 백트래킹의 의미를 깨달았습니다 ㅠㅠ
        int memo = 0;					// (5,3)에서 1을 출력하고 (4,2)로 재귀하면
        int remains = M;				// 다시 1로 돌아와서 2를 출력하고 (3,2)로 재귀가 가능하도록
        
        pickN(arrN, memo, remains);
        
    }
    
    static List<Integer> arrToShow = new ArrayList<>();

    static void show(List<Integer> arrToShow) {
    	for (int i = 0; i < arrToShow.size(); i++)
    		System.out.print(arrToShow.get(i) + " ");
    	System.out.println();
    }
    
    static void pickN(int[] arrN, int memo, int remains) {
    	
    	if (remains == 1) {
    		if (memo == arrN.length - 1) {		// 마지막 출력 후 종료
    			arrToShow.add(memo+1);
    			show(arrToShow);
    			return;
    		} else {							// 같은 memo 에서 출력-이전단계-출력-이전단계-...
    			for (int i = memo + 1; i <= arrN.length; i++) {
    				arrToShow.add(i);
    				show(arrToShow);
    				arrToShow.remove(arrToShow.size() - 1);
    			}
    			pickN(arrN, ++memo, ++remains);
    		}
    	} else {
    		if (memo == arrN.length - 1) {		// 더 이상 뽑을게 없을때 -> 이전 memo로
    			pickN(arrN, --memo, ++remains);
    		} else {							// 다음 memo로
    			arrToShow.add(memo);
    			pickN(arrN, ++memo, --remains);
    		}
    	}
    }
    
}