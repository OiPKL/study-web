package pr_09_comparator;

public class Person extends Object{
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
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
