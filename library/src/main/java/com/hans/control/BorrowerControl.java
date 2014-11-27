package com.hans.control;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		if (username.equals(password))
			return getInfo(username, session);
		return "../error/loginError";
	}

	private String getInfo(String username, HttpSession session) {
		session.setAttribute("borrower", testService.getBorrowerById(username));
		return "../borrower/main";
	}
	@RequestMapping(value = "/reBorrow", method = RequestMethod.POST)
	private String reBorrow(int bookId, HttpSession session) {
		Set<Book> books = ((Borrower) session.getAttribute("borrower"))
				.getBooks();

		for (Book b : books) {
			if (b.getBookId() == bookId) {
				b.setRenewedTimes(b.getRenewedTimes() + 1);
				break;
			}
		}
		return "../borrower/main";
	}
}
