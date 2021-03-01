package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigData.Option;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.beans.Survey;
import com.revature.repos.SurveyRepo;

@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class SurveyServiceTest {
	
	@MockBean
	SurveyRepo repo;
	
	@Autowired
	SurveyService serv;
	
	@Test
	void getSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(testSurvey));
		Survey survey = serv.getSurvey(1);
		Assertions.assertEquals(1, survey.getId());
	}
	
	@Test
	void addSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(repo.save(testSurvey)).thenReturn(testSurvey);
		Survey survey = serv.addSurvey(testSurvey);
		Assertions.assertEquals(testSurvey, survey);
	}
	
	@Test
	void getAllSurveys() {
		List<Survey> surveys = new ArrayList<>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Survey(), new Survey(), new Survey()).collect(Collectors.toList()));
		surveys = serv.getAllSurveys();
		Assertions.assertEquals(3, surveys.size());
	}
	
	@Test
	void updateSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(repo.save(testSurvey)).thenReturn(testSurvey);
		testSurvey.setId(2);
		Survey newSurvey = serv.updateSurvey(testSurvey);
		Assertions.assertEquals(2, newSurvey.getId());
	}
	
	@Test
	void deleteSurvey() {
		Survey testSurvey = new Survey();
		testSurvey.setId(1);
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(testSurvey));
		Mockito.when(repo.findById(0)).thenThrow(IllegalArgumentException.class);
		Assertions.assertEquals(true, serv.deleteSurvey(1));
		Assertions.assertEquals(false, serv.deleteSurvey(0));
	}

}
