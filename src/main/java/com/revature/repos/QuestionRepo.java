package com.revature.repos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Question;

public interface QuestionRepo extends CrudRepository<Question, Integer> {

	List<Question> findByCreatedOn(Timestamp createdOn);

}
