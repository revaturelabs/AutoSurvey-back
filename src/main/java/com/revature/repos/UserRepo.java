package com.revature.repos;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	// Probably don't need anything else?
}
