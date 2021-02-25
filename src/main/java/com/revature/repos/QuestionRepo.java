package com.revature.repos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Integer> {
	List<Question> findByCreatedOn(Timestamp createdOn);
}
