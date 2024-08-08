package pr_01_circular_queue;

public class Practice {
	
	// 총 넣을 수 있는 개수 : 4(X) 3(O)
	static String[] queue = new String[4];
	static int front, rear;
	static int N = queue.length;
	static int size;
	
	public static void main(String[] args) {

		
		
	}
	
	static boolean isEmpty() {
		return front == rear;
	}
	
	static boolean isFull() {
//		return (front - rear + N) % N == 1;
		return front == (rear + 1) % N;
	}
	
	static void enQueue(String item) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다");
			return;
		}
		size++;
//		queue[++rear] = item; -> 순환 필요
		rear = (rear + 1) % N;
		queue[rear] = item;
	}
	
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
		size--;
//		return queue[++front]; -> 순환 필요
		front = (front + 1) % N;
		String item = queue[front];
		queue[front] = null;
		return item;
	}
	
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
//		return queue[front + 1]; -> 순환 필요
		return queue[(front + 1) % N];
	}

	static int size() {
//		or size 변수 이용
//		return rear - front; -> 순환 필요
		return (rear - front + N) % N;	// 음수 방지
	}
	
}
