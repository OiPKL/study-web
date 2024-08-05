package pr_03_character_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest2 {

	public static void main(String[] args) {
		
		// 문자 스트림 : FileReader, FileWriter
		try(FileReader reader = new FileReader("big_input.txt");
			FileWriter writer = new FileWriter("big_input_3.txt")) {
			
			int c;	// 문자 버퍼 개수
			char[] buffer = new char[10];
			while((c = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, c);
			}
			System.out.println("복사 완료");
			
		} catch(IOException e) {
			
		}
		
	}
	
}
