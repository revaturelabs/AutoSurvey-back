package com.revature.controllers;

import java.util.List;

import com.revature.beans.User;

public interface UserController {
	
	public User addUser(User user);
	public User getUser(int id);
	public List<User> getAllUsers();
	public User updateUser(int id, User user);
	public boolean deleteUser(int id);

}
