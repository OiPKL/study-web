package pr_05_object_serialization;

public class Student extends Person{
	
	private static final long serialVersionUID = 1L;
	private String major;
	
	public Student() {

	}
	
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [major=" + major + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

}
