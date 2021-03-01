package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import com.revature.beans.User;

public interface UserService {
	
	//*Note:	A single User can be fetched by ID or email since those are unique
	//			When fetching by firstName, lastName, or admin (status), that will return a list of Users
	
	//READ
	
	/**
	 * <p>
	 * <h1>getUser</h1> will retrieve a specified user
	 * based on a given user id and return the retrieved user to the
	 * User controller
	 * </p>
	 * 
	 * @param id of type int
	 * @return <strong>User</strong> Returns a user object
	 *         to the controller, Returns null if User was not successfully retrieved
	 *         from DB
	 * @author Revature 2101 ETL batch
	 */
	public User getUser(int id);
	
	/**
	 * <p>
	 * <h1>getUserByEmail</h1> will retrieve a specified user
	 * based on a given user email and return the retrieved user as to the
	 * User controller
	 * </p>
	 * 
	 * @param email of type String
	 * @return <strong>User</strong> Returns a user object in
	 *         to the controller, Returns null if User was not successfully retrieved
	 *         from DB
	 * @author Revature 2101 ETL batch
	 */
	public User getUserByEmail(String email);
	
	/**
	 * <p>
	 * <h1>getAllUsers</h1> will retrieve all users object as a list from
	 * the database and send list to the user controller
	 * </p>
	 * 
	 * @param none
	 * @return <strong>List</strong> Returns a list of user objects
	 *         to the controller, Returns null if list was not successfully retrieved
	 *         from DB
	 * @author Revature 2101 ETL batch
	 */
	public List<User> getAllUsers();
	
	/**
	 * <p>
	 * <h1>getUsersByFirstName</h1> will retrieve a specified user
	 * based on a given user first name and return the retrieved to the
	 * User controller
	 * </p>
	 * 
	 * @param firstName of type String
	 * @return <strong>User</strong> Returns a user object
	 *         to the controller, Returns null if User was not successfully retrieved
	 *         from DB
	 * @author Revature 2101 ETL batch
	 */
	public List<User> getUsersByFirstName(String firstName);
	
	/**
	 * <p>
	 * <h1>getUsersByLastName</h1> will retrieve a specified user
	 * based on a given user last name and return the retrieved user to the
	 * User controller
	 * </p>
	 * 
	 * @param lastName of type String
	 * @return <strong>User</strong> Returns a user object
	 *         to the controller, Returns null if User was not successfully retrieved
	 *         from DB
	 * @author Revature 2101 ETL batch
	 */
	public List<User> getUsersByLastName(String lastName);
	
	/**
	 * <p>
	 * <h1>getUsersByAdmin</h1> will retrieve all users object that are admins
	 *  and return the retrieved users as list to the
	 * User controller
	 * </p>
	 * 
	 * @param admin of type boolean
	 * @return <strong>List</strong> Returns a list of user objects
	 *         to the controller, Returns null if list was not successfully retrieved
	 *         from DB
	 * @author Revature 2101 ETL batch
	 */
	public List<User> getUsersByAdmin(boolean admin);
	
	/**
	 * <p>
	 * <h1>addUser</h1> will accept an inputed user object then send it to the user repository
	 *  to be added to the database. Returns a user object to the controller,
	 * Returns null if Survey was not successfully added to DB
	 * </p>
	 * 
	 * @param User
	 * @return <strong>User</strong>
	 * @author Revature 2101 ETL batch
	 */
	public User addUser(User u);
	
	/**
	 * <p>
	 * <h1>updateUser</h1> will accept an inputed user object to be updated, then send it to the user repository
	 *  to be updated in the database. Returns a user object to the controller,
	 * Returns null if Survey was not successfully added to DB
	 * </p>
	 * 
	 * @param User
	 * @return <strong>User</strong>
	 * @author Revature 2101 ETL batch
	 */
	public User updateUser(User u);
	
	/**
	 * <p>
	 * <h1>deleteUser</h1> will delete one user object from the DB where the user id is the same ID
	 * as the one provided in the parameter
	 * </p>
	 * 
	 * @param id of type int
	 * @return <strong>boolean</strong> true if user deleted properly, false if not
	 * @author Revature 2101 ETL batch
	 */
	public boolean deleteUser(int id);


}
