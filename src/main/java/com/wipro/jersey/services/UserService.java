package com.wipro.jersey.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.wipro.jersey.client.UserResourceClient;
import com.wipro.jersey.exception.BadRequestException;
import com.wipro.jersey.model.User;

public class UserService {
	
//	static private Map<String, User> db = new HashMap<String, User>();

	static private List<User> usersList = new ArrayList<User>();
	
	
	static {
		
//		db.put("100", new User(100, "A", "01/01/2020", "US") );
//		db.put("101", new User(101, "B", "02/02/2020", "IN"));
//		db.put("102",new User(102, "C", "03/03/2020", "GE"));
//		
		usersList.add(new User(100, "A", "01/01/2020", "US"));
		usersList.add(new User(101, "B", "02/02/2020", "IN"));
		usersList.add(new User(102, "C", "03/03/2020", "GE"));
	}
	
	

	public List<User> fetchAll() {
		for(User user2 : usersList) {
			user2.setCountryName(new UserResourceClient().fetchCountryName(user2.getCountryCode()));
		}
		return usersList;
	}

	public User fetchBy(long id) throws NotFoundException {
		
		User user = doesUserExist(id);
		if (user == null) {
			throw new NotFoundException("Resource not found with Id :: " + id);
		}
		else {
			return user;
		}

		
	}

	public void create(User user) throws BadRequestException{
			if(doesUserExist(user.getId()) != null){
				throw new BadRequestException(400, "user with the id:"+user.getId()+" already exist, try with different id");
			}
			else {
				usersList.add(user);
			}	
		
	}

	public void update(User user) {
		for (User user2 : usersList) {
			if (user.getId() == user2.getId()) {
				usersList.remove(user2);
				usersList.add(user);
			}
		}
	}

	public void delete(long id) throws NotFoundException {
		
		usersList.remove(fetchBy(id));
		
	}
	
	private User doesUserExist(long id) {
		for (User user2 :  usersList) {
			if (id == user2.getId()) {
				new UserResourceClient().fetchCountryName(user2.getCountryCode());
				user2.setCountryName(new UserResourceClient().fetchCountryName(user2.getCountryCode()));
				return user2;
			}		
		}
		return null;
	}
}
