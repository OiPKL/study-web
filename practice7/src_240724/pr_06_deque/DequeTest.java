package pr_06_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		
		// Deque
		// 특징 : 양쪽 끝에서 자유롭게 자료의 추가, 삭제 가능
		//     : Deque 는 인터페이스, 구현체는 ArrayDeque LinkedList 사용
		// ArrayList  : 빠른조회, 느린 추가&삭제
		// LinkedList : 느린조회, 빠른 추가&삭제
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.addFirst("alice");
		deque.addFirst("luna");
		deque.addLast("max");
		deque.addFirst("daisy");
		
		System.out.println("******************** 추가 ********************");
		System.out.println(deque);
		
		System.out.println("******************** 삭제 ********************");
		while(!deque.isEmpty()) {
			System.out.println(deque.removeLast());
			System.out.println(deque);
			System.out.println(deque.removeFirst());
			System.out.println(deque);
		}
		
	}
}
