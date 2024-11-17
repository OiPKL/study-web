package test_03;

public class Test3 {

	public static void main(String[] args) {
		
		BaseballManager bm = BaseballManager.getInstance();
		
		BaseballPlayer bp1 = new BaseballPlayer(1, "김싸피", "1루수", 0.1);
		BaseballPlayer bp2 = new BaseballPlayer(2, "박싸피", "2루수", 0.2);
		BaseballPlayer bp3 = new BaseballPlayer(3, "최싸피", "3루수", 0.3);
		
		bm.addPlayer(bp1);
		bm.addPlayer(bp2);
		bm.addPlayer(bp3);
		
		System.out.println(bp1.toString());
		System.out.println(bp2.toString());
		System.out.println(bp3.toString());
		
		System.out.println();
		bm.removePlayer(3);
		
		System.out.println(bp1.toString());
		System.out.println(bp2.toString());
		System.out.println(bp3.toString());
		
		System.out.println(bm.getPlayerInfo(1));
		System.out.println(bm.getPlayerInfo(2));
		System.out.println(bm.getPlayerInfo(3));
		
		System.out.println(bm.updatePlayer(2, 0.5));
		System.out.println(bm.getPlayerInfo(2));
		
	}
	
}
