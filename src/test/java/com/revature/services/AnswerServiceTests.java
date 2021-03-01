package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
//Author: 
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.beans.Answer;
import com.revature.repos.AnswerRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
class AnswerServiceTests {
	
	@MockBean
	AnswerRepo repo;
	
	@Autowired
	AnswerService serv;

	@Test
	void test() {
//		fail("Not yet implemented");
	}
	

	@Test
	void addAnswerTest() {
		int id = 1;
		Answer obj = new Answer();
		obj.setId(id);
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		obj = serv.addAnswer(obj);
		Assertions.assertEquals(1, obj.getId());
	}
	
	@Test
	void getAnswerTest() {
		int id = 1;
		Answer obj = new Answer();
		obj.setId(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		obj = serv.getAnswer(id);
		Assertions.assertEquals(id, obj.getId());		
	}
	
	@Test
	void getAllAnswersTest() {
		List<Answer> allObjs = new ArrayList<Answer>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Answer(), new Answer(), new Answer()).collect(Collectors.toList()));
		
		allObjs = serv.getAllAnswers();
		Assertions.assertEquals(3, allObjs.size());
	}
	
	@Test
	void updateAnswerTest() {
		Answer obj = new Answer();
		obj.setId(1);
		
		Mockito.when(repo.save(obj)).thenReturn(obj);
		
		Assertions.assertEquals(1, obj.getId());		
		obj.setId(2);
		obj = serv.updateAnswer(obj);
		Assertions.assertEquals(2, obj.getId());
	}
	
	@Test
	void deleteAnswerTest() {
		int id = 1;
		Answer obj = new Answer();
		obj.setId(id);
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(obj));
		
		Assertions.assertEquals(true, serv.deleteAnswer(id));
		verify(repo, times(1)).delete(obj);
	}
}
