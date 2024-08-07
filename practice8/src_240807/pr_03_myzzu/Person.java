package pr_03_myzzu;

public class Person {
	int no;
	String name;
	int myzzu;
	
	public Person() {

	}
	
	public Person(int no, String name, int myzzu) {
		this.no = no;
		this.name = name;
		this.myzzu = myzzu;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMyzzu() {
		return myzzu;
	}

	public void setMyzzu(int myzzu) {
		this.myzzu = myzzu;
	}

	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", myzzu=" + myzzu + "]";
	}
	
}
