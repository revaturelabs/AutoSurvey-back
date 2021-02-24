package com.revature.services;

import java.util.List;
import com.revature.beans.Response;

import com.revature.beans.Response;

public interface ResponseService {

	Response addResponse(Response r);
	boolean deleteResponse(int id) ;
	Response getResponse(int id) ;
	List<Response> getAllResponse();
	boolean updateResponse(Response r);
}
