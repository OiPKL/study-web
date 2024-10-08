package pr_05_restriction;

// 제네릭 클래스
// < > 안에 타입 파라미터
class Box <T extends Number> {
	private T t;
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	// 제네릭 메서드
	public <U> void printClassName(U item) {
		System.out.println("Item type: " + item.getClass().getName());
	}
	
}

public class BoxTest {
	public static void main(String[] args) {
	
		Box<Integer> intBox = new Box<>();
			
	}
}