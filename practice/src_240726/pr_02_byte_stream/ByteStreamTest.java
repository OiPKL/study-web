package pr_02_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {

	public static void main(String[] args) {
		// byte stream 을 이용해서 이미지를 입출력
		// stream => close() => finally
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("dog.jpg");
			fos = new FileOutputStream("dog-copy.jpg");
			
			int b;	// byte 바구니
			
			// 하나의 바이트를 읽어와서 만약 있다면,
			// 하나의 바이트를 출력 스트림에 쓰기
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
			System.out.println("복사 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				fis.close();	// NullPointException:
//				fos.close();	// null.close() => RuntimeError 발생
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
