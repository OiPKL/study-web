package pr_04_pattern;

public class Pattern1 {

	public static void main(String[] args) {
		
		String text = "This iss a book";
		String pattern = "iss";
		
		System.out.println(bruteForce(text, pattern));	// 5
		System.out.println(bruteForce2(text, pattern));	// 5
		
	}
	
	// 시간 복잡도 : O(MN)
	static int bruteForce(String text, String pattern) {
		int ti = 0;		// text index
		int pi = 0;		// pattern index
		
		while (ti < text.length() && pi < pattern.length()) {
			if (text.charAt(ti) != pattern.charAt(pi)) {
				ti -= pi;	// -> pi + 1
				pi = -1;	// -> 0
			}
			ti++;
			pi++;
		}
		if (pi == pattern.length()) {
			// 성공
			return ti - pi;
		} else {
			// 실패
			return -1;
		}
	}
	
	static int bruteForce2(String text, String pattern) {
		int ti = 0;		// text index
		int pi = 0;		// pattern index
		int idx = -1;
		
		outer:
		for (ti = 0; ti < text.length(); ti++) {
			for (pi = 0; pi < pattern.length(); pi++) {
				if (pattern.charAt(pi) != text.charAt(ti + pi)) {
					continue outer;
				}
			}
			idx = ti;
		}
		return idx;
	}
	
}
