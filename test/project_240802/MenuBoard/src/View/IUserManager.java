package View;

import java.util.List;

import Model.User;

public interface IUserManager {
	
	List<User> getUserList();
	
	int register(User user);
	
	User login(String nickName, String password);
	
	void loadUsersFromJson(String filePath);
	
	void saveUsersToJson(String filePath);

}
