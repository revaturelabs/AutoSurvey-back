package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
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

import com.google.gson.Gson;
import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.beans.Survey;
import com.revature.services.SurveyService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class SurveyControllerTest {
	
	@MockBean
	SurveyService serv;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	@Test
	void getAllSurveysWithinWeekGivenTimeStamp() throws Exception
	{
		Mockito.when(serv.getAllSurveysWithinWeekGivenTimestamp(null)).thenReturn(Stream.of(new Survey(), new Survey(), new Survey()).collect(Collectors.toList()));		
		ResultActions ra = mvc.perform(get("/getAllSurveysWithinWeekGivenTimestamp/" + null));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.length()", is(0)));
		
		Mockito.when(serv.getAllSurveysWithinWeekGivenTimestamp("3/9/2021")).thenThrow(NoSuchElementException.class); //leaving null just throws "Exception"
		ra = mvc.perform(get("/getAllSurveysWithinWeekGivenTimestamp/"));
	}
	
	@Test
	void getSurvey() throws Exception {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(serv.getSurvey(1)).thenReturn(testSurvey);
		Mockito.when(serv.getSurvey(2)).thenThrow(NoSuchElementException.class);
		mvc.perform(get("/surveys/1")).andExpect(status().isOk());
		mvc.perform(get("/surveys/2")).andExpect(status().isOk());
	}
	
	@Test
	void getAllSurveys() throws Exception {
		Survey testOne = new Survey();
		Survey testTwo = new Survey();
		List<Survey> surveys = new ArrayList<>();
		surveys.add(testOne);
		surveys.add(testTwo);
		Mockito.when(serv.getAllSurveys()).thenReturn(surveys);
		mvc.perform(get("/surveys")).andExpect(status().isOk());
		
		
		Mockito.when(serv.getAllSurveys()).thenThrow(NoSuchElementException.class); //leaving null just throws "Exception"
		ResultActions ra = mvc.perform(get("/surveys"));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));	
	}
	
	@Test
	void addSurvey() throws Exception {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(serv.addSurvey(testSurvey)).thenReturn(testSurvey);
		Survey newSurvey = serv.addSurvey(testSurvey);
		mvc.perform(post("/surveys").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testSurvey))).andExpect(status().isOk());
		Assertions.assertEquals(gson.toJson(testSurvey), gson.toJson(newSurvey));
		
		Survey badObj = new Survey();
		Mockito.when(serv.addSurvey(ArgumentMatchers.eq(badObj))).thenThrow(NullPointerException.class);
		ResultActions ra = mvc.perform(post("/surveys").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(badObj)));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));
	}

	@Test
	void updateSurvey() throws Exception {
		int id = 1;
		Survey obj = new Survey();
		obj.setId(1);
		Survey testObj = new Survey();
		testObj.setId(2);
		
		Mockito.when(serv.updateSurvey(obj)).thenReturn(obj); //ArgumentMatchers.eq() not needed when using Gson
		Mockito.when(serv.updateSurvey(ArgumentMatchers.eq(testObj))).thenThrow(NullPointerException.class);
		
		ResultActions ra = mvc.perform(put("/surveys/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(obj)));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.id", is(1)));
		
		ra = mvc.perform(put("/surveys/10").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testObj)));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string(""));	
	}
	
	@Test
	void deleteSurvey() throws Exception {
		int id = 1;
		int badID = 2;
		
		Mockito.when(serv.deleteSurvey(id)).thenReturn(true);
		Mockito.when(serv.deleteSurvey(badID)).thenThrow(NoSuchElementException.class);
		
		ResultActions ra = mvc.perform(delete("/surveys/" + id));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string("true"));
		
		ra = mvc.perform(delete("/surveys/" + badID));
		ra.andExpect(status().isOk());
		ra.andExpect(content().string("false"));
	}
}
