package com.revature.controllers;

import java.util.List;

import com.revature.beans.Answer;

public interface AnswerController {

	public Answer addAnswer(Answer a);
	public Answer getAnswer(int id);
	public List<Answer> getAllAnswers();
	public Answer updateAnswer(Answer a);
	public boolean deleteAnswer(int id);
}
