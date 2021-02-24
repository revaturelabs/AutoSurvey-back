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
@Table(name="answer")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", updatable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="response_id")
	private Response response;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	//TODO: Adjust column length
	@Column(length=1024, name="content")
	private String content;
	
}
