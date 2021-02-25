package com.revature.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	
	// Probably don't need anything else?
	public User findByEmail(String email);
	public List<User> findByAdmin(Boolean isAdmin);
	public List<User> findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);
}
