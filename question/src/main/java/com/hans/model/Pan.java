package com.hans.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pan {
	private long id;
	private String question;
	private String answer;

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}



}
