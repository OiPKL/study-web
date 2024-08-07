package pr_02_queue_api;

import java.util.LinkedList;
import java.util.Queue;

public class Practice {
	public static void main(String[] args) {
		
		// 큐는 인터페이스 .. 객체 생성x .. 구현체 필요 = LinkedList
		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);		// 예외 발생
		queue.offer(2);		// return false
		System.out.println(queue);
		
		queue.remove();		// 예외 발생
		queue.poll();		// return null
		System.out.println(queue);
		
		queue.element();	// 예외 발생
		queue.peek(); 		// return null
		
	}
}
