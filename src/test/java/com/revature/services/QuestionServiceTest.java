package com.revature.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.beans.Question;
import com.revature.repos.QuestionRepo;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.example.demo.QcDataReportAppApplication.class)
public class QuestionServiceTest {

	@MockBean
	QuestionRepo repo;
	
	@Autowired
	QuestionService serv;

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
	void getQuestion() {
		Date date = new Date();
		int id = 1;
		Question question = new Question();

		
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(new Question(1, "Add Question Test", new Timestamp(date.getTime()))));
		question = serv.getQuestion(id);
		Assertions.assertEquals("Add Question Test", question.getContent());
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
	void getAllQuestions() {
		List<Question> allQuestions = new ArrayList<Question>();
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Question(), new Question()).collect(Collectors.toList()));
		
		allQuestions = serv.getAllQuestions();
		Assertions.assertEquals(2, allQuestions.size());
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
	void getQuestionsByCreatedOn() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		int id = 1;
		List<Question> allQuestions = new ArrayList<Question>();
		Question question1 = new Question();
		Question question2 = new Question();
		question1.setId(1);
		question1.setContent("something");
		question1.setCreatedOn(ts);
		question2.setId(2);
		question2.setContent("something again");
		question2.setCreatedOn(ts);
		Mockito.when(repo.findByCreatedOn(ts)).thenReturn(Stream.of(question1, question2).collect(Collectors.toList()));

		
		allQuestions = serv.getQuestionsByCreatedOn(ts);
		Assertions.assertEquals(2, allQuestions.size());
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
	void addQuestion() {
		Date date = new Date();
		Question testQuestion = new Question();
		Question question = new Question();
		question.setId(0);
		question.setContent("Add Question Test");
		question.setCreatedOn(new Timestamp(date.getTime()));
		
		Mockito.when(repo.save(testQuestion)).thenReturn(question);
		
		testQuestion = serv.addQuestion(testQuestion);
		Assertions.assertEquals("Add Question Test", testQuestion.getContent());
		Assertions.assertEquals(question.getCreatedOn(), testQuestion.getCreatedOn());
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
	void updateQuestion() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Question question = new Question(0, "default text", ts);
		
		Mockito.when(repo.save(question)).thenReturn(question);
		Assertions.assertEquals("default text", question.getContent());
		
		question.setContent("change text");
		question = serv.updateQuestion(question);
		Assertions.assertEquals("change text", question.getContent());
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
	void deleteQuestion() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Question question = new Question(0, "default text", ts);
		
		Mockito.when(repo.findById(question.getId())).thenReturn(Optional.of(question));
		Mockito.when(repo.findById(1)).thenThrow(IllegalArgumentException.class);
		
		Assertions.assertEquals(true, serv.deleteQuestion(question.getId()));
		verify(repo, times(1)).delete(question);
		
		Assertions.assertEquals(false, serv.deleteQuestion(1));
	}
}
