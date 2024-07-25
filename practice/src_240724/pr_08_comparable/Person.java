package pr_08_comparable;

public class Person implements Comparable<Person>{
	String name;
	int age;
		
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		// 같은 String 에서는 같은 해시코드
		// => name 해시코드 사용해서 구별
		return name.hashCode();
	}

	// 비교하는 obj == Person ? True : False
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return this.age == p.age;
		}
		return false;
	}

	@Override
	public int compareTo(Person o) {
		
		// 1. 나이 순
		// 나 자신 - 비교대상 나이 => 오름차순 정렬
		// 비교대상 - 나 자신 나이 => 내림차순 정렬
		// 2. 이름 순
		// String에 정의되어 있는 비교 메서드 사용
		if (this.age == o.age) {
//			return this.name.compareTo(o.name) * -1;	// 내림차순
			return this.name.compareTo(o.name) * 1;		// 오름차순
		}
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
