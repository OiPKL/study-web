package pr_01_file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		
		// File : 파일 & 디렉토리 관리 클래스
		File f = new File("dog.jpg");	// 상대경로
		System.out.println("exists: \t" + f.exists());
		System.out.println("isFile: \t" + f.isFile());
		System.out.println("isAbsolute: \t" + f.isAbsolute());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.length() + " bytes");
		
		System.out.println();
		File src = new File("src");
		System.out.println("exists: \t" + src.exists());
		System.out.println("isDirectory: \t" + src.isDirectory());
		
		System.out.println();
		File folder = new File("folder");
		System.out.println("exists: \t" + folder.exists());
		folder.mkdir();
		
	}
	
}
