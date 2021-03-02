package com.revature.controllers;

import java.util.List;

import com.revature.beans.Response;

public interface ResponseController {

	
	/**
	 * <strong>addResponse</strong> captures POST requests sent to the
	 * URI "/response". It accepts a JSON formatted Response object.
	 * The object should be of the form {"id":x,"submittedAt":x,"surveyId":x}
	 * 
	 * @param r A JSON response passed via HTTP POST
	 * @return A copy of r if success, otherwise null
	 */
	Response addResponse(Response r);
	
	/**
	 * <strong>deleteResponse</strong> captures HTTP DELETE requests sent 
	 * to the URI "/response/id" where id is a number. It accepts the id
	 * of a Response that exists in the database and deletes it.
	 * @param id A valid id of a response in the database
	 * @return True on success, false otherwise
	 */
	boolean deleteResponse(int id) ;
	
	/**
	 * <strong>getResponse</strong> captures HTTP GET requests sent to
	 * the URI "/response/id" where id is a number. It accepts the id of
	 * a Response that exists in the database and returns it. 
	 * @param id A valid id of a response in the database
	 * @return The Response object if found, null otherwise
	 */
	Response getResponse(int id) ;
	
	/**
	 * <strong>getAllResponse</strong> captures HTTP GET requests sent to
	 * the URI "/response". It takes no parameters and returns a JSON formatted
	 * array of all Response objects in the database.
	 * @return An array of responses
	 */
	List<Response> getAllResponse();
	
	/**
	 * <strong>updateResponse</string> capture HTTP PUT requests sent to
	 * the URI "/response/id" where id is a number. id must be the id of a
	 * Response in the database. If it is then the body of the PUT request is
	 * assumed to be a JSON formatted Response object. The database is then
	 * updated to contain the new Response object with it's given id, removing
	 * the old object.
	 * @param id A valid id of a Response in the database
	 * @param r A JSON formatted Response object
	 * @return Returns the updated Response
	 */
	Response updateResponse(int id,Response r);

}
