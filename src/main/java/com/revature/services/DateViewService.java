package com.revature.services;

import java.util.List;

import com.revature.beans.DateView;
import com.revature.beans.Statistic;

public interface DateViewService {

	Statistic findByWeekStartDate(String weekStartDate);
	Statistic findAllData();
}
