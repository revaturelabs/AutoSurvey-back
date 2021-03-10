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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.beans.Answer;
import com.revature.beans.Response;
import com.revature.services.AnswerService;
import com.revature.services.ResponseService;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class ResponseControllerTest {

	@MockBean
	ResponseService serv;
	
	@MockBean
	AnswerService aServ;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	
	@Test void addResponseForSurvey() throws Exception
	{
		Response obj = new Response();
		obj.setId(1);
		Response badObj = new Response();
		ObjectMapper om = new ObjectMapper();
		String jsonRequest = om.writeValueAsString(obj);
		
		Mockito.when(serv.addResponse(ArgumentMatchers.eq(obj))).thenReturn(obj);
		Mockito.when(serv.addResponse(ArgumentMatchers.eq(badObj))).thenThrow(NullPointerException.class);
		
		
		ResultActions ra = mvc.perform(post("/responseSurvey").contentType(MediaType.APPLICATION_JSON).content(jsonRequest));
		ra.andExpect(status().isOk());
	}
	/**
	 * Tests addResponse() controller method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void addResponse() throws Exception {
		Response r = new Response();
		r.setId(1);
		Mockito.when(serv.addResponse(r)).thenReturn(r);
		Response r2 = serv.addResponse(r);
		mvc.perform(post("/response").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(r))).andExpect(status().isOk());
		Assertions.assertEquals(gson.toJson(r), gson.toJson(r2));
	}

	/**
	 * Tests getResponse() controller method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getResponse() throws Exception {
		Response r = new Response();
		r.setId(1);
		Mockito.when(serv.getResponse(1)).thenReturn(r);
		Mockito.when(serv.getResponse(2)).thenThrow(NoSuchElementException.class);
		
		mvc.perform(get("/response/1")).andExpect(status().isOk());
		mvc.perform(get("/response/2")).andExpect(status().isOk());
	}

	/**
	 * Tests getAllResponses() controller method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getAllResponses() throws Exception {
		Mockito.when(serv.getAllResponse()).thenReturn(Stream.of(new Response(), new Response()).collect(Collectors.toList()));
		ResultActions ra = mvc.perform(get("/response"));
		ra.andExpect(status().isOk());
		ra.andExpect(jsonPath("$.length()", is(2)));
		
		Mockito.when(serv.getAllResponse()).thenThrow(NoSuchElementException.class); //leaving null just throws "Exception"
		ResultActions r = mvc.perform(get("/response"));
		r.andExpect(status().isOk());
		r.andExpect(content().string(""));	
	}


	/**
	 * Tests updateResponse() controller method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test	
	void updateResponse() throws Exception {
		Response r = new Response();
		r.setId(1);
		Response r2 = new Response();
		r.setId(1);
		Mockito.when(serv.updateResponse(r2)).thenReturn(r2);
		mvc.perform(put("/response/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(r))).andExpect(status().isOk());
	}

	/**
	 * Tests deleteResponse() controller method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void deleteResponse() throws Exception {
		Response r = new Response();
		r.setId(1);
		
		Mockito.when(serv.deleteResponse(1)).thenReturn(true);
		mvc.perform(delete("/response/1")).andExpect(status().isOk());
		
		Mockito.when(serv.deleteResponse(2)).thenThrow(NoSuchElementException.class); //leaving null just throws "Exception"
		ResultActions ra = mvc.perform(delete("/response/2"));
		ra.andExpect(status().isOk());
	}
	
	@Test
	void addResponsesByCSVTest() throws Exception {
		//Object Setup
		List<Response> resList = new ArrayList<Response>();
		List<Answer> aList1 = new ArrayList<Answer>();
		List<Answer> aList2 = new ArrayList<Answer>();
		
		Answer a1 = new Answer();
		a1.setId(1);
		a1.setContent("Test");
		Answer a2 = new Answer();
		a2.setId(2);
		Answer a3 = new Answer();
		a3.setId(3);
		
		aList1.add(a1);
		aList1.add(a2);
		aList2.add(a2);
		aList2.add(a3);
		
		Response r1 = new Response();
		r1.setId(1);
		//r1.setSubmittedAt(2020-03-03 14:08:17);
		r1.setTimeStampString("2020-03-03 14:08:17");
		//r1.setSubmittedAt(Timestamp.valueOf(r1.getTimeStampString()));
		//r1.setSubmittedAt(Timestamp.valueOf("2020-03-03 14:08:17"));
		r1.setAnswers(aList1);
		resList.add(r1);
		
		Response r2 = new Response();
		r2.setId(2);
		//r2.setTimeStampString("2020-04-03 14:08:17");
		r2.setAnswers(aList2);
		resList.add(r2);
		
		//Mockito Setup
		Mockito.when(serv.addResponse(ArgumentMatchers.any(Response.class))).thenReturn(r1);
		//Mockito.when(serv.addResponse(ArgumentMatchers.eq(r2))).thenReturn(r2);
		Mockito.when(aServ.addAnswer(a1)).thenReturn(a1);
		Mockito.when(aServ.addAnswer(a2)).thenReturn(a2);
		Mockito.when(aServ.addAnswer(a3)).thenReturn(a3);
		
		ResultActions ra = mvc.perform(post("/response/csv").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(resList)));
		ra.andExpect(status().isOk());
		
		r2.setTimeStampString("2020-04-03 14:08:17");
		ra = mvc.perform(post("/response/csv").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(resList)));
		ra.andExpect(status().isOk());
		
	}
}

