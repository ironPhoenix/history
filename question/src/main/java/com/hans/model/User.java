package com.hans.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String username;
	private String phoneNumber;
	private String workSpace;
	private int score;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Id
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWorkSpace() {
		return workSpace;
	}

	public void setWorkSpace(String workSpace) {
		this.workSpace = workSpace;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
