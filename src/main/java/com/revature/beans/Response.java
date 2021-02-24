package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSES")
public class Response {

	@Id
	@Column(updatable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id = 0;

	@Column(name = "VERSION")
	private String version;

	@Column(name = "CREATED_ON")
	private Timestamp created_on;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(int id, String version, Timestamp created_on) {
		super();
		this.id = id;
		this.version = version;
		this.created_on = created_on;
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

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", version=" + version + ", created_on=" + created_on + "]";
	}

}
