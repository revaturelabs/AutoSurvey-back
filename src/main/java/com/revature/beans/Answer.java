package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID", updatable=false)
	private int id;
		
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	//TODO: Adjust column length
	@Column(length=1024, name="CONTENT")
	private String content;
	
	public Answer() {
		
	}

	public Answer(int id, Question question, String content) {
		super();
		this.id = id;
		this.question = question;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id +  ", question=" + question + ", content=" + content + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	// Equivalence is determined solely by the id field
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
