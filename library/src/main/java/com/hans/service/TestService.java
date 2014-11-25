package com.hans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.dao.TestDao;
import com.hans.model.Authority;
import com.hans.model.Book;
import com.hans.model.BookKind;
import com.hans.model.Borrower;
import com.hans.util.PaginationUtil;

@Service
public class TestService {
	private TestDao testDao;

	public TestDao getTestDao() {
		return testDao;
	}

	@Autowired
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	public int addBook(Book book) {
		return testDao.addBook(book);
	}

	public void addBookKind(BookKind bookKind) {
		testDao.addBookKind(bookKind);
	}

	public int getBorrowedNumberByBorrower(Borrower borrower) {
		return testDao.getBorrowedNumberByBorrower(borrower);
	}
	public int getBorrowMaxTimesByAuthorityId(String authorityId) {	
		return testDao.getBorrowMaxTimesByAuthorityId(authorityId);
	}
	public void addAuthority(Authority authority) {
		testDao.addAuthority(authority);
	}

	public void addBorrower(Borrower borrower) {
		testDao.addBorrower(borrower);
	}

	public Borrower getBorrowerById(String id) {
		return testDao.getBorrowerById(id);
	}

	public Book getBookById(int id) {
		return testDao.getBookById(id);
	}

	public List<Book> getBooksByStudentId(String studentId) {
		return testDao.getBooksByStudentId(studentId);
	}

	public List<Book> getBooksByIndexNumber(String indexNumber) {
		return testDao.getBooksByIndexNumber(indexNumber);
	}

	public BookKind getBookKindByIndexNumber(String indexNumber) {
		return testDao.getBookKindByIndexNumber(indexNumber);		
	}
	
	public PaginationUtil getBookKindsByPage(String bookName, int pageSize,
			int pageNumber) {
		return testDao.getBookKindsByPage(bookName, pageSize, pageNumber);
	}
}
