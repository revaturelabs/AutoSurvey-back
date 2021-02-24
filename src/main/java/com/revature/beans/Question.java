package com.revature.beans;

<<<<<<< Updated upstream
public class Question {
=======
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, name="ID")
	private int id;
	@Column(length=1024,name="CONTENT")
	private String content;
	@Column(name="CREATED_ON")
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
>>>>>>> Stashed changes

}
