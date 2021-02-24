package com.revature.repos;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Answer;

public interface AnswerRepo extends CrudRepository<Answer, Integer> {

}
