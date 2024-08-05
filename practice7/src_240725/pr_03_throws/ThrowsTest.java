package pr_03_throws;

public class ThrowsTest {

	// CheckedException & Throws
	// - CheckedException : 컴파일러가 예외 처리를 강제 (하지 않으면 컴파일 진행 X)
	// - 선택지 2가지 : 1. try~catch로 예외처리, 2. throws로 전달
	
	// throws 의미
	// - 1. (메서드르 정의하는 프로그래머):
	//      이 메서드를 여기에서 사용 X ~ 메서드를 사용할 사람이 예외를 처리해서 쓰도록
	// - 2. (메서드를 사용하는 프로그래머):
	//      이 메서드는 CheckedException을 발생시킬 수 있는 메서드구나
	//      이 메서드를 사용하려면 예외 처리가 필요
	// - 3. (컴파일러):
	//      CheckedException은 무조건 처리해야 하지만
	//      이 메서드 본문 안에서는 봐주지만 .. 메서드 호출하는 쪽에서는 안 봐줌
	//      프로그램의 시작점인 main 메서드에서 조차 throws => 비정상 종료
	
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() /*throws ClassNotFoundException*/ {
		method2();
	}
	
	public static void method2() /*throws ClassNotFoundException*/ {
		
		// CheckedException 발생
//		Class.forName("Hello");
		
	}
	
}
