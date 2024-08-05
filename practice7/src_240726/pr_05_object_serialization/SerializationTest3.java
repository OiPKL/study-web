package pr_05_object_serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationTest3 {

	public static void main(String[] args) {
		Person p = new Person("luna", 5);
		
		// 파일->객체 불러오기
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("luna.dat"))){
			// 실제 해당 클래스의 객체를 생성하는데 박스만 Object
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
