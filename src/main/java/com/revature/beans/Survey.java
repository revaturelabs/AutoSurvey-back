package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SURVEYS")
public class Survey {

	// INSTANCE VARIABLES //
	@Id
	@Column(updatable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(length = 32, name = "VERSION")
	private String version;

	@Column(name = "CREATED_ON")
	private Timestamp createdOn;

	// Foreign Key
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.PERSIST })
	@JoinTable(name = "SURVEY_QUESTIONS", joinColumns = @JoinColumn(name = "SURVEY_ID"), inverseJoinColumns = @JoinColumn(name = "QUESTION_ID"))
	private List<Question> questions;

	@OneToMany
	@JoinColumn(name = "SURVEY_ID")
	private List<Response> responses;

	// ---CONSTRUCTORS--- //
	// No Args
	public Survey() {
		super();
	}

	public Survey(int id, String version, Timestamp createdOn, List<Question> questions, List<Response> responses) {
		super();
		this.id = id;
		this.version = version;
		this.createdOn = createdOn;
		this.questions = questions;
		this.responses = responses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", version=" + version + ", createdOn=" + createdOn + ", questions=" + questions
				+ ", responses=" + responses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + id;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Survey other = (Survey) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (id != other.id)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	

}
