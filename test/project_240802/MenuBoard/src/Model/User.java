package Model;

public class User {
	private int userNo;
	private String userName;
	private String email;
	private String nickName;
	private String passWord;
	private boolean isLogin = false;

	public User(int userNo, String userName, String email, String nickName, String passWord) {
		this.userNo = userNo;
		this.userName = userName;
		this.email = email;
		this.nickName = nickName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userName=" + userName + ", email=" + email + ", nickName=" + nickName
				+ ", passWord=" + passWord + ", isLogin=" + isLogin + "]";
	}

}
