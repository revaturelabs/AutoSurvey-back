package com.revature.controllers;

import java.util.List;

import com.revature.beans.DateView;
import com.revature.beans.Statistic;

public interface DateViewController {
	
	public Statistic getDataByWeekStart(String startDate);
	public Statistic getData();

}
