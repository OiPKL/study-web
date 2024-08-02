package practice_json22;
public class Gson {

	// 1. JRE System Library 폴더에 jar 파일을 복붙 (권장x)
	// 2. 프로젝트 외부의 jar 파일을 링크로 연결
	// - 프로젝트를 이사할 때 링크가 깨져서 인식이 안됨
	// 3. 프로젝트 내부에 jar 파일을 복사
	// - jar 파일 인식 시키기
	// - 프로젝트 우클릭 -> Build Path -> Configure Build Path
	//   > 라이브러리 탭 > ADD Jars ...
	// - 의존성 해결을 수동으로 해야함
	// 4. Maven 프로젝트로 만들고 pom.xml에 dependecies 추가
	// - 의존성 해결을 자동으로 해줌
	
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		// Java 객체를 -> JSON 문자열
		// JSON 문자열 -> Java 객체
		
		Person luna = new Person("Luna", 4);
		
		String lunaStr = gson.toJson(luna);
		
		System.out.println(luna);
		System.out.println(lunaStr);
		
	}
	
}
