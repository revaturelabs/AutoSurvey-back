package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Response;

@Repository
public interface ResponseRepo extends CrudRepository<Response, Integer> {

}
