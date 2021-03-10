package com.revature.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.beans.Question;
import com.revature.services.QuestionService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class QuestionControllerTest {

	@MockBean
	QuestionService serv;
	
	@Autowired
	MockMvc mvc;

	public static Gson gson = new Gson();
	
	
	
	@Test
	void addQuestionTest() throws Exception
	{
		Question obj = new Question();
		obj.setId(1);
		Question badObj = new Question();
		
		ObjectMapper om = new ObjectMapper();
		String jsonRequest = om.writeValueAsString(obj);
		
		Mockito.when(serv.addQuestion(ArgumentMatchers.eq(obj))).thenReturn(obj);
		Mockito.when(serv.addQuestion(ArgumentMatchers.eq(badObj))).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(post("/question").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(1)));
		
		//Trying to use gson.toJson method
		ra = mvc.perform(post("/question").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(badObj)));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
	}
	/**
	 * (Write a succinct description of this method here.  If necessary,
	 * additional paragraphs should be preceded by <p>, the html tag for
	 * a new paragraph.)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getQuestion() throws Exception{
		Question question = new Question();
		question.setId(1);
		Mockito.when(serv.getQuestion(1)).thenReturn(question);
		Mockito.when(serv.getQuestion(2)).thenThrow(NoSuchElementException.class);
		mvc.perform(get("/question/1")).andExpect(status().isOk());
		mvc.perform(get("/question/2")).andExpect(status().isOk());
		
	}

	/**
	 * (Write a succinct description of this method here.  If necessary,
	 * additional paragraphs should be preceded by <p>, the html tag for
	 * a new paragraph.)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getAllQuestions() throws Exception{
		Question questionOne = new Question();
		Question questionTwo = new Question();
		ArrayList<Question> questions = new ArrayList<>();
		questions.add(questionOne);
		questions.add(questionTwo);
		Mockito.when(serv.getAllQuestions()).thenReturn(questions);
		mvc.perform(get("/question")).andExpect(status().isOk());
	}

	/**
	 * (Write a succinct description of this method here.  If necessary,
	 * additional paragraphs should be preceded by <p>, the html tag for
	 * a new paragraph.)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getQuestionsByCreatedOn() throws Exception{
		Date date = new Date();
		Question questionOne = new Question();
		Question questionTwo = new Question();
		ArrayList<Question> questions = new ArrayList<>();
		questionOne.setId(1);
		questionOne.setCreatedOn(new Timestamp(date.getTime()));
		questionTwo.setId(2);
		questionTwo.setCreatedOn(new Timestamp(date.getTime()));
		questions.add(questionOne);
		questions.add(questionTwo);
		Mockito.when(serv.getQuestionsByCreatedOn(new Timestamp(date.getTime()))).thenReturn(questions);
		mvc.perform(get("/questionByCreatedOn/" + new Timestamp(date.getTime()))).andExpect(status().isOk());
	}


	/**
	 * (Write a succinct description of this method here.  If necessary,
	 * additional paragraphs should be preceded by <p>, the html tag for
	 * a new paragraph.)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test	
	void updateQuestion() throws Exception{
		Question questionOne = new Question();
		questionOne.setId(1);
		questionOne.setContent("Test content 1");
		Question questionTwo = new Question();
		questionTwo.setId(2);
		questionTwo.setContent("Test content 2");
		Mockito.when(serv.updateQuestion(questionTwo)).thenReturn(questionTwo);
		mvc.perform(put("/question/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(questionOne))).andExpect(status().isOk());
		
	
		Question testObj = new Question();
		testObj.setId(3);
		Mockito.when(serv.updateQuestion(ArgumentMatchers.eq(testObj))).thenThrow(NullPointerException.class);
		ResultActions ra = mvc.perform(put("/question/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testObj)));
		ra = mvc.perform(put("/question/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testObj)));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));	
	}

	/**
	 * (Write a succinct description of this method here.  If necessary,
	 * additional paragraphs should be preceded by <p>, the html tag for
	 * a new paragraph.)
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void deleteQuestion() throws Exception{
		Question question = new Question();
		question.setId(1);
		Mockito.when(serv.deleteQuestion(1)).thenReturn(true);
		mvc.perform(delete("/question/1")).andExpect(status().isOk());
	}
}
