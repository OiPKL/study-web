package pr_09_comparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {

		// 순서 = 오름차순
		// 역순 = 내림차순
		return o1.name.compareTo(o2.name);
	}

}
