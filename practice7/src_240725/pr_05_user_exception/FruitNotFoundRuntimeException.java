package pr_05_user_exception;

//RuntimeException : RuntimeException 상속
public class FruitNotFoundRuntimeException extends RuntimeException {

	public FruitNotFoundRuntimeException(String name) {
		super(name + "이 없습니다");
	}
	
}
