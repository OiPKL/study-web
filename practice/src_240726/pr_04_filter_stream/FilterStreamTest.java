package pr_04_filter_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilterStreamTest {
	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}
	
	private static void method1() {
		try (Scanner sc = new Scanner(new FileInputStream("big_input.txt"))){
			long start = System.nanoTime();
			
			while(sc.hasNext()) {
				int num =sc.nextInt();
			}
			
			long end = System.nanoTime();
			System.out.println("복사 완료");
			System.out.println(end - start);	// >> 43565600
			
		} catch(IOException e) {
			
		}
		
	}

	private static void method2() {
		
		// 문자 스트림: FileReader, FileWriter
		try(FileReader reader = new FileReader("big_input.txt");
			FileWriter writer = new FileWriter("big_input_2.txt")) {
			
			long start = System.nanoTime();
			
			int c; // 문자 전달 바구니
			while((c = reader.read())!= -1) {
				writer.write(c);
			}
			
			long end = System.nanoTime();
			System.out.println("복사 완료");
			System.out.println(end - start);	// >> 39925000
			
		} catch (IOException e) {
			
		}
		
	}
	
	private static void method3() {
		
		// 버퍼 기능 추가: BufferedReader, BufferedWriter
		try(BufferedReader reader = new BufferedReader(new FileReader("big_input.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("big_input_2.txt"))) {
			
			long start = System.nanoTime();
			
			String line; // 줄 단위 입력
			while((line = reader.readLine())!= null) {
				writer.write(line);
				writer.newLine();
			}
			
			long end = System.nanoTime();
			System.out.println("복사 완료");
			System.out.println(end - start);	// >> 5732000
			
		} catch (IOException e) {
			
		}
	}
	
}
