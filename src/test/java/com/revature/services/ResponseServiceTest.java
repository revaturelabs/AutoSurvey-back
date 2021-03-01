package com.revature.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.beans.Response;
import com.revature.beans.Survey;
import com.revature.repos.ResponseRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class ResponseServiceTest {

	@MockBean
	ResponseRepo repo;
	
	@Autowired
	ResponseService serv;

	/**
	 * Testing the getResponse() service method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getResponse() {
		int id = 1;
		Date date = new Date();
		Response r = new Response();
		
		Survey s = new Survey();
		s.setId(1);
		r.setId(1);
		r.setSubmittedAt(new Timestamp(date.getTime()));
		r.setSurveyId(s);
		
		Response testR = new Response();
		
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(r));

		testR = serv.getResponse(id);
		Assertions.assertEquals(id, testR.getId());
		Assertions.assertEquals(testR.getId(), r.getId());
	}

	/**
	 * Testing the getAllResponses() service method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void getAllResponses() {
		List<Response> allResponses = new ArrayList<Response>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Response(), new Response()).collect(Collectors.toList()));
		
		allResponses = serv.getAllResponse();
		Assertions.assertEquals(2, allResponses.size());

	}

	/**
	 * Testing the addResponse() service method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void addResponse() {
		Date date = new Date();
		Response r = new Response();
		Response testR = new Response();
		Survey s = new Survey();
		s.setId(0);
        r.setId(0);
        r.setSubmittedAt(new Timestamp(date.getTime()));
        r.setSurveyId(s);
        
        Mockito.when(repo.save(testR)).thenReturn(r);
        testR = serv.addResponse(testR);
        
        Assertions.assertEquals(r.getId(), testR.getId());
		

	}

	/**
	 * Testing the updateResponse() service method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void updateResponse() {
		Date date = new Date();
		Response r = new Response();
		//Response testR = new Response();
		Survey s = new Survey();
		s.setId(0);
        r.setId(0);
        r.setSubmittedAt(new Timestamp(date.getTime()));
        r.setSurveyId(s);
		
		Mockito.when(repo.save(r)).thenReturn(r);
		
		Assertions.assertEquals(0, r.getId());
		
		Timestamp time = Timestamp.valueOf("2007-09-23 10:10:10.0");
		r.setSubmittedAt(time);
		serv.updateResponse(r);
		Assertions.assertEquals(Timestamp.valueOf("2007-09-23 10:10:10.0"), r.getSubmittedAt());

	}

	/**
	 * Testing the deleteResponse() service method
	 *
	 * @param (parameter name) (Describe the first parameter here)
	 * @param (parameter name) (Do the same for each additional parameter)
	 * @return (description of the return value)
	 */
	@Test
	void deleteResponse() {
		Date date = new Date();
		Response r = new Response();
		//Response testR = new Response();
		Survey s = new Survey();
		s.setId(0);
        r.setId(1);
        r.setSubmittedAt(new Timestamp(date.getTime()));
        r.setSurveyId(s);
        
		Mockito.when(repo.findById(r.getId())).thenReturn(Optional.of(r));
		Mockito.when(repo.findById(0)).thenThrow(IllegalArgumentException.class);
		
		Assertions.assertEquals(true, serv.deleteResponse(r.getId()));
		verify(repo, times(1)).delete(r);
		
		Assertions.assertEquals(false, serv.deleteResponse(0));
		
	}
}

