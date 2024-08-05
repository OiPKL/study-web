package pr_03_inheritance;

public interface Speakable {

	// 인터페이스의 다중 상속 시 시그니처(반환형, 메서드, 매개변수)가 겹처도
	// 구현부가 없기 때문에 상관없음
	// => 클래스가 인터페이스를 구현하는 시점에 메서드 내용을 정의하면 됨
	void eat();
	void speak();
	
}
