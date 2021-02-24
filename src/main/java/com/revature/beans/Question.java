package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "questions")
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="questions")
	private int id;
	@Column(name="content")
	private String content;
	@Column(name="createdOn")
	private Timestamp createdOn;
	
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
