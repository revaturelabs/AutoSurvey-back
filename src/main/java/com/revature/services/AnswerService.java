package com.revature.services;

import java.util.List;

import com.revature.beans.Answer;

public interface AnswerService {
	
	/**
	 * Add a given Answer to the database directly in the Services layer.
	 * @param a : the given Answer to add to the database
	 * @return the given Answer object
	 * @author Revature 2101 ETL batch
	 */
	public Answer addAnswer(Answer a);
	
	/**
	 * Retrieve a given Answer based on the given id directly in the Services layer.
	 * @param id : the given id to search for an Answer.
	 * @return the resulting Answer object from the id, or null otherwise.
	 */
	public Answer getAnswer(int id);
	
	/**
	 * Retrives all Answers from the database directly in the Services layer
	 * @return the list of Answers from the database.
	 */
	public List<Answer> getAllAnswers();
	
	/**
	 * Update a given Answer from the database directly in the Services layer. <br>
	 * Assumes that the new id is already contained in the given Answer object.  
	 * @param a : the updated Answer object to update on the database.
	 * @return the given Answer object.
	 */
	public Answer updateAnswer(Answer a);
	
	/**
	 * Delete a given Answer from the data, given an id to search for directly in the Services layer.
	 * @param id : the given id to search for in the Answer table.
	 * @return True if an Answer with the given id exists and the delete operation was successful, or False otherwise.
	 */
	public boolean deleteAnswer(int id);
}
