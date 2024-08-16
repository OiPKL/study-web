package pr_02_min_heap;

public class Practice {
	
	static int[] heap = new int[100];
	static int heapSize = 0;
	
	public static void main(String[] args) {
		
		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);
		int size = heapSize;
//		// pop -> 힙 사이즈가 줄어들기 때문에 고정값을 가지는 변수에 할당
//		for (int i = 0; i < size; i++) {
//			int popItem = heapPop();
//			System.out.println(popItem);
//		}
		while (heapSize != 0) {
			int popItem = heapPop();
			System.out.println(popItem);
		}
	}
	
	// swap 메서드
	static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	// 삽입 연산
	static void heapPush(int data) {
		// 1. 완전이진트리 마지막에 data 추가
		heap[++heapSize] = data;
		int p = heapSize / 2;
		int ch = heapSize;
		// 2. 부모와 비교해서 자식이 더 작으면 swap 반복
		// - 자식이 루트노드가 아닌 경우에만
		while (ch != 1 && heap[p] > heap[ch]) {
			swap(p, ch);
			// 3. swap 이후 인덱스 갱신
			ch = p;
			p = ch / 2;
		}
	}
	
	// 삭제 연산
	static int heapPop() {
		// 1. 루트에 있는 데이터 저장
		int popItem = heap[1];
		// 2. 마지막 노드를 루트로 옮기기
		heap[1] = heap[heapSize--];
		// 3. 자식과 비교해서 자식이 더 작으면 swap 반복
		// - 자식이 둘 이상이면 더 작은 자식과 swap
		int p = 1;
		int ch = p * 2;
		
		if (ch + 1 <= heapSize && heap[ch] > heap[ch+1])
			ch++;
		// - 자식이 heapSize 내에 있는 경우에만
		while (ch <= heapSize && heap[ch] < heap[p]) {
			swap(p, ch);
			// 4. swap 이후 인덱스 갱신
			p = ch;
			ch = p * 2;
			
			if (ch + 1 <= heapSize && heap[ch] > heap[ch+1])
				ch++;
		}
		
		return popItem;
	}
	
}
