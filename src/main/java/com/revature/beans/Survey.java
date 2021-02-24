package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey {

	// INSTANCE VARIABLES //
	@Id
	@Column(updatable = false, name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "created_on")
	private Timestamp createdOn;
	
	// Foreign Key
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SurveyQuestion",
			joinColumns = @JoinColumn(name = "survey_id"),
			inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;

	
	// ---CONSTRUCTORS--- //
	// No Args
	public Survey() {
		super();
	}

	// Id-less
	public Survey(String version, Timestamp createdOn, List<Question> questions) {
		super();
		this.version = version;
		this.createdOn = createdOn;
		this.questions = questions;
	}

	// Full Args
	public Survey(int id, String version, Timestamp createdOn, List<Question> questions) {
		super();
		this.id = id;
		this.version = version;
		this.createdOn = createdOn;
		this.questions = questions;
	}

	
	//-----GETTERS AND SETTERS-----//
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

	@Override
	public String toString() {
		return "Survey [id=" + id + ", version=" + version + ", createdOn=" + createdOn + ", questions=" + questions
				+ "]";
	}
	
	
	
	
	
	
	
	
}
