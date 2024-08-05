package pr_02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		
		// Set - HashSet TreeSet
		// 특징 : 순서X 중복X
		// 	   : 집합을 나타내는 자료구조
		//     : 구현체로 HashSet을 사용
		// 장점 : 빠른 속도, 효율적인 중복 데이터 제거
		// 단점 : 단순 집합의 개념으로 정렬하려면 별도의 처리가 필요
		
		Set<String> names1 = new HashSet<>();
		
		names1.add("luna");
		names1.add("max");
		names1.add("luna");
		names1.add("daisy");
		names1.add("max");
		
		System.out.println("******************** 추가1 *******************");
		System.out.println(names1);
		
		Set<Person> names2 = new HashSet<>();
		
		names2.add(new Person("luna", 3));
		names2.add(new Person("luna", 3));
		
		// Set 동일성 판단 : hashCode 같으면서 equals 또한 같아야 함
		// 사용자 정의 클래스를 사용하는 경우 => hashCode & equals 오버라이드 필요
		System.out.println("******************** 추가2 *******************");
		System.out.println(names2);
		
	}
}
