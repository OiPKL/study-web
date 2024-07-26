package pr_05_object_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest2 {

	public static void main(String[] args) {
		
		Student s = new Student("max", 3, "Java");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("max.dat"))){
			oos.writeObject(s);
			System.out.println("max : 생성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
