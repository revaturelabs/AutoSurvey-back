package com.revature.controllers;

import java.util.List;

import com.revature.beans.Response;

public interface ResponseController {

	Response addResponse(Response r);
	boolean deleteResponse(int id) ;
	Response getResponse(int id) ;
	List<Response> getAllResponse();
	Response updateResponse(int id,Response r);

}
