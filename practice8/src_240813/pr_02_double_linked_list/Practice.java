package pr_02_double_linked_list;

class Node {
	String data;
	Node prev;
	Node next;
}

class DoubleLinkedList {
	Node head;
	Node tail;
	int size;
	
	DoubleLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입 : A-C-D 에 B 삽입
	void addData(int i, String data) {
		// i 인덱스에 노드 삽입 (노드-노드 사이를 가리킴)
		// - 0 : 맨 앞 (head - A 사이)
		// - size : 맨 뒤에 추가
		if (i < 0 || size < i) {
			System.out.println("삽입할 위치가 잘못 되었습니다");
			return;
		}
		size ++;
		
		// 선행노드 찾기
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 새 노드 연결
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// 기존 노드 재구성
		curr.next.prev = newNode;
		curr.next = newNode;
	}
	
	// 삭제 : A-B-C-D 에서 B 삭제
	void removeData(int i) {
		// i 인덱스의 노드 삭제 (노드 그 자체를 가리킴)
		// - 0 : 맨 앞 노드
		// - size-1 : 맨 뒤 노드
		if (i < 0 || size <= i) {
			System.out.println("삭제할 위치가 잘못되었습니다");
			return;
		}
		size--;
		
		// 삭제노드 찾기
		Node rmNode = head.next;
		for (int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		
		// 삭제노드의 이전과 다음 노드를 연결
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;

		// 삭제노드는 Garbage Collector 가 삭제
	}
	
	// 조회
	void printReverseAll() {
		Node curr = tail.prev;
		
		String str = "";
		while (curr != head) {
			str = " <- " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
	
}

public class Practice {
	public static void main(String[] args) {
		
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.addData(0, "ㄱ");
		list.addData(0, "ㄴ");
		list.addData(0, "ㄷ");
		list.addData(0, "ㄹ");
		list.printReverseAll();
		list.removeData(1);
		list.removeData(1);
		list.printReverseAll();
		
	}
}
