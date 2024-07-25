package pr_04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		
		// Queue
		// 특징 : FIFO (First In First Out)
		//     : Queue 는 인터페이스, 구현체는 LinkedList 사용
		
		Queue<Integer> queue = new LinkedList<>();
		
		// offer() add() : 예외처리 관련 차이
		queue.offer(1);
		queue.offer(2);
		queue.add(3);
		
		System.out.println("******************** 추가 ********************");
		System.out.println(queue);

		System.out.println("******************** 삭제 ********************");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
			System.out.println(queue);
		}
		
	}
}
