package cs445.project.facilitator;

import java.util.List;

import cs445.project.base.User;

public class UserFacilitator {
	
	DBSaveRestore dbSaveRestore;
	
	public UserFacilitator () {
		dbSaveRestore = new DBSaveRestore();
	}
	
	public boolean isUserPresent(User user) {
		boolean isUserPresent = false;
		
		List<User> users = dbSaveRestore.getAllUsers();
		for(User u: users) {
			if(user.getEmail().compareTo(u.getEmail()) == 0) {
				//User already exist
				isUserPresent = true;
				break;
			}
		}
		
		return isUserPresent;
	}
	
	public Integer addUser(User user) {
		Integer userId = 0 ;	
		
		if(isUserPresent(user) == false) {
			userId = dbSaveRestore.addUser(user);
		}
		
		return userId;		
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		
		List<User> users = dbSaveRestore.getAllUsers();
		for(User u: users) {
			if(email.compareTo(u.getEmail()) == 0) {
				//User already exist
				user = u;
				break;
			}
		}
		
		return user;
	}
	
	public void changeUserDetails(User user) {		
		dbSaveRestore.updateUser(user);
	}
	
	public List<User> getAllUsers() {
		return dbSaveRestore.getAllUsers();
	}
	
	public User getUserById(Integer userId) {
		return dbSaveRestore.getUserById(userId);
	}
}
