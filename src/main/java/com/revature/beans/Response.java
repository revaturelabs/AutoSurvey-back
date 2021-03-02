package com.revature.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@OneToMany
	@JoinColumn(name = "RESPONSE_ID")
	private List<Answer> answers;

	public Response() {
		super();
	}

	public Response(int id, Timestamp submittedAt, List<Answer> answers) {
		super();
		this.id = id;
		this.submittedAt = submittedAt;
		this.answers = answers;
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

}
