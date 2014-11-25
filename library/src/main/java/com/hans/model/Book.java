package com.hans.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {
	private int bookId;
	private BookKind bookKind;
	private String room;
	private Borrower borrower;
	private Date borrowedDate;
	private int renewedTimes;

	@Id
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@ManyToOne
	@JoinColumn(name = "indexNumber", nullable = false)
	public BookKind getBookKind() {
		return bookKind;
	}

	public void setBookKind(BookKind bookKind) {
		this.bookKind = bookKind;
	}

	@Column(nullable = false)
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@ManyToOne
	@JoinColumn(name = "studentId", nullable = true)
	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	@Temporal(value = TemporalType.DATE)
	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	@Column(nullable = true)
	public int getRenewedTimes() {
		return renewedTimes;
	}

	public void setRenewedTimes(int renewedTimes) {
		this.renewedTimes = renewedTimes;
	}

}
