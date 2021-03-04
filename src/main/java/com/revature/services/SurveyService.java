package com.revature.services;

import java.util.List;

import com.revature.beans.Survey;

public interface SurveyService {
	
	/**
	 * <p>
	 * <h1>addSurvey</h1> will accept a Survey object then send it to the repository 
	 * layer to be added to the database. Returns a survey object to the controller.
	 * Returns null if Survey was not successfully added to DB
	 * </p>
	 * 
	 * @param Survey
	 * @return <strong>Survey</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Survey addSurvey(Survey survey);
	
	/**
	 * <p>
	 * <h1>getSurvey</h1> will retrieve a specified survey based on a given survey id
	 *  and return the retrieved survey Returns null if Survey was not successfully added to DB
	 * </p>
	 * 
	 * @param id of type int
	 * @return <strong>Survey</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Survey getSurvey(int id);
	
	/**
	 * <p>
	 * <h1>getAllSurveys</h1> will retrieve all Surveys return the retrieved survey objects as a list
	 * to the controller. Returns null no Survey objects were found
	 * </p>
	 * 
	 * @param none
	 * @return <strong>List</strong> of type Survey
	 * @author Revature 2101 ETL batch
	 */
	public List<Survey> getAllSurveys();
	public List<Survey> getAllSurveysWithinWeekGivenTimestamp(String timestamp);
	
	/**
	 * <p>
	 * <h1>updateSurvey</h1> will accept a Survey object to be updated then send it to the repository 
	 * layer to be updated in the database. Returns a survey object to the controller.
	 * Returns null if Survey was not successfully updated in the DB
	 * </p>
	 * 
	 * @param Survey
	 * @return <strong>Survey</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Survey updateSurvey(Survey change);
	
	/**
	 * <p>
	 * <h1>deleteSurvey</h1> will accept a Survey object to be deleted then send it to the repository 
	 * layer to be deleted in the database. Returns a boolean of true to the controller.
	 * Returns false if Survey was not successfully deleted in the DB
	 * </p>
	 * 
	 * @param id of type int
	 * @return <strong>boolean</strong>
	 * @author Revature 2101 ETL batch
	 */
	public boolean deleteSurvey(int id);

}
