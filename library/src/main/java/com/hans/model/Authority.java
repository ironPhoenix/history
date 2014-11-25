package com.hans.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authority {
	private String authorityId;
	private int borrowMaxTimes;
	private int renewMaxTimes;

	@Id
	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public int getBorrowMaxTimes() {
		return borrowMaxTimes;
	}

	public void setBorrowMaxTimes(int borrowMaxTimes) {
		this.borrowMaxTimes = borrowMaxTimes;
	}

	public int getRenewMaxTimes() {
		return renewMaxTimes;
	}

	public void setRenewMaxTimes(int renewMaxTimes) {
		this.renewMaxTimes = renewMaxTimes;
	}

}
