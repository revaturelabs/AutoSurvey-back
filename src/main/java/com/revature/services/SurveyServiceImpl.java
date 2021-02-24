package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Survey;
import com.revature.repos.SurveyRepo;

public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	SurveyRepo sr;

	@Override
	public Survey addSurvey(Survey survey) {
		survey.setCreatedOn(new java.sql.Timestamp(new java.util.Date().getTime()));
		return sr.save(survey);
	}

	@Override
	public Survey getSurvey(int id) {
		return sr.findById(id).get();
	}

	@Override
	public List<Survey> getAllSurveys() {
		return (List<Survey>) sr.findAll();
	}

	@Override
	public Survey updateSurvey(Survey change) {
		return sr.save(change);
	}

	@Override
	public boolean deleteSurvey(int id) {
		try {
			sr.delete(sr.findById(id).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
