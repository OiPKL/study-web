package pr_04_finally;

public class ExceptionTest {

	public static void main(String[] args) {

		int[] nums = { 10 };

		// try ... catch ... finally
		// 1. 정상 실행 					 	: 1 2 4 5
		// 2. 예외 발생 & 성공 (= catch 문 작동 O) : 1 3 4 5
		// 3. 예외 발생 & 실패 (= catch 문 작동 X) : 1 4 -> 비정상 종료
		// 4. 정상 실행 & try 문에 return 존재		: 1 2 4 -> finally는 실행됨
		// 5. 예외 발생 & 성공 & return 존재		: 1 3 4 -> finally는 실행됨

		try {
			System.out.println("1");
			nums[0] = 40;
//			int i = 1 / 0;
			System.out.println("2");
//			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("3");
			return;
		} finally {
			System.out.println("4");
		}
		System.out.println("5");

	}

}
