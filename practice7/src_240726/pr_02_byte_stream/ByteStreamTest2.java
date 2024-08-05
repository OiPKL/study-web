package pr_02_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest2 {

	public static void main(String[] args) {
		
		// try with resources
		
		try(FileInputStream fis = new FileInputStream("dog.jpg");
			FileOutputStream fos = new FileOutputStream("dog-copy-2.jpg");
			){
			
			int b;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
			System.out.println("복사 완료");

		} catch(IOException e) {
			
		}
		System.out.println("스트림 자동 종료");
		
	}
	
}
