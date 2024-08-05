package pr_02_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest3 {

	public static void main(String[] args) {
		
		// try with resources
		// buffer => 속도가 빨라짐
		
		try(FileInputStream fis = new FileInputStream("dog.jpg");
			FileOutputStream fos = new FileOutputStream("dog-copy-3.jpg");
			){
			
			int b;
			byte[] buffer = new byte[10];
			while((b = fis.read(buffer)) != -1) {
				System.out.println(b);
				fos.write(buffer, 0, b);
			}
			// >> 10 10 10 10 10 10 10 2 : 마지막은 2만큼만
			System.out.println("복사 완료");

		} catch(IOException e) {
			
		}
		System.out.println("스트림 자동 종료");
		
	}
	
}
