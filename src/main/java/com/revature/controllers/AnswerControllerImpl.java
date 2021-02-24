package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Answer;
import com.revature.services.AnswerService;

@RestController
public class AnswerControllerImpl implements AnswerController {

	@Autowired
	private AnswerService answerService;
	
	
	// None of these methods need a try/catch, it's already handled via AnswerService!
	
	@Override
	@PostMapping(value = "/answers", consumes = "application/json", produces = "application/json")
	public Answer addAnswer(Answer a) {
		return answerService.addAnswer(a);
	}

	@Override
	@GetMapping(value = "/answers/{id}")
	public Answer getAnswer(int id) {
		return answerService.getAnswer(id);
	}

	@Override
	@GetMapping(value = "/answers")
	public List<Answer> getAllAnswers() {
		return answerService.getAllAnswers();
	}

	@Override
	@PutMapping(value = "/answers/{id}", consumes = "application/json")
	public Answer updateAnswer(Answer a) {
		return answerService.updateAnswer(a);
	}

	@Override
	@DeleteMapping(value = "/answers/{id}")
	public boolean deleteAnswer(@PathVariable("id") int id) {
		return answerService.deleteAnswer(id);
	}

}
