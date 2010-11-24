package ca.ubc.cpsc.mystuff.model;

public class UserBean {
	private String username;
	private String password;

	public UserBean() {
		username = null;
		password = null;
	}

	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUsername() { return username; }
	public String getPassword() { return password; }
}
