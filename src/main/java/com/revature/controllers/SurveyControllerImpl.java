package com.revature.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Question;
import com.revature.beans.Survey;
import com.revature.services.QuestionService;
import com.revature.services.SurveyService;

import oracle.jdbc.logging.annotations.Log;

@RestController
@CrossOrigin
public class SurveyControllerImpl implements SurveyController {
	@Autowired
	SurveyService ss;

	@Autowired
	QuestionService qs;
	
	@PostMapping(value = "/surveys", consumes = "application/json", produces = "application/json")
	public Survey addSurvey(@RequestBody Survey survey) {
		try {
			return ss.addSurvey(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(value = "/surveys/csv", consumes = "application/json", produces = "application/json")
	public Survey addSurveyByCSV(@RequestBody Survey survey) {
		try {
			//comment.setPosted(new java.sql.Timestamp(new java.util.Date().getTime()));
			List<Question> attachedQuestions = survey.getQuestions();
			survey.setQuestions(null);
			survey.setCreatedOn(new java.sql.Timestamp(new java.util.Date().getTime()));
			survey = ss.addSurvey(survey);
			for(int i = 0; i < attachedQuestions.size(); i++) {
				///handle questions that already existed 
				attachedQuestions.get(i).setCreatedOn(new java.sql.Timestamp(new java.util.Date().getTime()));
				attachedQuestions.set(i, qs.addQuestion(attachedQuestions.get(i)));
			}
			survey.setQuestions(attachedQuestions);
			return ss.updateSurvey(survey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(value = "/surveys/{id}")
	public Survey getSurvey(@PathVariable("id") int id) {
		try {
			return ss.getSurvey(id);
		} catch (NoSuchElementException e) {
			System.out.println("Error, no such survey exists with that id: " + e.getMessage());
		}
		return null;
	}
	
	@GetMapping(value = "/getAllSurveysWithinWeekGivenTimestamp/{timestamp}", produces = "application/json")
	public List<Survey> getAllSurveysWithinWeekGivenTimestamp(@PathVariable String timestamp) {
		try {
			return ss.getAllSurveysWithinWeekGivenTimestamp(timestamp);
		} catch(Exception e) {
			System.out.println("Error in controller layer: " + e.getMessage());
			return null;
		}
		
	}

	@GetMapping(value = "/surveys", produces = "application/json")
	public List<Survey> getAllSurveys() {
		try {
			return ss.getAllSurveys();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping(value = "/surveys/{id}", consumes = "application/json")
	public Survey updateSurvey(@PathVariable("id") int id, @RequestBody Survey change) {
		try {
			change.setId(id);
			return ss.updateSurvey(change);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping(value = "/surveys/{id}")
	public boolean deleteSurvey(@PathVariable("id") int id) {
		try {
			return ss.deleteSurvey(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

}
