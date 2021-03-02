package com.revature.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Response;
import com.revature.services.ResponseService;

@RestController
@CrossOrigin
public class ResponseControllerImpl implements ResponseController {
	@Autowired
	ResponseService rs;

	@Override
	@PostMapping(value = "/response", consumes = "application/json", produces = "application/json")
	public Response addResponse(@RequestBody Response r) {
		// TODO Auto-generated method stub
		try {
			return rs.addResponse(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	@DeleteMapping(value = "/response/{id}")
	public boolean deleteResponse(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return rs.deleteResponse(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@GetMapping(value = "/response/{id}", produces = "application/json")
	public Response getResponse(@PathVariable("id") int id) {
		// TODO Auto-generated method stub
		try {
			return rs.getResponse(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value = "/response", produces = "application/json")
	public List<Response> getAllResponse() {
		// TODO Auto-generated method stub
		try {
			return rs.getAllResponse();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PutMapping(value = "/response/{id}", consumes = "application/json")
	public Response updateResponse(@PathVariable("id") int id, @RequestBody Response r) {
		// TODO Auto-generated method stub
		try {
			rs.updateResponse(r);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
