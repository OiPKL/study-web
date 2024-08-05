package pr_02_try_catch;

public class ExceptionTest {

	public static void main(String[] args) {
		
		int[] nums = {10};
		
		// try ... catch
		// 1. 예외 발생 O & 성공 (= catch 문 작동 O) : 1 (2) 4 5
		// 2. 예외 발생 O & 실패 (= catch 문 작동 X) : 1 2 -> 비정상 종료
		// 3. 예외 발생 X							: 1 2 3 5
		
		try {
			System.out.println("정상 코드 1");					// (1) 정상 코드
			System.out.println(nums[2]);					// (2) 예외 발생 가능 코드
			System.out.println("정상 코드 2");					// (3) 정상 코드
		} catch (ArrayIndexOutOfBoundsException e){
			// catch 문에서 매개변수 타입으로 정한 예외와 일치하거나 그 자손일 때
			// Exception => 모든 예외 처리 가능
			System.out.println("배열의 인덱스 범위를 벗어났어요");	// (4) 예외 처리 코드
		}
		System.out.println("프로그램 종료");					// (5) 외부 정상 코드
		
	}
	
}
