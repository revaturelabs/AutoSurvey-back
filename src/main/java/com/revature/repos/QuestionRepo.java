package com.revature.repos;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Question;

public interface QuestionRepo extends CrudRepository<Question, Integer> {

}
