package pr_01_list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		// List - ArrayList LinkedList
		// 배열 : 사이즈 고정 vs 리스트 : 사이즈 조절 가능
		// 특징 : 순서O 중복O
		
		// Array & ArrayList
		// 특징 : 같은 타입의 데이터를 묶어 사용
		// 장점 : 빠른 속도
		// 단점 : 데이터 추가 시, 새로운 배열을 만들고 복사
		// 	   : 데이터 삭제 시, 인덱스 재조정을 위해 전체 데이터를 올김
		
		// LinkedList
		// 특징 : 각 요소를 Node 로 정의하고 Node 는 다음 요소의 참조 값과 데이터로 구성
		//     : 각 요소가 다음 요소의 링크 정보를 가지며 연속적으로 구성될 필요없음
		
		List<String> names = new ArrayList<String>();
		
		names.add("luna");
		names.add("max");
		names.add("daisy");
		names.add("max");
		System.out.println("******************** 추가 ********************");
		System.out.println("isEmpty: " + names.isEmpty());
		System.out.println(names);
		
		names.set(0, "emily");
		System.out.println("******************** 수정 ********************");
		System.out.println(names);
		
		System.out.println("******************** 조회 ********************");
		System.out.println(names.get(3));
		
		System.out.println("******************** 순회 ********************");
		for(String name : names) {
			System.out.println(name);
		}
		
		names.remove(0);
		System.out.println("****************** 인덱스 삭제 ******************");
		System.out.println(names);
		
		names.remove("daisy");
		System.out.println("******************* 값 삭제 *******************");
		System.out.println(names);
		
		names.remove("max");
		System.out.println("***************** 똑같은 값 삭제 *****************");
		System.out.println(names);
		
		names.clear();
		System.out.println("******************* 전체삭제 *******************");
		System.out.println(names);
		System.out.println("isEmpty: " + names.isEmpty());
		
		names.add("max");
		names.add("max");
		names.add("luna");
		
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i).equals("max"))
				names.remove(i);
		}	// 중복된 값을 삭제할 때 -> 리스트의 사이즈가 줄고 인덱스가 재정렬 됨
		System.out.println("******************* 주의사항 *******************");
		System.out.println(names);
		
		for (int i = names.size() - 1; i >= 0; i--) {
		if(names.get(i).equals("max"))
			names.remove(i);
		}	// 역순으로 삭제 -> 이미 탐색한 인덱스에 영향을 미치지 않음
		System.out.println("******************* 주의사항 *******************");
		System.out.println(names);
		
	}
}




