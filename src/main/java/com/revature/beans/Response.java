package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSES")
public class Response {

	@Id
	@Column(updatable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;

	@Column(name = "SUBMITTED_AT")
	private Timestamp submittedAt;
	
	@ManyToOne
	@JoinColumn(name = "SURVEY_ID")
	private Survey surveyId;

	public Response(int id, Timestamp submittedAt, Survey surveyId) {
		super();
		this.id = id;
		this.submittedAt = submittedAt;
		this.surveyId = surveyId;
	}

	public Response() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Timestamp submittedAt) {
		this.submittedAt = submittedAt;
	}

	public Survey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", submittedAt=" + submittedAt + ", surveyId=" + surveyId + "]";
	}
	
	

}
