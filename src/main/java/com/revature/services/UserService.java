package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import com.revature.beans.User;

public interface UserService {
	
	//*Note:	A single User can be fetched by ID or email since those are unique
	//			When fetching by firstName, lastName, or admin (status), that will return a list of Users
	
	//READ
	public User getUser(int id);
	public User getUserByEmail(String email);
	
	public List<User> getAllUsers();
	public List<User> getUsersByFirstName(String firstName);
	public List<User> getUsersByLastName(String lastName);
	public List<User> getUsersByAdmin(boolean admin);
	public User getUserByEmailAndPassword(String email, String password);
	
	//CREATE
	public User addUser(User u);
	
	//UPDATE
	public User updateUser(User u);
	
	//DELETE
	public boolean deleteUser(int id);


}
