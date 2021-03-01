package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Survey;

@Repository
public interface SurveyRepo extends CrudRepository<Survey, Integer> {

}
