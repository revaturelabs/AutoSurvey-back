package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;
import com.revature.beans.Question;

public interface QuestionController {
	
	//READ
	public Question getQuestion(int id);
	public List<Question> getAllQuestions();
	public List<Question> getQuestionsByCreatedOn(Timestamp createdOn);
	
	//CREATE
	public Question addQuestion(Question q);
	
	//UPDATE
	public Question updateQuestion(int id, Question q);
	
	//DELETE
	public boolean deleteQuestion(int id);
}
