package ca.ubc.cpsc.mystuff.model;

public class User {
	private String username;
	private String password;

	public User() {
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
