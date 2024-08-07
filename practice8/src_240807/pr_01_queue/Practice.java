package pr_01_queue;

import java.util.Scanner;

public class Practice {

	// 배열 사이즈 : 가질 수 있는 개수 x -> 총 넣을 수 있는 개수 o
	static String[] queue = new String[10];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("삽입할 문자열 입력: ");
			String item = sc.next();
			enQueue(item);
		}
		
		System.out.println("size: " + size());
		
		
		while (!isEmpty()) {
			String rItem = deQueue();
			System.out.print(rItem + " ");
		}
		
	}
	
	static boolean isEmpty() {
//		if (front == rear)
//			return true;
//		return false;
		return front == rear;
	}
	
	static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	// 삽입 성공 여부를 반환 -> boolean 변경
	static void enQueue(String item) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다");
			return;
		}
		queue[++rear] = item;
	}

	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
		return queue[++front];
	}
	
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
		return queue[front + 1];  // front 증가 x
	}
	
	static int size() {
		return rear - front;
	}
	
}
