//package Controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import Model.User;
//import View.IUserManager;
//import View.UserManagerImpl;
//
//public class UserUi {
//	private static UserUi instance;
//	
//	private UserUi() {}
//	
//	public static UserUi getInstance() {
//		if (instance == null) {
//			instance = new UserUi();
//		}
//		return instance;
//	}
//	
//	public static IUserManager um = UserManagerImpl.getInstance();
//    public static List<User> userList;
//    
//    static {
//    	um.loadUsersFromJson("data/user.json");
//    	userList = um.getUserList();
//    }
//    
//    static int userNo = userList.size() + 1;
//    
//    public static void 회원목록화면() {
//    	List<User> result = new ArrayList<>();
//    	result = um.getUserList();
//    	
//    	Util.printLine();
//    	for (User user : result)
//    		System.out.println("ID: " + user.getUserNo() + "\t이메일: " + user.getEmail() + "\t닉네임: " + user.getNickName());
//    	
//    	Util.printLine();
//    	System.out.println("0. 이전으로");
//    	Util.printLine();
//    	int menu = Util.inputInt("메뉴를 선택하세요: ");
//    	
//		switch (menu) {
//	    	case 0:
//	    		MainUi.앱메뉴화면();
//	    		break;
//	    	default:
//	            System.out.println("다시 고르세요");
//	            회원목록화면();
//	            break;
//		}
//    }
//	
//	public static void 로그인선택화면() {
//    	Util.printLine();
//    	System.out.println("1. 로그인");
//    	System.out.println("2. 회원가입");
//    	System.out.println("0. 종료");
//    	Util.printLine();
//    	int menu = Util.inputInt("메뉴를 선택하세요: ");
//    	
//		switch (menu) {
//	    	case 1: 
//	    		로그인화면();
//	    		break;
//	    	case 2: 
//	    		회원가입화면();
//	    		break;
//	    	case 0:
//	    		MainUi.서비스종료();
//	    		break;
//	    	default:
//	            System.out.println("다시 고르세요");
//	            로그인선택화면();
//	            break;
//		}
//	}
//	
//	public static void 로그인화면() {
//    	Util.printLine();
//    	String nickName = Util.input("닉네임을 입력하세요: ");
//    	String passWord = Util.input("비밀번호를 입력하세요: ");
//    	Util.printLine();
//    	
//    	boolean isValid = um.login(nickName, passWord);
//    		
//    	if (isValid == true) {
//    		MainUi.앱메뉴화면();
//    	}
//    	else
//    		로그인실패화면();
//    		
//    }
//	
//	public static void 로그인실패화면() {
//    	Util.printLine();
//    	System.out.println("1. 계속시도");
//    	System.out.println("0. 이전으로");
//    	Util.printLine();
//    	
//    	int menu = Util.inputInt("메뉴를 선택하세요: ");
//		switch (menu) {
//	    	case 1: 
//	    		로그인화면();
//	    		break;
//	    	case 0:
//	    		로그인선택화면();
//	    		break;
//	    	default:
//	            System.out.println("다시 고르세요");
//	            로그인실패화면();
//	            break;
//	}
//	}
//	
//	public static void 회원가입화면() {
//		String email = Util.input("이메일을 입력하세요: ");
//		
//		// Manager 에 넣어야 하는데.. 어떻게?
//        	if (!(email.contains("@"))) {
//        		System.out.println("올바른 이메일 형식이 아닙니다. 다시 시도해주세요.");
//        		회원가입화면();
//        	}
//    	for (User user : um.getUserList()) {
//            if (user.getEmail().equals(email)) {
//                System.out.println("이미 등록된 이메일입니다. 다시 시도해주세요.");
//                회원가입화면();
//            }
//        }
//		
//    	String nickName = Util.input("닉네임을 입력하세요: ");
//
//    	// Manager 에 넣어야 하는데.. 어떻게?
//        for (User user : um.getUserList()) {
//            if (user.getNickName().equals(nickName)) {
//                System.out.println("이미 등록된 닉네임입니다. 다시 시도해주세요.");
//                회원가입화면();
//                return;
//            }
//        }
//    	
//    	String passWord = Util.input("비밀번호를 입력하세요: ");
//    	
//    	User newUser = new User();
//    	
//    	newUser.setUserNo(userNo++);
//    	newUser.setEmail(email);
//    	newUser.setNickName(nickName);
//    	newUser.setPassWord(passWord);
//    	
//    	um.register(newUser);
//    	System.out.println("회원가입 성공!!");
//    	로그인선택화면();
//	}
//}
package Controller;

import java.util.List;
import Model.User;
import View.IUserManager;
import View.UserManagerImpl;

public class UserUi {
    private static UserUi instance;
    
    private UserUi() {}
    
    public static UserUi getInstance() {
        if (instance == null) {
            instance = new UserUi();
        }
        return instance;
    }
    
    public static IUserManager um = UserManagerImpl.getInstance();
    public static List<User> userList;
    
    static {
        um.loadUsersFromJson("data/user.json");
        userList = um.getUserList();
    }
    
    static int userNo = userList.size() + 1;

    // 메서드 명 변경 및 기능 수정
    public static void 회원정보조회() {
        User loggedInUser = getLoggedInUser();
        
        if (loggedInUser != null) {
            Util.printLine();
            System.out.println("ID: " + loggedInUser.getUserNo());
            System.out.println("이름: " + loggedInUser.getUserName());
            System.out.println("이메일: " + loggedInUser.getEmail());
            System.out.println("닉네임: " + loggedInUser.getNickName());
            Util.printLine();
        } else {
            System.out.println("로그인된 사용자가 없습니다.");
        }
        
        System.out.println("0. 이전으로");
        int menu = Util.inputInt("메뉴를 선택하세요: ");
        
        if (menu == 0) {
            MainUi.앱메뉴화면(loggedInUser.getNickName());
        } else {
            System.out.println("다시 고르세요");
            회원정보조회();
        }
    }

    public static void 로그인선택화면() {
        Util.printLine();
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("0. 종료");
        Util.printLine();
        int menu = Util.inputInt("메뉴를 선택하세요: ");
        
        switch (menu) {
            case 1: 
                로그인화면();
                break;
            case 2: 
                회원가입화면();
                break;
            case 0:
                MainUi.서비스종료();
                break;
            default:
                System.out.println("다시 고르세요");
                로그인선택화면();
                break;
        }
    }
    
    public static void 로그인화면() {
        Util.printLine();
        String nickName = Util.input("닉네임을 입력하세요: ");
        String passWord = Util.input("비밀번호를 입력하세요: ");
        Util.printLine();
        
        User user = um.login(nickName, passWord);
        
        if (user != null) {
            MainUi.앱메뉴화면(user.getNickName());
        } else {
            System.out.println("로그인 실패");
            로그인선택화면();
        }
    }
    
    public static void 회원가입화면() {
        Util.printLine();
        String username = Util.input("이름을 입력하세요: ");
        String email = Util.input("이메일을 입력하세요: ");
        String nickName = Util.input("닉네임을 입력하세요: ");
        String passWord = Util.input("비밀번호를 입력하세요: ");
        Util.printLine();
        
        if (validateUserInput(username, email, nickName, passWord)) {
            User user = new User(userNo++, username, email, nickName, passWord);
            um.register(user);
            um.saveUsersToJson("data/user.json");
            System.out.println("회원가입이 완료되었습니다.");
        } else {
            System.out.println("유효하지 않은 입력입니다. 다시 시도하세요.");
        }
        
        로그인선택화면();
    }
    
    private static boolean validateUserInput(String username, String email, String nickName, String passWord) {
        return !email.isEmpty() && !nickName.isEmpty() && !passWord.isEmpty() && !username.isEmpty();
    }
    
    private static User getLoggedInUser() {
        for (User user : um.getUserList()) {
            if (user.isLogin()) {
                return user;
            }
        }
        return null;
    }
}
