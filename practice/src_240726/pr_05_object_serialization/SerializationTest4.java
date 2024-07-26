package pr_05_object_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationTest4 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("daisy", 3));
		list.add(new Person("max", 5));
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.dat"))){
			oos.writeObject(list);
			System.out.println("list : 생성 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
