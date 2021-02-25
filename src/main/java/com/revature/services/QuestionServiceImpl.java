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
		try {
			return qr.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Question> getAllQuestions() {
		try {
			return (List<Question>) qr.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn) {
		try {
			return qr.findByCreatedOn(createdOn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Question addQuestion(Question q) {
		try {
			return qr.save(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Question updateQuestion(Question q) {
		try {
			return qr.save(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteQuestion(int id) {
		try {
			qr.delete(qr.findById(id).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
