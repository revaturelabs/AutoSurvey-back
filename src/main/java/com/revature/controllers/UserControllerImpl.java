package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public User addUser(@RequestBody User user) {
		try {
			return service.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable("id") int id) {
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
	public User updateUser(@PathVariable("id") int id, @RequestBody User change) {
		try {
			change.setId(id);
			return service.updateUser(change);
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

	@Override
	@GetMapping(value="/getUserByEmailAndPassword")
	public User getUserByEmailAndPassword(@RequestParam String email,@RequestParam String password) {
		return service.getUserByEmailAndPassword(email, password);
	}
	
	

}
