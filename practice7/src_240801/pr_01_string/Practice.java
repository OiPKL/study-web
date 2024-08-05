package pr_01_string;

public class Practice {

	public static void main(String[] args) {
		
		// 문자열의 초기화
		String lstr1 = "Hello";
		String lstr2 = "Hello";
		
		String nstr1 = new String("Hello");
		String nstr2 = new String("Hello");
		
		// 리터럴 : 문자열 상수 풀에서 관리
		System.out.println(lstr1 == lstr2);
		// new : 힙 영역에 새 공간을 할당
		System.out.println(nstr1 == nstr2);
		
		System.out.println(lstr1.equals(lstr2));
		System.out.println(nstr1.equals(nstr2));
		
	}
	
}
