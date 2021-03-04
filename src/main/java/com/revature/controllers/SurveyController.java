package com.revature.controllers;

import java.util.List;

import com.revature.beans.Survey;

public interface SurveyController {

	/**
	 * <p>
	 * <h1>addSurvey</h1> is a post mapping that will transform a inputed JSON
	 * object into a Survey object then send it to the service layer to be added to
	 * the database Returns a survey object in the form of a JSON to the front end,
	 * Returns null if Survey was not successfully added to DB
	 * </p>
	 * 
	 * @param survey Received in the response body of the post request
	 * @return <strong>Survey</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Survey addSurvey(Survey survey);
	public Survey addSurveyByCSV(Survey survey);

	/**
	 * <p>
	 * <h1>getSurvey</h1> is a get mapping that will retrieve a specified survey
	 * based on a given survey id and return the retrieved survey as a JSON to the
	 * front end
	 * </p>
	 * 
	 * @param id path variable of type int
	 * @return <strong>Survey</strong> Returns a survey object in the form of a JSON
	 *         to the front end, Returns null if Survey was not successfully added
	 *         to DB
	 * @author Revature 2101 ETL batch
	 */
	public Survey getSurvey(int id);
	
	/**
	 * <p>
	 * <h1>getAllSurveysWithinWeekGivenTimestamp</h1> is a get mapping that will retrieve a specified survey
	 * based on a given survey id and return the retrieved survey as a JSON to the
	 * front end
	 * </p>
	 * 
	 * @param id path variable of type int
	 * @return <strong>Survey</strong> Returns a survey object in the form of a JSON
	 *         to the front end, Returns null if Survey was not successfully added
	 *         to DB
	 * @author Revature 2101 ETL batch
	 */
	public List<Survey> getAllSurveysWithinWeekGivenTimestamp(String timestamp);

	/**
	 * <p>
	 * <h1>getAllSurveys</h1> is a get mapping that will retrieve all surveys from
	 * the database and send it all to the front end in the form of a JSON
	 * </p>
	 * 
	 * @return List
	 * @author Revature 2101 ETL batch
	 */
	public List<Survey> getAllSurveys();

	/**
	 * <p>
	 * <h1>updateSurvey</h1> is a put mapping that will update an existing survey
	 * with the given survey where the survey id is the id supplied by our path
	 * variable. 
	 * </p>
	 * 
	 * @param id path variable of a surveys ID
	 * @param change given in the request body, received as JSON and data used to populate a Survey object
	 * @return <strong>Survey</strong>
	 * @author Revature 2101 ETL batch
	 */
	public Survey updateSurvey(int id, Survey change);

	/**
	 * <p>
	 * <h1>deleteSurvey</h1> is a delete mapping that will delete an existing survey
	 * where the survey has the same ID as our path variable
	 * </p>
	 * 
	 * @param id path variable of a surveys ID
	 * @return Boolean true if survey deleted properly, false if not
	 * @author Revature 2101 ETL batch
	 */
	public boolean deleteSurvey(int id);

}
