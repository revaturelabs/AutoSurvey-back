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
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Answer;
import com.revature.beans.Response;
import com.revature.services.AnswerService;
import com.revature.services.ResponseService;

@RestController
@CrossOrigin
public class ResponseControllerImpl implements ResponseController {
	@Autowired
	ResponseService rs;
	
	@Autowired
	private AnswerService answerService;

	@Override
	@PostMapping(value = "/response", consumes = "application/json", produces = "application/json")
	public Response addResponse(@RequestBody Response r) {
		// TODO Auto-generated method stub
		try {
			return rs.addResponse(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@PostMapping(value = "/response/csv", consumes = "application/json", produces = "application/json")
	public List<Response> addResponsesByCSV(@RequestBody List<Response> responses) {
		// TODO Auto-generated method stub
		try {
			System.out.println("made it to the post responses csv method the list is of size " + responses.size());
			for(int i = 0; i < responses.size(); i++) {
				//System.out.println(responses.get(i));
				System.out.println("begining to process the " + i + " response");
				Response curResponse = responses.get(i);
				List<Answer> answers = curResponse.getAnswers();
				curResponse.setAnswers(null);
				curResponse = rs.addResponse(curResponse);
				//now to add the answers... 
				System.out.println("begining to process the answers of the " + i + " response");
				for(int j = 0; j < answers.size(); j++) {
					System.out.println("begining to process the " + j + "answers of the " + i +" response" );
					answers.get(j).setResponse(curResponse);
					answers.set(j,    this.answerService.addAnswer(answers.get(j)));
				}
				curResponse.setAnswers(answers);
				responses.set(i, curResponse);
				System.out.println("finished processes the reponse " + i);
			}
			
			return responses;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DeleteMapping(value = "/response/{id}")
	public boolean deleteResponse(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return rs.deleteResponse(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@GetMapping(value = "/response/{id}", produces = "application/json")
	public Response getResponse(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return rs.getResponse(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/response", produces = "application/json")
	public List<Response> getAllResponse() {
		// TODO Auto-generated method stub
		try {
			return rs.getAllResponse();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/response/{id}", consumes = "application/json")
	public Response updateResponse(@PathVariable("id") int id, @RequestBody Response r) {
		// TODO Auto-generated method stub
		try {
			r.setId(id);
			rs.updateResponse(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
