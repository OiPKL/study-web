package pr_02_try_catch;

public class ExceptionTest5 {

	public static void main(String[] args) {

		int[] nums = { 10 };

		// try ... catch ... catch

		try {
			System.out.println("정상 코드 1");
			System.out.println(nums[2]); // -> ArrayIndexOutOfBounds
			// Java 에서는 숫자를 0으로 나누면 예외 발생 -> ArithmeticException
			int i = 1 / 0;
			System.out.println("정상 코드 2");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			// 모든 예외 메세지를 확인하면서 프로그램은 정상 종료됨
			System.out.println("모든 예외 처리 가능");

		}
	}
}