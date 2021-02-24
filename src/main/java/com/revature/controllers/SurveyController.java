package com.revature.controllers;

import java.util.List;

import com.revature.beans.Survey;

public interface SurveyController {

	public Survey addSurvey(Survey survey);
	public Survey getSurvey(int id);
	public List<Survey> getAllSurveys();
	public Survey updateSurvey(int id, Survey change);
	public boolean deleteSurvey(int id);
	
}
