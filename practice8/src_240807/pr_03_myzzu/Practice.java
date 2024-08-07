package pr_03_myzzu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Person> queue = new LinkedList<>();
		
		int N = 20;
		int pNum = 1;
		
		System.out.println("대기명단 입력: ");
		String name = sc.next();
		System.out.println(name + "님이 새로 줄을 섭니다");
		queue.add(new Person(pNum++, name, 1));
		
		while (N > 0) {
			Person p = queue.poll();
			N -= p.myzzu;
			System.out.println(p.name + "님이 마이쮸를 " + p.myzzu + "개 가져갔습니다");
			System.out.println("남은 마이쮸는 " + N + "개");
			
			if (N <= 0) {
				System.out.println(p.name + "님이 마지막 마이쮸를 가져갔습니다");
				break;
			}
			
			p.myzzu++;
			queue.add(p);
			
			System.out.println("대기명단 입력: ");
			String newMember = sc.next();
			System.out.println(newMember + "님이 새로 줄을 섭니다");
			queue.add(new Person(pNum++, newMember, 1));
			System.out.println(newMember);
		}
		
	}
}
