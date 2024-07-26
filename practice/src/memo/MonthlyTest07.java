package memo;

public class MonthlyTest07 {

	// int a 		=> static main 메서드에서 멤버변수 접근 X
	// static int a => static main 메서드에서 접근 가능
	static int a = 10;
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// 홀수 인덱스만 포함하는 배열
		int[] oddIdxArr = new int[5];
		// 짝수 인덱스만 포함하는 배열
		int[] evenIdxArr = new int[5];
		// oddIdxArr + evenIdxArr
		int[] sumArr = new int[5];
		
		{
			int a = 4;
			{
				int b = 5;
				System.out.println(a);
			}
		}
		
		System.out.println(a);	// >> a != 4 : 지역변수
		
	}
	
}
