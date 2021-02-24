package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.beans.Question;
import com.revature.repos.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepo qr;
	
	@Override
	public Question getQuestion(int id) {
		return qr.findById(id).get();
	}

	@Override
	public List<Question> getAllQuestions() {
		return qr.findAll();
	}

	@Override
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn) {
		return qr.findByCreatedOn(createdOn);
	}

	@Override
	public Question addQuestion(Question q) {
		return qr.save(q);
	}

	@Override
	public Question updateQuestion(Question q) {
		return qr.save(q);
	}

	@Override
	public boolean deleteQuestion(int id) {
		qr.delete(qr.findById(id).get());
		return true;
	}

}
