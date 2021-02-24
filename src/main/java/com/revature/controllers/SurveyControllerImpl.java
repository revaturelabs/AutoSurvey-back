package com.revature.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.beans.Survey;
import com.revature.services.SurveyService;


@RestController
@CrossOrigin
public class SurveyControllerImpl implements SurveyController {
	
	@Autowired
	SurveyService ss;

	@PostMapping(value = "/surveys", consumes = "application/json", produces = "applicaiton/json")
	public Survey addSurvey(@RequestBody Survey survey) {
		try {
			return ss.addSurvey(survey);
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
			e.printStackTrace();
		}
		return null;
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

	@PutMapping(value = "/surveys/{id}", consumes = "applcation/json")
	public Survey updateSurvey(@PathVariable("id") int id, @RequestBody Survey change) {
		try {
			ss.setId(id);
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
