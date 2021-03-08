package com.revature.controllers;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	@PostMapping(value="/getUserByEmail", consumes="application/json", produces="application/json")
	public User getUserByEmail(@RequestParam String email, @RequestBody HttpServletRequest request, HttpServletResponse response) {
		try {
			User u = service.getUserByEmail(email);
			String password = request.getParameter("password");
			
			if (u != null) {
				//if email exists in the database, check password
				System.out.println("PW in DB: " + u.getPassword());
				System.out.println("PW in RequestBody: " + password);
				
				if(u.getPassword().equals(password)) {
					//if passwords match, check admin status
					System.out.println("Admin? " + u.isAdmin());
					
					if (u.isAdmin()) {
						//if admin, create cookie and return User
						Cookie cookie = new Cookie("loggedInAdmin", email);
						response.addCookie(cookie);
						return service.getUserByEmail(email);
					}
					return null;
					
				}
				return null;
				
			}
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
