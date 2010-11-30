package ca.ubc.cpsc.mystuff.model;

public class UserService {
	public void add(User user) {
		
	}
	
	public void delete() {
		
	}
	
	public boolean verify(User user) {
		User user1 = new User(0, 0, "Jeff", "Payan", "Canada", "jpayan", "imafag", 0, 0, null);
		User user2 = new User(0, 1337, "Stephen", "Kidson", "Canada", "skidson", "imsocool", 1, 1, null);
		if((user.getUsername().equals(user2.getUsername()) && 
				user.getPassword().equals(user2.getPassword()) ||
				(user.getUsername().equals(user1.getUsername()) &&
				user.getPassword().equals(user1.getPassword())))) {
			return true;
		}
		return false;
	}
}
