package pr_02_try_catch;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		int[] nums = {10};
		
		// try ... catch ... catch
		
		try {
			System.out.println("정상 코드 1");
			System.out.println(nums[2]);	 // -> ArrayIndexOutOfBounds
			// Java 에서는 숫자를 0으로 나누면 예외 발생 -> ArithmeticException
			int i = 1 / 0;
			System.out.println("정상 코드 2");	
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("배열의 인덱스 범위를 벗어났어요");
		} catch (ArithmeticException e) {
			System.out.println("잘못된 계산식입니다");
		}
		System.out.println("프로그램 종료");
		
	}
	
}
