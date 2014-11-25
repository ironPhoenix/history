package com.hans.control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hans.model.Authority;
import com.hans.model.Book;
import com.hans.model.BookKind;
import com.hans.model.Borrower;
import com.hans.service.TestService;

public class TestControl {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"a-servlet.xml");
		TestService ts = context.getBean("testService", TestService.class);
		//System.out.println(ts.getBorrowMaxTimesByAuthorityId("1"));
		BookKind bookKind = new BookKind();
		bookKind.setAuthor("hans");
		bookKind.setBookName("think in java");
		bookKind.setIndexNumber("tp312ja709");
		//bookKind.setPublishTime(new Date());
		Authority a = new Authority();
		a.setAuthorityId("1");
		a.setBorrowMaxTimes(12);
		a.setRenewMaxTimes(1);
		//ts.addBookKind(bookKind);
		Borrower borrower = new Borrower();
		borrower.setStudentId("12");
		borrower.setAuthority(a);
		//System.out.println(ts.getBorrowedNumberByBorrower(borrower));
		for(Book book:ts.getBooksByStudentId("12")) {
			System.out.println(book.getBookKind().getBookName());
		}
	}
}
