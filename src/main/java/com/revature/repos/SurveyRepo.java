package com.revature.repos;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Survey;

public interface SurveyRepo extends CrudRepository<Survey, Integer> {

}
