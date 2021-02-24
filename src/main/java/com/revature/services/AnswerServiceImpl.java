package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Answer;
import com.revature.repos.AnswerRepo;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerRepo answerRepo;

	@Override
	public Answer addAnswer(Answer a) {
		try {
			return answerRepo.save(a);
		} catch(Exception e) {
			System.out.println("Invalid add answer.");
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Answer getAnswer(int id) {
		try {
			return answerRepo.findById(id).get();
		} catch(Exception e) {
			System.out.println("Invalid get answer by id.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Answer> getAllAnswers() {
		try {
			return (List<Answer>)answerRepo.findAll();
		} catch(Exception e) {
			System.out.println("Invalid get all answers.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Answer updateAnswer(Answer a) {
		try {
			return answerRepo.save(a);
		} catch(Exception e) {
			System.out.println("Invalid update answer.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAnswer(int id) {
		try {
			answerRepo.delete(answerRepo.findById(id).get());	// getAnswer(id) or answerRepo.findById(id).get() should work
			return true;
		} catch(Exception e) {
			System.out.println("Invalid delete answer.");
			e.printStackTrace();
		}
		return false;
	}
}
