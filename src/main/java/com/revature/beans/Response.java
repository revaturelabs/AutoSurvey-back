package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "RESPONSES")
public class Response {

	@Id
	@Column(updatable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id = 0;

	@Column(name = "SUBMITTED_AT")
	private Timestamp submittedAt;

	@OneToMany(mappedBy = "response")
	@JsonManagedReference
	private List<Answer> answers;

	@ManyToOne
	@JoinColumn(name = "SURVEY_ID")
	@JsonBackReference
	private Survey survey;
	
	
	
	
	public Response() {
		super();
	}

	public Response(int id, Timestamp submittedAt, List<Answer> answers) {
		super();
		this.id = id;
		this.submittedAt = submittedAt;
		this.answers = answers;
	}
	
	

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", submittedAt=" + submittedAt + ", answers=" + answers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + id;
		result = prime * result + ((submittedAt == null) ? 0 : submittedAt.hashCode());
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
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (id != other.id)
			return false;
		if (submittedAt == null) {
			if (other.submittedAt != null)
				return false;
		} else if (!submittedAt.equals(other.submittedAt))
			return false;
		return true;
	}


	
}
