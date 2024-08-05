package pr_01_interface;

// 인터페이스 그 자체로는 객체 생성이 안되므로 일반 클래스에 의해 구현해야 함
// 상속 : 클래스 extends 상위클래스
// 구현 : 클래스 implements 인터페이스
public class MyClass implements MyInterface {
	
	// 1. 인터페이스의 모든 추상 메서드를 재정의
	// 2. 추상 클래스로 남는다

	@Override
	public void method1() {
		
	}
	
	@Override
	public void method2() {
		
	}
	
	// default 메서드 : 재정의 가능
//	@Override
//	public void method3() {
//
//	}
	
}
