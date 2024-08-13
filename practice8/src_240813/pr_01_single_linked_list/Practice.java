package pr_01_single_linked_list;

class Node {
	String data;
	Node link;
}

class SingleLinkedList {
	Node head;
	int size;
	
	SingleLinkedList() {
		// 모든 새로운 노드는 head 뒤로 연결
		head = new Node();
	}
	
	// 삽입 : A-C-D 에 B 삽입
	void addData(int i, String data) {
		// i 인덱스에 노드 삽입 (노드-노드 사이를 가리킴)
		// - 0 : 맨 앞 (head - A 사이)
		// - 1 : (A - B 사이)
		// - size : 맨 뒤에 추가
		if (i < 0 || size < i) {
			System.out.println("삽입할 위치가 잘못되었습니다");
			return;
		}
		size++;
		
		// 선행노드 찾기
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 새 노드부터 연결
		// 순서 변경 시 뒤 노드의 연결이 끊어지게 됨..
		newNode.link = curr.link;
		curr.link = newNode;
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
		
		// 선행노드 찾기
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		
		// 선행노드의 링크에 삭제노드의 다음 노드를 연결
		curr.link = curr.link.link;
		
		// 삭제노드는 Garbage Collector 가 삭제
	}
	
	// 조회
	void printAll() {
		Node curr = head.link;
		
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}
	
}

public class Practice {
	public static void main(String[] args) {
		
		SingleLinkedList list = new SingleLinkedList();
		
		list.addData(0, "ㄱ");
		list.printAll();
		list.addData(0, "ㄴ");
		list.addData(0, "ㄷ");
		list.printAll();
		list.addData(0, "ㄹ");
		list.addData(0, "ㅁ");
		list.addData(0, "ㅂ");
		list.printAll();
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.printAll();
		
	}
}
