package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@CrossOrigin
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserService service;

	@Override
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User addUser(User user) {
		try {
			return service.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/users/{id}")
	public User getUser(int id) {
		try {
			return service.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		try {
			return service.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/users/{id}", consumes = "application/json")
	public User updateUser(User user) {
		try {
			return service.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/users/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		try {
			return service.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
