package pr_03_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.age;
	}

	@Override
	// 매개변수 p : 상대방
	// (나, 상대방)
	public int compareTo(Person p) {
		// -1, 0, 1 셋 중 하나를 리턴
		// 0 : 같다
		// 1 : 위치를 바꾼다
		// -1 : 위치를 바꾸지 않는다
		
		// 오름차순
		return this.age - p.age;
//		if (this.age == p.age) return 0;
//		if (this.age > p.age) return 1;
//		return -1;
	}
	
}

public class Practice {
	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		minHeap.add(10);
		minHeap.add(20);
		minHeap.add(30);
		minHeap.add(-10);
		minHeap.add(40);
		
		while (!minHeap.isEmpty()) {
			int data = minHeap.poll();
			System.out.println(data);
		}
		
		System.out.println();
		System.out.println();
		
		maxHeap.add(10);
		maxHeap.add(20);
		maxHeap.add(30);
		maxHeap.add(-10);
		maxHeap.add(40);
		
		while (!maxHeap.isEmpty()) {
			int data = maxHeap.poll();
			System.out.println(data);
		}
		
		System.out.println();
		System.out.println();

		// 오름차순 compareTo
//		PriorityQueue<Person> personPQ = new PriorityQueue<>();
		// 내림차순 Comparator
//		PriorityQueue<Person> personPQ = new PriorityQueue<>(new PersonComparator());
		// 익명클래스
		PriorityQueue<Person> personPQ = 
				new PriorityQueue<>((p1, p2) -> {return p2.age - p1.age;});
		
		personPQ.add(new Person("루나", 3));
		personPQ.add(new Person("데이지", 1));
		personPQ.add(new Person("맥스", 8));
		
		// Person 클래스 -> 비교대상이 필요
		while (!personPQ.isEmpty()) {
			Person p = personPQ.poll();
			System.out.println(p);
		}
		
	}
}
