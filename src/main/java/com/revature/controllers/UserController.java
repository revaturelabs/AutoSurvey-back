package com.revature.controllers;

import java.util.List;

import com.revature.beans.User;

public interface UserController {
	
	/**
	 * <p>
	 * <h1>addUser</h1> is a post mapping that will transform an inputted JSON
	 * object into a User object then send it to the service layer to be added to
	 * the database
	 * </p>
	 * 
	 * @param user received in the response body of the post request
	 * @return <strong>User</strong> Returns a User object in the form of a JSON
	 * 			to the front end, Returns null if User was not successfully added
	 * 			to DB
	 * 
	 * @author Revature 2101 ETL batch
	 */
	public User addUser(User user);
	
	/**
	 * <p>
	 * <h1>getUser</h1> is a get mapping that will retrieve a specified User
	 * based on a given User ID and return the retrieved User as a JSON to the
	 * front end
	 * </p>
	 * 
	 * @param id path variable of type int
	 * @return <strong>User</strong> Returns a User object in the form of a JSON
	 * 			to the front end, Returns null if User was not successfully added
	 * 			to DB
	 * @author Revature 2101 ETL batch
	 */
	public User getUser(int id);
	
	/**
	 * <p>
	 * <h1>getAllUsers</h1> is a get mapping that will retrieve all Users from
	 * the database and send it all to the front end in the form of a JSON
	 * </p>
	 * 
	 * @return List
	 * @author Revature 2101 ETL batch
	 */
	public List<User> getAllUsers();
	
	/**
	 * <p>
	 * <h1>updateUser</h1> is a put mapping that will update an existing User
	 * with the given User where the User ID is the ID supplied by our path
	 * variable
	 * </p>
	 * 
	 * @param id path variable of a User's ID
	 * @param user given in the request body, received as JSON and data used to
	 * populate a User object
	 * @return <strong>User</strong>
	 * @author Revature 2101 ETL batch
	 */
	public User updateUser(int id, User user);
	
	/**
	 * <p>
	 * <h1>deleteUser</h1> is a delete mapping that will delete an existing User
	 * where the User has the same ID as our path variable
	 * </p>
	 * 
	 * @param id path variable of a User's ID
	 * @return <strong>Boolean</strong> true if User deleted properly, false if not
	 * @author Revature 2101 ETL batch
	 */
	public boolean deleteUser(int id);

}
