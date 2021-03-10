package com.revature.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.revature.beans.Answer;
import com.revature.repos.AnswerRepo;
import com.revature.services.AnswerService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
class AnswerControllerTest {
	
	@MockBean
	AnswerService serv;
	
	@Autowired
	MockMvc mvc;
	
	Gson gson = new Gson();

	@Test
	void test() {
//		fail("Not yet implemented");
	}
	
	@Test
	void addAnswerTest() throws Exception {
		
		Answer obj = new Answer();
		obj.setId(1);
		Answer badObj = new Answer();
		
		ObjectMapper om = new ObjectMapper();
		String jsonRequest = om.writeValueAsString(obj);
		
		Mockito.when(serv.addAnswer(ArgumentMatchers.eq(obj))).thenReturn(obj);
		Mockito.when(serv.addAnswer(ArgumentMatchers.eq(badObj))).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(post("/answers").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(1)));
		
		//Trying to use gson.toJson method
		ra = mvc.perform(post("/answers").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(badObj)));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
	}
	
	@Test
	void getAnswerTest() throws Exception {
		int id = 1;
		Answer obj = new Answer();
		obj.setId(1);
		
		Mockito.when(serv.getAnswer(id)).thenReturn(obj); //Note: getWorkout(String name) not used in controller
		Mockito.when(serv.getAnswer(0)).thenThrow(NoSuchElementException.class);
		
		ResultActions ra = mvc.perform(get("/answers/" + id));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(id)));
		
		ra = mvc.perform(get("/answers/0"));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));	
	}
	
	@Test
	void getAllAnswersTest() throws Exception {	
		Mockito.when(serv.getAllAnswers()).thenReturn(Stream.of(new Answer(), new Answer(), new Answer()).collect(Collectors.toList()));		
		ResultActions ra = mvc.perform(get("/answers"));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.length()", is(3)));
	}
	
	@Test
	void failGetAllAnswersTest() throws Exception {
		Mockito.when(serv.getAllAnswers()).thenThrow(NoSuchElementException.class); //leaving null just throws "Exception"
		ResultActions ra = mvc.perform(get("/answers"));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));	
	}
	
	@Test
	void updateAnswerTest() throws Exception {
		int id = 1;
		Answer obj = new Answer();
		obj.setId(1);
		Answer testObj = new Answer();
		testObj.setId(2);
		
		Mockito.when(serv.updateAnswer(obj)).thenReturn(obj); //ArgumentMatchers.eq() not needed when using Gson
		Mockito.when(serv.updateAnswer(testObj)).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(put("/answers/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(obj)));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(1)));
		
		ra = mvc.perform(put("/answers/2").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testObj)));
		ra.andExpect(status().isOk());

	}
	
	@Test
	void deleteAnswerTest() throws Exception {
		int id = 1;
		int badID = 2;
		
		Mockito.when(serv.deleteAnswer(id)).thenReturn(true);
		Mockito.when(serv.deleteAnswer(badID)).thenThrow(NoSuchElementException.class);
		
		ResultActions ra = mvc.perform(delete("/answers/" + id));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string("true"));
		
		ra = mvc.perform(delete("/answers/" + badID));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string("false"));
	}
	

}
