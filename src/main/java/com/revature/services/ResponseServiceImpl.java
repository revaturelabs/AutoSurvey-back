package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Response;
import com.revature.repos.ResponseRepo;

@Service
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	ResponseRepo rr;

	@Override
	public boolean addResponse(Response r) {
		// TODO Auto-generated method stub
		return rr.save(r);
	}

	@Override
	public Response getResponse(int id) {
		// TODO Auto-generated method stub
		return rr.findById(id).get();
	}

	@Override
	public List<Response> getAllResponse() {
		// TODO Auto-generated method stub
		return (List<Response>) rr.findAll();
	}

	@Override
	public boolean updateResponse(Response r) {
		// TODO Auto-generated method stub
		return rr.save(r);
	}
	
	@Override
	public boolean deleteResponse(int id) {
		// TODO Auto-generated method stub
		try {
			rr.delete(rr.findById(id).get());
			return true;
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
