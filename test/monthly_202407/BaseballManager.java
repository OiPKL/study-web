import java.util.ArrayList;
import java.util.List;

public class BaseballManager {

	// ArrayList 생성
	List<BaseballPlayer> baseballTeam = new ArrayList<>();
	
	// 싱글턴 패턴 : 하나의 인스턴스만 생성되도록 private로 선언
	private static BaseballManager instance = new BaseballManager();
	
	// 기본 생성자
	private BaseballManager() {
		
	}
	
	// 생성된 단 하나의 인스턴스를 호출
	public static BaseballManager getInstance() {
		return instance;
	}
	
	public boolean addPlayer(BaseballPlayer player) /*throws LimitOverException*/ {
		
		// for-catch : LimitOverException 미구현 ..
		if (player != null) {
			baseballTeam.add(player);
			return true;
		} else
			return false;
		
	}
	
	public boolean removePlayer(int number) {

		// baseballTeam 을 순회하면서 해당 number 가 존재하는지 확인 -> idx
		int idx = 0;
		for (int i = 0; i < baseballTeam.size(); i++)
			if (baseballTeam.get(i).getNumber() == number)
				idx = i;
		
		// 기존의 배열을 보호하도록 새로운 배열 생성
		List<BaseballPlayer> tempList = new ArrayList<>();
		
		// number가 존재한다면 idx 만 뺀 size-1 배열을 새로운 배열에 넣고, 해당 idx는 null로 변경
		if (idx != 0) {
			for (int i = 0; i < idx; i++)
				tempList.add(baseballTeam.get(i));
			for (int i = idx + 1; i < baseballTeam.size() - 1; i++)
				tempList.add(baseballTeam.get(i));
			baseballTeam.set(idx, null);
			return true;
		} else
			return false;
		
	}

	public BaseballPlayer getPlayerInfo(int number) /*throws NotFoundPlayer*/ {
		
		// for-catch : NotFoundPlayer 미구현 ..
		// 기존의 객체를 보호하도록 새로운 객체 생성
		BaseballPlayer result = new BaseballPlayer();

		// baseballTeam 을 순회하면서 해당 number 가 존재하는지 확인 -> idx
		int idx = 0;
		for (int i = 0; i < baseballTeam.size(); i++)
			if (baseballTeam.get(i).getNumber() == number)
				idx = i;
			else return null;
		
		result = baseballTeam.get(idx);
		return result;
		
	}
	
	public boolean updatePlayer(int number, double battingAverage) {
		
		// 기존의 객체를 보호하도록 새로운 객체 생성
		BaseballPlayer result = new BaseballPlayer();
		
		// baseballTeam 을 순회하면서 해당 number 가 존재하는지 확인 -> idx
		int idx = 0;
		for (int i = 0; i < baseballTeam.size(); i++)
			if (baseballTeam.get(i).getNumber() == number)
				idx = i;
			else return false;
		
		// setter로 업데이트
		result.setBattingAverage(battingAverage);
		return true;
		
	}
	
}
