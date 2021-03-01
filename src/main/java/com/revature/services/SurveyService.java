package com.revature.services;

import java.util.List;

import com.revature.beans.Survey;

public interface SurveyService {
	
	public Survey addSurvey(Survey survey);
	public Survey getSurvey(int id);
	public List<Survey> getAllSurveys();
	public Survey updateSurvey(Survey change);
	public boolean deleteSurvey(int id);

}
