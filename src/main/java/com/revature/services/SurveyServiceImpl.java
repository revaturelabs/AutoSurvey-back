package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Survey;
import com.revature.repos.SurveyRepo;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	SurveyRepo sr;
	
	@Autowired
	SessionFactory sf;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getAllSurveysWithinWeekGivenTimestamp(String timestamp){
		try {
			
			// Create an EntityManager that will interact with the database (persistent)
			EntityManager em = sf.createEntityManager();
			
			// Essentially, call the function from the database, register the parameters, set the parameters, and then return the result as a list.
			return (List<Survey>) em.createStoredProcedureQuery("get_surveys_from_week")				// 1. call the function/procedure
					.registerStoredProcedureParameter("timestamp", String.class, ParameterMode.IN)		// 2. register all parameters of that function/procedure
					.setParameter("timestamp", timestamp)												// 3. set all parameters
					.getResultList();																	// 4. return the function/procedure as a list.
			
		} catch(Exception e) {
			System.out.println("Error in service layer: " + e.getMessage());
			return null;
		}
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
