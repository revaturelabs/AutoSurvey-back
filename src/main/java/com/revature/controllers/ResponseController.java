package com.revature.controllers;

import java.util.List;

import com.revature.beans.Response;

public interface ResponseController {

	boolean addResponse(Response r);
	boolean deleteResponse(int id) ;
	Response getResponse(int id) ;
	List<Response> getAllResponse();
	boolean updateResponse(int id,Response r);
}
