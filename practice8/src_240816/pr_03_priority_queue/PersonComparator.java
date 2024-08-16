package pr_03_priority_queue;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		// 내림차순
		return p2.age - p1.age;
	}
	
}
