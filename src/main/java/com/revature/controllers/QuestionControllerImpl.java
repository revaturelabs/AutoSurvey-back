package com.revature.controllers;

import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Question;
import com.revature.services.QuestionService;

@RestController
@CrossOrigin
public class QuestionControllerImpl implements QuestionController {

  @Autowired
	QuestionService qs;

	@Override
	@GetMapping(value = "/question/{id}")
	public Question getQuestion(@PathVariable("id") String id) {
		try {
			int qid = Integer.parseInt(id);
			return qs.getQuestion(qid);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.getQuestion");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException in QuestionControllerImpl.getQuestion");
		}
		return null;
	}

	@Override
	@GetMapping(value = "/question", produces = "application/json")
	public List<Question> getAllQuestions() {
		try {
			return qs.getAllQuestions();
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.getAllQuestions");
		}
		return null;
	}

	@Override
	@GetMapping(value = "/questionByCreatedOn/{createdOn}", produces = "application/json")
	public List<Question> getQuestionsByCreatedOn(@PathVariable("createdOn") String createdOn) {
		try {
			Timestamp qcreatedOn = Timestamp.valueOf(createdOn);
			return qs.getQuestionsByCreatedOn(qcreatedOn);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.getQuestionsByCreatedOn");
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException in QuestionControllerImpl.getQuestionsByCreatedOn");
		}
		return null;
	}

	@Override
	@PostMapping(value = "/question", consumes = "application/json", produces = "application/json")
	public Question addQuestion(@RequestBody Question q) {
		try {
			return qs.addQuestion(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	@PutMapping(value = "/question/{id}", consumes = "application/json", produces = "application/json")
	public Question updateQuestion(@PathVariable("id") String id, @RequestBody Question q) {
		try {
			return qs.updateQuestion(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/question/{id}")
	public boolean deleteQuestion(@PathVariable("id") String id) {
		try {
			int qid = Integer.parseInt(id);
			return qs.deleteQuestion(qid);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in QuestionControllerImpl.deleteQuestion");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException in QuestionControllerImpl.deleteQuestion");
		}
		return false;
	}
}
