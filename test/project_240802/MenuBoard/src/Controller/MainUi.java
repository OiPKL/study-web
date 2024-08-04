package Controller;

import java.util.List;

import Model.User;
import View.IUserManager;
import View.UserManagerImpl;

public class MainUi {
	
	private MainUi() {}
	
	public static IUserManager um = UserManagerImpl.getInstance();
    public static List<User> userList;
    
    static {
    	um.loadUsersFromJson("data/user.json");
    	userList = um.getUserList();
    }
	
    
	public static void 서비스시작() {
		Util.printLine();
		System.out.println("자바로 구현하는 SSAFIT");
		Util.printLine();
		UserUi.로그인선택화면();
    }

	
    public static void 서비스종료() {
    	System.out.println("종료합니다.");
    }

    
    public static void 앱메뉴화면(String nickname) {
    	Util.printLine();
    	System.out.println(nickname + "님, 반갑습니다");
    	System.out.println("1. 영상정보");
    	System.out.println("2. 회원정보");
    	System.out.println("0. 로그아웃");
    	Util.printLine();
    	int menu = Util.inputInt("메뉴를 선택하세요: ");
    	
		switch (menu) {
        	case 1: 
        		VideoUi.영상정보메인화면(nickname);
        		break;
        	case 2: 
        		UserUi.회원정보조회();
        		break;
        	case 0:
                for (User user : um.getUserList()) {
                    if (user.isLogin()) {
                        user.setLogin(false); // 현재 로그인된 사용자의 상태를 false로 변경
                        um.saveUsersToJson("data/user.json");
                        break;
                    }
                }
        		System.out.println("로그아웃 성공");
        		UserUi.로그인선택화면();
        		break;
        	default:
        		System.out.println("다시 고르세요");
        		앱메뉴화면(nickname);
        		break;
		}
    }  
}