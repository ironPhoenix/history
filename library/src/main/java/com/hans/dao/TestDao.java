package com.hans.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hans.model.Authority;
import com.hans.model.Book;
import com.hans.model.BookKind;
import com.hans.model.Borrower;
import com.hans.util.PaginationUtil;

@Repository
public class TestDao {

	private SessionFactory sessionFactory;

	@Autowired
	public TestDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int addBook(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		return book.getBookId();
	}

	public void addBookKind(BookKind bookKind) {
		sessionFactory.getCurrentSession().save(bookKind);
	}

	public int getBorrowedNumberByBorrower(Borrower borrower) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(*) from Book b where b.borrower = :borrower");
		query.setEntity("borrower", borrower);
		long l = (Long) query.uniqueResult();
		return (int) l;
	}

	public int getBorrowMaxTimesByAuthorityId(String authorityId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select a.borrowMaxTimes from Authority a where a.authorityId= :authorityId");
		query.setString("authorityId", authorityId);
		return (int) query.uniqueResult();
	}

	public void addAuthority(Authority authority) {
		sessionFactory.getCurrentSession().save(authority);
	}

	public void addBorrower(Borrower borrower) {
		sessionFactory.getCurrentSession().save(borrower);
	}

	public Borrower getBorrowerById(String id) {
		return (Borrower) sessionFactory.getCurrentSession().get(
				Borrower.class, id);
	}

	public Book getBookById(int id) {
		return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByStudentId(String studentId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Book b where b.borrower.studentId = :studentId");
		query.setString("studentId", studentId);
		return (List<Book>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByIndexNumber(String indexNumber) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Book b where b.bookKind.indexNumber = :indexNumber");
		query.setString("indexNumber", indexNumber);
		return (List<Book>) query.list();
	}

	public BookKind getBookKindByIndexNumber(String indexNumber) {
		// TODO Auto-generated method stub
		return (BookKind) sessionFactory.getCurrentSession().get(
				BookKind.class, indexNumber);
	}

	public PaginationUtil getBookKindsByPage(String bookName, int pageSize,
			int pageNumber) {
		String hql = "from BookKind b where b.bookName like '%" + bookName
				+ "%'";
		return new PaginationUtil(sessionFactory.getCurrentSession(), hql,
				pageSize, pageNumber);
	}

}
