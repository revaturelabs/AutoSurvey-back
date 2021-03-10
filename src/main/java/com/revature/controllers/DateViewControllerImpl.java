package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.DateView;
import com.revature.beans.Statistic;
import com.revature.services.DateViewService;

@RestController
@CrossOrigin
public class DateViewControllerImpl implements DateViewController{
	
	@Autowired
	private DateViewService dvs;

	@Override
	@GetMapping(value="/dateview/{startDate}", produces="application/json")
	public Statistic getDataByWeekStart(@PathVariable String startDate) {
		try {
			return dvs.findByWeekStartDate(startDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GetMapping(value="/dateview", produces="application/json")
	public Statistic getData() {
		try {
			return dvs.findAllData();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
