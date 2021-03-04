package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;
import com.revature.beans.Question;

public interface QuestionController {
	
	//READ
	/**
	 * <p>
	 * <h1>getQuestion</h1> is a GetMapping request method that retrieves
	 * a single question. Takes in the id of the question to be retrieved as
	 * the only parameter and returns that question, or null if no question with
	 * that id exists.
	 * </p>
	 * 
	 * @param id Received as a path variable in the URI
	 * @return <strong>Question</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Question getQuestion(int id);
	
	/**
	 * <p>
	 * <h1>getAllQuestions</h1> is a GetMapping request method that retrieves
	 * all the questions in the database. This method takes in no parameters
	 * and returns a list of all the questions
	 * </p>
	 * 
	 * @return <strong>List<Question\></strong>
	 * @author Revature 2101 ETL batch
	 */
	public List<Question> getAllQuestions();
	
	/**
	 * <p>
	 * <h1>getQuestionsByCreatedOn</h1> is a GetMapping request method that retrieves
	 * all the questions in the database with a specific Timestamp. This method takes 
	 * in a formatted time as a String type and turns it into a Timestamp. It then 
	 * returns a list of questions with that timestamp, or null if there are no questions
	 * matching that criteria.
	 * </p>
	 * 
	 * @param createdOn Received as a pathvariable in URI
	 * @return <strong>List<Question\></strong>
	 * @author Revature 2101 ETL batch
	 */
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn);
	
	//CREATE
	/**
	 * <p>
	 * <h1>addQuestion</h1> is a PostMapping request method that receives
	 * a Question object and sends it to QuestionService.addQuestion() method to be 
	 * added to the database. Returns the Question added or null if their was an
	 * error in adding the question.
	 * </p>
	 * 
	 * @param createdOn Received as a Question in the request body to be added
	 * @return <strong>Question</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Question addQuestion(Question q);
	
	//UPDATE
	/**
	 * <p>
	 * <h1>updateQuestion</h1> is a PostMapping request method that receives
	 * a Question object and sends it to QuestionService.updateQuestion() method 
	 * to update an existing Question in the database. Returns the Question updated
	 * or null if their was an error in updating the question.
	 * </p>
	 * 
	 * @param id Received as a path variable
	 * @param q Received in request body as the updated question to be sent to the database
	 * @return <strong>Question</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Question updateQuestion(int id, Question q);
	
	//DELETE
	/**
	 * <p>
	 * <h1>deleteQuestion</h1> is a DeleteMapping request method that receives
	 * a Questions id as a string, turns it into an int, and sends it to the service
	 * to be deleted. Returns true if the question is deleted, otherwise returns false
	 * </p>
	 * 
	 * @param id Received as an int of the question being deleted
	 * @return <strong>boolean</strong>
	 * @author Revature 2101 ETL batch
	 */
	public boolean deleteQuestion(int id);
}
