package View;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Model.User;

public class UserManagerImpl implements IUserManager {
    private List<User> userList = new ArrayList<User>();
    
    private static IUserManager instance = new UserManagerImpl();

    private UserManagerImpl() {
    	loadUsersFromJson("data/user.json");
    }

    public static IUserManager getInstance() {
        if (instance == null) {
            instance = new UserManagerImpl();
        }
        return instance;
    }
    
    @Override
    public List<User> getUserList() {
    	List<User> result = new ArrayList<User>();
    	
    	for (int i = 0; i < userList.size(); i++)
    		result.add(userList.get(i));
    	
    	return result;
    }
    
	@Override
	public int register(User user) {
        userList.add(user);
        saveUsersToJson("data/user.json");
        return user.getUserNo();
	}

	@Override
	public User login(String nickName, String passWord) {
	    for (User user : userList) {
	        if (user.getNickName().equals(nickName)) {
	            if (user.getPassWord().equals(passWord)) {
	            	user.setLogin(true); 						// 로그인 상태 변경
	                System.out.println("로그인 성공!!");
	                return user;
	            } else {
	                System.out.println("잘못된 비밀번호입니다.");
	                return null;
	            }
	        }
	    }
	    System.out.println("일치하는 닉네임이 없습니다.");
	    return null;
	}

    @Override
    public void loadUsersFromJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            userList = gson.fromJson(reader, userListType);
            if (userList == null) {
                userList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            userList = new ArrayList<>();
        }
    }

    @Override
    public void saveUsersToJson(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
