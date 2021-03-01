package com.revature.controllers;

import java.util.List;

import com.revature.beans.Answer;

public interface AnswerController {

	/**
	 * <p>
	 * <h1>addAnswer</h1> is a post mapping that will add a given Answer object to the database and return it.
	 * </p>
	 * 
	 * @param a : Answer Object
	 * @return The passed in Answer object (a)
	 * @author Revature 2101 ETL batch
	 */
	public Answer addAnswer(Answer a);
	
	/**
	 * <p>
	 * <h1>getSurvey</h1> is a get mapping that retrieve an Answer object given a unique id. <br>
	 * Returns null if no Answer object was found with the given id, or returns an Answer object otherwise.
	 * </p>
	 * 
	 * @param id : path variable of an answer's ID
	 * @return an Answer object if a query returned a single Answer, or null otherwise.
	 * @author Revature 2101 ETL batch
	 */
	public Answer getAnswer(int id);
	
	
	/**
	 * <p>
	 * <h1>getAllAnswers</h1> is a get mapping that will retrieve every single answer from the database.
	 * </p>
	 * 
	 * @return a list of Answers from the database
	 * @author Revature 2101 ETL batch
	 */
	public List<Answer> getAllAnswers();
	
	
	/**
	 * <p>
	 * <h1>updateAnswer</h1> is a put mapping that will update an existing answer
	 * with the given Answer where the answer id is the id supplied by our path
	 * variable. 
	 * </p>
	 * 
	 * @param id : path variable of a surveys ID
	 * @param a : change given in the request body of the Answer object, received as JSON and data used to populate an Answer object
	 * @return The passed in Answer object (a)
	 * @author Revature 2101 ETL batch
	 */
	public Answer updateAnswer(int id, Answer a);
	
	
	
	/**
	 * <p>
	 * <h1>deleteAnswer</h1> is a delete mapping that will delete an existing Answer
	 * with the given id where the id is supplied by the path variable. 
	 * </p>
	 * 
	 * @param id : path variable of an Answer's ID
	 * @return True if deleting by the id was successful, or False otherwise.
	 * @author Revature 2101 ETL batch
	 */
	public boolean deleteAnswer(int id);
}
