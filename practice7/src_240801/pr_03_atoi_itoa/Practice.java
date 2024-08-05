package pr_03_atoi_itoa;

public class Practice {

	public static void main(String[] args) {
		
		String strNum = "1234";
		System.out.println(0 + strNum);	// 01234
		
		// 문자열 -> 정수 : parseInt & atoi
		int num = Integer.parseInt(strNum);
		System.out.println(0 + num);	// 1234
		
		int result = atoi(strNum);
		System.out.println(result); 	// 1234
		
		
		// 정수 -> 문자열 : valueOf & itoa
		int intVar = 4321;
		String intStr = String.valueOf(intVar);
		System.out.println(intStr); 	// 4321
		
		String result2 = itoa(intVar);
		System.out.println(result2);
		
	}

	static int atoi(String str) {
		// str.charAt(0) == '-' : 음수일 경우?? i = 1 ~ (N-1) 
		// 마지막에 (-1) 곱하기 ??
		
		int N = str.length();
		int num =0;
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);
			// c 가 정수로 표현할 수 있는 문자인지 확인 (ASCII 코드 이용)
			// 0 -> 1 -> 12 -> 123 -> 1234
			if ('0' <= c && c <= '9') {
				num = (num * 10) + (c - '0');
			} else {
				return -99999999;
			}
		}
		return num;
	}
	
	static String itoa(int num) {
		
		int tmp = num;
		int length = 0;
		while (tmp > 0) {
			length++;
			tmp /= 10;
		}
		
		char[] str = new char[length];
		int idx = length - 1;
		while (num > 0) {
			str[idx--] = (char)('0' + (num % 10));
			num /= 10;
		}
		
		return new String(str);
	}
	
}
