package pr_08_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person("daisy", 3));
		persons.add(new Person("luna", 3));
		persons.add(new Person("max", 3));
		persons.add(new Person("alice", 2));
		
		System.out.println("******************** 정렬1 *******************");
		System.out.println(persons);
		
		System.out.println("******************** 정렬2 *******************");
		Collections.sort(persons);
		System.out.println(persons);
		
	}
}
