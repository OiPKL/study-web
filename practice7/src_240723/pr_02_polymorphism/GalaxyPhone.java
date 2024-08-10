package pr_02_polymorphism;

// 특정 인터페이스를 구현 => 인터페이스에 정의된 메서드(기능) 구현을 강제
public class GalaxyPhone implements AlarmSound {

	@Override
	public void playAlarm() {
		System.out.println("Ding Ding Ding");
	}
	
}