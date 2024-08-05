package pr_01_exception;

public class ExceptionTest {

	public static void main(String[] args) {
		
		// 1. Unchecked Exception
		// - RuntimeException 자손들
		// - 저장 ~ 컴파일 O ~ 실행 X
		// - 컴파일러가 예외처리를 강제 X
		int[] nums = {10};
		System.out.println(nums[2]);
		
		// 2. Checked Exception
		// - Exception 자손 중 RuntimeException 자손은 아닌 애들
		// - 저장 ~ 컴파일 X (=빨간줄) ~ 실행 X
		// - 컴파일러가 예외처리를 강제 O
//		Class.forName("Hello");
//		Thread.sleep(1000);
		
	}
	
}
