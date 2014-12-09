package com.hans.control;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hans.model.Book;
import com.hans.model.Borrower;
import com.hans.service.TestService;

@Controller
@RequestMapping("/borrower")
public class BorrowerControl {
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@RequestMapping(value = "/login")
	public String login(String username, String password, HttpSession session) {
		System.out.println(username);
		Borrower b = testService.getBorrowerById(username);	
		if(b==null) 
			return "../error/loginError";
		if (b.getKeyword().equals(password))
			return getInfo(username, session);
		return "../error/loginError";
	}

	private String getInfo(String username, HttpSession session) {
		session.setAttribute("borrower", testService.getBorrowerById(username));
		return "../borrower/main";
	}
	@RequestMapping(value = "/reBorrow")
	public String reBorrow(int bookId, HttpSession session) {
		Borrower borrower = (Borrower) session.getAttribute("borrower");
		
		Set<Book> books = borrower.getBooks();
		
		for (Book b : books) {
			if (b.getBookId() == bookId) {
				if(b.getRenewedTimes()>=borrower.getAuthority().getRenewMaxTimes())
					return "../error/renewError";
				b.setRenewedTimes(b.getRenewedTimes() + 1);
				testService.addBook(b);
				break;
			}
		}
		return "../borrower/main";
	}
	@RequestMapping(value = "/repass")
	public String rePassword(String password,String newpassword, HttpSession session) {
		
		Borrower borrower = (Borrower) session.getAttribute("borrower");
		if(!borrower.getKeyword().equals(password)) 
			return "../error/repassError";
		borrower.setKeyword(newpassword);
		testService.addBorrower(borrower);
		return "../borrower/main";
	}
}
