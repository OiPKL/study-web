
public class BaseballPlayer {

	// 멤버변수
	private int number;
	private String name;
	private String position;
	private double battingAverage;
	
	// 기본생성자
	public BaseballPlayer() {

	}
	
	// 멤버변수를 파라미터로 받는 생성자
	public BaseballPlayer(int number, String name, String position, double battingAverage) {
		this.number = number;
		this.name = name;
		this.position = position;
		this.battingAverage = battingAverage;
	}

	// getter & setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	// toString 메서드 : 배열을 문자열로
	@Override
	public String toString() {
		return "BaseballPlayer [number=" + number + ", name=" + name + ", position=" + position + ", battingAverage="
				+ battingAverage + "]";
	}
	
}
