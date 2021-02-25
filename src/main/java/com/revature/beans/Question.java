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
@Table(name = "QUESTIONS")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false, name = "ID")
	private int id;

	@Column(length = 1024, name = "CONTENT")
	private String content;

	@Column(name = "CREATED_ON")
	private Timestamp createdOn;

	// Foreign Key
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SURVEY_QUESTIONS", joinColumns = @JoinColumn(name = "QUESTION_ID"), inverseJoinColumns = @JoinColumn(name = "SURVEY_ID"))
	private List<Survey> surveys;

	public Question() {
		super();
	}

	public Question(String content, Timestamp createdOn) {
		super();
		this.content = content;
		this.createdOn = createdOn;
	}

	public Question(int id, String content, Timestamp createdOn) {
		super();
		this.id = id;
		this.content = content;
		this.createdOn = createdOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", createdOn=" + createdOn + "]";
	}

}
