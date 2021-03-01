package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
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
	}
	
	@Test
	void addSurvey() throws Exception {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(serv.addSurvey(testSurvey)).thenReturn(testSurvey);
		Survey newSurvey = serv.addSurvey(testSurvey);
		mvc.perform(post("/surveys").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testSurvey))).andExpect(status().isOk());
		Assertions.assertEquals(gson.toJson(testSurvey), gson.toJson(newSurvey));
	}

	@Test
	void updateSurvey() throws Exception {
		Survey testOne = new Survey();
		testOne.setId(1);
		testOne.setVersion("Test Version 1");
		Survey testTwo = new Survey();
		testTwo.setId(1);
		testTwo.setVersion("Test Version 2");
		Mockito.when(serv.updateSurvey(testTwo)).thenReturn(testTwo);
		mvc.perform(put("/surveys/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testOne))).andExpect(status().isOk());
	}
	
	@Test
	void deleteSurvey() throws Exception {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(serv.deleteSurvey(1)).thenReturn(true);
		mvc.perform(delete("/surveys/1")).andExpect(status().isOk());
	}
}
