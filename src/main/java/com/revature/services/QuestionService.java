package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import com.revature.beans.Question;

public interface QuestionService {
	
	//READ
	public Question getQuestion(int id);
	public List<Question> getAllQuestions();
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn);
	
	//CREATE
	public Question addQuestion(Question q);
	
	//UPDATE
	public Question updateQuestion(Question q);
	
	//DELETE
	public boolean deleteQuestion(int id);
}
