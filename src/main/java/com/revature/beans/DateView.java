package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="response_meta_data_view")
public class DateView {
	
	@Column(name = "start_timestamp_of_week")
	public Timestamp weekStartDate;
	
	@Column(name="week_of_year")
	public int weekOfYear;
	
	@Column(name="year")
	public int year;
	
	@Column(name="batch_week")
	public String batchWeek;
	
	@Id
	@Column(name="response_id")
	public int responseId;
	
	@Column(name="satisfied")
	public String satisfaction;
	
	@Column(name="understanding")
	public String understanding;
	
	@Column(name="pace")
	public String pace;
	
	@Column(name="helpful")
	public String helpful;
	
	@Column(name="organized")
	public String organized;
	
	@Column(name="encouraged")
	public String encouraged;
	
	@Column(name="expectations")
	public String expectations;

	public DateView() {
		super();
	}

	public DateView(Timestamp weekStartDate, int weekOfYear, int year, String batchWeek, int responseId) {
		super();
		this.weekStartDate = weekStartDate;
		this.weekOfYear = weekOfYear;
		this.year = year;
		this.batchWeek = batchWeek;
		this.responseId = responseId;
	}

	public DateView(Timestamp weekStartDate) {
		super();
		this.weekStartDate = weekStartDate;
	}



	public Timestamp getWeekStartDate() {
		return weekStartDate;
	}

	public void setWeekStartDate(Timestamp weekStartDate) {
		this.weekStartDate = weekStartDate;
	}

	public int getWeekOfYear() {
		return weekOfYear;
	}

	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBatchWeek() {
		return batchWeek;
	}

	public void setBatchWeek(String batchWeek) {
		this.batchWeek = batchWeek;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getUnderstanding() {
		return understanding;
	}

	public void setUnderstanding(String understanding) {
		this.understanding = understanding;
	}

	public String getPace() {
		return pace;
	}

	public void setPace(String pace) {
		this.pace = pace;
	}

	public String getHelpful() {
		return helpful;
	}

	public void setHelpful(String helpful) {
		this.helpful = helpful;
	}

	public String getOrganized() {
		return organized;
	}

	public void setOrganized(String organized) {
		this.organized = organized;
	}

	public String getEncouraged() {
		return encouraged;
	}

	public void setEncouraged(String encouraged) {
		this.encouraged = encouraged;
	}

	public String getExpectations() {
		return expectations;
	}

	public void setExpectations(String expectations) {
		this.expectations = expectations;
	}

	@Override
	public String toString() {
		return "DateView [weekStartDate=" + weekStartDate + ", weekOfYear=" + weekOfYear + ", year=" + year
				+ ", batchWeek=" + batchWeek + ", responseId=" + responseId + "]";
	}
	
	
	

}
