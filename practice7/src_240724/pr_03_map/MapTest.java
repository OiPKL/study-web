package pr_03_map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		
		// Map - HashMap TreeMap
		// 특징 : 순서X 중복X (Value는 중복O)
		//     : Key(키) 와 Value(값)를 하나의 Entry로 묶어 데이터 관리
		// 장점 : 빠른 속도
		
		// 키의 자료형으로 사용자 정의 클래스를 사용하는 경우 => hashCode & equals 오버라이드
		Map<String, String> map = new HashMap<>();
		
		map.put("luna", "cat");
		map.put("max", "dog");
		map.put("daisy", "cow");
		map.put("toby", "cat");
		map.put("luna", "dog");
		
		// 같은 키에 새로운 값을 넣으면 새로운 값으로 수정
		System.out.println("******************** 추가 ********************");
		System.out.println(map);
		
		System.out.println("******************** 조회 ********************");
		System.out.println("daisy: \t" + map.get("daisy"));
		
		System.out.println("******************* 키 확인 *******************");
		System.out.println("max: \t" + map.containsKey("max"));
		
		System.out.println("******************* 값 확인 *******************");
		System.out.println("horse: \t" + map.containsValue("horse"));
		System.out.println("dog: \t" + map.containsValue("dog"));
		
		System.out.println("******************** 순회1 *******************");
		// 1. keySet()
		for (String key : map.keySet()) {
			System.out.printf("%s : %s \n", key, map.get(key));
		}
		
		System.out.println("******************** 순회2 *******************");
		// 2. entrySet() => Entry : Key-Value
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.printf("%s : %s \n", entry.getKey(), entry.getValue());
		}
		
	}
}
