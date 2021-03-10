package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.DateView;
import com.revature.beans.Statistic;
import com.revature.repos.DateViewRepo;

@Service
public class DateViewServiceImpl implements DateViewService {

	@Autowired
	private DateViewRepo dvr;

	@Override
	public Statistic findByWeekStartDate(String weekStartDate) {
		try {
			List<DateView> dateView = dvr.findByWeekStartDate(Timestamp.valueOf(weekStartDate));
			Statistic stats = new Statistic();
			stats.setAvgSatisfaction(avgSatisfaction(dateView, stats));
			stats.setAvgUnderstanding(avgUnderstanding(dateView, stats));
			stats.setAvgPace(avgPace(dateView, stats));
			stats.setAvgHelpful(avgHelpful(dateView, stats));
			stats.setAvgOrganized(avgOrganized(dateView, stats));
			stats.setAvgQuestionsEncouraged(avgQuestionsEncouraged(dateView, stats));
			stats.setAvgMetExpectations(avgMetExpectations(dateView, stats));
			return stats;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Statistic findAllData() {
		try {
			List<DateView> dateView = (List<DateView>) dvr.findAll();
			Statistic stats = new Statistic();
			stats.setAvgSatisfaction(avgSatisfaction(dateView, stats));
			stats.setAvgUnderstanding(avgUnderstanding(dateView, stats));
			stats.setAvgPace(avgPace(dateView, stats));
			stats.setAvgHelpful(avgHelpful(dateView, stats));
			stats.setAvgOrganized(avgOrganized(dateView, stats));
			stats.setAvgQuestionsEncouraged(avgQuestionsEncouraged(dateView, stats));
			stats.setAvgMetExpectations(avgMetExpectations(dateView, stats));
			return stats;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/*-------------*/
	
	
	public double avgSatisfaction(List<DateView> dateView, Statistic stats) {
		double sum = 0;
		int numRecords = dateView.size();
		
		stats.setSatisfactionCount(numRecords);
		if(dateView.size() == 0) {
			return 0;
		}

		for(int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);
			String answer = currentRecord.getSatisfaction();
			if(answer.equals("N/A") || answer.equals("")) {
				numRecords--;
			}else{
				sum += Integer.parseInt(answer);
			}
		}
		stats.setSatisfactionCount(numRecords);
		if(numRecords == 0) {
			return 0;
		}else {
			double avg = sum/numRecords;
			return avg;		
		}
	}

	public double avgUnderstanding(List<DateView> dateView, Statistic stats) {
		double sum = 0;
		int numRecords = dateView.size();
		
		stats.setUnderstandingCount(numRecords);
		if(dateView.size() == 0) {
			return 0;
		}

		for(int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);
			String answer = currentRecord.getUnderstanding();
			if(answer.equals("N/A") || answer.equals("")) {
				numRecords--;
			}else{
				sum += Integer.parseInt(answer);
			}
		}
		stats.setUnderstandingCount(numRecords);
		
		if(numRecords == 0) {
			return 0;
		}else {
			double avg = sum/numRecords;
			return avg;		
		}
	}

	public double avgPace(List<DateView> dateView, Statistic stats) {
		double sumPace = 0;
		int size = dateView.size();
		
		stats.setPaceCount(size);
		if(dateView.size() == 0) {
			return 0;
		}
		
		for (int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);

			if (currentRecord.getPace().equals("Too fast")) {
				sumPace += 5;
			} else if (currentRecord.getPace().equals("Good")) {
				sumPace += 3;
			} else if (currentRecord.getPace().equals("Too slow")) {
				sumPace += 1;
			}else {
				size--;
			}

		}
		stats.setPaceCount(size);
		if(size == 0) {
			return 0;
		}else {
			double avgPace = sumPace / size;
			return avgPace;		
		}
	}

	public double avgHelpful(List<DateView> dateView, Statistic stats) {
		double sum = 0;
		int numRecords = dateView.size();
		
		stats.setHelpfulCount(numRecords);
		if(dateView.size() == 0) {
			return 0;
		}

		for(int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);
			String answer = currentRecord.getHelpful();
			if(!answer.equals("N/A") && !answer.equals("")) {
				sum += stringToDoubleConversion(answer);	
			}else{
				numRecords--;
			}
		}
		stats.setHelpfulCount(numRecords);
		if(numRecords == 0) {
			return 0;
		}else {
			double avg = sum/numRecords;
			return avg;			
		}
	}
	

	public double avgOrganized(List<DateView> dateView, Statistic stats) {
		double sum = 0;
		int numRecords = dateView.size();
		
		stats.setOrganizedCount(numRecords);
		if(dateView.size() == 0) {
			return 0;
		}

		for(int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);
			String answer = currentRecord.getOrganized();
			if(!answer.equals("N/A") && !answer.equals("")) {
				sum += stringToDoubleConversion(answer);	
			}else{
				numRecords--;
			}
		}
		stats.setOrganizedCount(numRecords);
		if(numRecords == 0) {
			return 0;
		}else {
			double avg = sum/numRecords;
			return avg;	
		}
	}

	public double avgQuestionsEncouraged(List<DateView> dateView, Statistic stats) {
		double sum = 0;
		int numRecords = dateView.size();
		
		stats.setQuestionsEncouragedCount(numRecords);
		if(dateView.size() == 0) {
			return 0;
		}

		for(int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);
			String answer = currentRecord.getEncouraged();
			if(!answer.equals("N/A") && !answer.equals("")) {
				sum += stringToDoubleConversion(answer);	
			}else{
				numRecords--;
			}
		}
		stats.setQuestionsEncouragedCount(numRecords);
		if(numRecords == 0) {
			return 0;
		}else {
			double avg = sum/numRecords;
			return avg;			
		}
	}

	public double avgMetExpectations(List<DateView> dateView, Statistic stats) {
		double sum = 0;
		int numRecords = dateView.size();
		
		stats.setMetExpectationsCount(numRecords);
		if(dateView.size() == 0) {
			return 0;
		}

		for(int i = 0; i < dateView.size(); i++) {
			DateView currentRecord = dateView.get(i);
			String answer = currentRecord.getExpectations();
			if(!answer.equals("N/A") && !answer.equals("")) {
				sum += stringToDoubleConversion(answer);	
			}else{
				numRecords--;
			}
		}
		stats.setMetExpectationsCount(numRecords);
		if(numRecords == 0) {
			return 0;
		}else {
			double avg = sum/numRecords;
			return avg;			
		}
	}
	
	public double stringToDoubleConversion(String answer) {
		if(answer.equals("Strongly agree")) {
			return 5;
		}
		if(answer.equals("Agree")) {
			return 3.66;
		}
		if(answer.equals("Disagree")) {
			return 2.33;
		}
		if(answer.equals("Strongly Disagree")) {
			return 1;
		}
		return 0;
	}

}
