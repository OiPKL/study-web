package pr_05_object_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) {
		Person p = new Person("luna", 5);
		
		// 객체->파일 저장 : Object -> Byte -> File
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("luna.dat"))){
			oos.writeObject(p);
			System.out.println("luna : 생성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
