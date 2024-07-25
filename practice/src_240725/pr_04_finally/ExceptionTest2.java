package pr_04_finally;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		// try ... catch ... finally => try with resources
		
		FileInputStream fis = null;
		
		// finally ~ close() 사용
		try {
			// 이 블록 안에서 선언된 변수 => 이 블록 안에서만 사용 가능
			fis = new FileInputStream("text.txt");
			
			// 메인 로직 작성
			
		} catch (FileNotFoundException e) {
			System.out.println("예외가 발생");
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// try with resources 사용
		try (FileInputStream fis2 = new FileInputStream("text.txt")){
			
			// 메인 로직 작성
			
		} catch (IOException e) {
			System.out.println("예외가 발생");
		}
		
	}
	
}
