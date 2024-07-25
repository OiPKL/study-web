package pr_03_throws;

public class ThrowsTest2 {

	// UncheckedException & Throws
	// - UncheckedException : 컴파일러가 예외 처리를 강제 X
	// - throws는 아무런 의미가 없음
	
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() {
		try {
			method2();
		} catch (ArithmeticException e) {
			System.out.println("method 1 에서 처리합니다");
		}
	}
	
	public static void method2() {
		
		// UncheckedException 발생
		int i = 1 / 0;
		
	}
	
}
