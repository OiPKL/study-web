package pr_07_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		
		// Sort
		// 특징 : 순서를 가지는 Collection 만 정렬 가능
		//     : 자료들을 특정 기준에 맞춰 오름차순 or 내림차순 정렬
		//     : 문자 => 정수로 표현 이용(0~65535)
		
		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person("daisy", 3));
		persons.add(new Person("luna", 5));
		persons.add(new Person("max", 6));
		persons.add(new Person("alice", 2));
		
		System.out.println("******************** 정렬1 *******************");
		System.out.println(persons);
		
		// 사용자 정의 클래스 사용하는 경우 => 기본적으로는 정렬 X
		// => Comparable 인터페이스 or Comparator 클래스 정의 필요
		// => 비교 기준이 없으므로 사용자 정의 클래스에 비교 기준 필요
//		System.out.println("******************** 정렬2 *******************");
//		Collections.sort(persons);
//		System.out.println(persons);
		
	}
}
