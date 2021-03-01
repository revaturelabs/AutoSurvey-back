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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((submittedAt == null) ? 0 : submittedAt.hashCode());
		result = prime * result + ((surveyId == null) ? 0 : surveyId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (id != other.id)
			return false;
		if (submittedAt == null) {
			if (other.submittedAt != null)
				return false;
		} else if (!submittedAt.equals(other.submittedAt))
			return false;
		if (surveyId == null) {
			if (other.surveyId != null)
				return false;
		} else if (!surveyId.equals(other.surveyId))
			return false;
		return true;
	}
	
	

}
