package com.hans.control;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hans.model.Book;
import com.hans.model.BookKind;
import com.hans.model.Borrower;
import com.hans.service.TestService;

@Controller
@RequestMapping("/admin")
public class AdminControl implements ServletContextAware {
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password) {
		if (username.equals(password))
			return "../admin/borrowBook";
		return "../error/loginError";
	}

	@RequestMapping(value = "/addbk", method = RequestMethod.POST)
	public String addBookKind(String indexNumber, String bookName,
			String author, String publishing, String publishTime,
			@RequestParam("bookPicture") CommonsMultipartFile file) {
		String path = this.servletContext.getRealPath("/tmp/");
		System.out.println(path);
		String fileName = file.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		File file2 = new File(path, indexNumber + fileType); 
		try {
			file.getFileItem().write(file2); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		BookKind bk = new BookKind();
		bk.setAuthor(author);
		bk.setBookName(bookName);
		bk.setIndexNumber(indexNumber);
		bk.setPublishing(publishing);
		bk.setPublishTime(publishTime);
		testService.addBookKind(bk);
		return "../admin/borrowBook";
	}

	@RequestMapping(value = "/addb", method = RequestMethod.POST)
	public String addBook(String indexNumber, String bookId, String room) {
		try {
			Book b = new Book();
			b.setBookId(Integer.valueOf(bookId));
			b.setRoom(room);
			System.out.println(indexNumber);
			b.setBookKind(testService.getBookKindByIndexNumber(indexNumber));
			testService.addBook(b);
			return "../admin/borrowBook";
		} catch (Exception e) {
			return "../error/addBookError";
		}
	}

	@RequestMapping(value = "/borroweb", method = RequestMethod.POST)
	public String borrowBook(String studentId, String bookId) {
		try {
			Borrower borrower = testService.getBorrowerById(studentId);
			int borrowedNumber = testService
					.getBorrowedNumberByBorrower(borrower);
			int borrowMaxTimes = testService
					.getBorrowMaxTimesByAuthorityId(borrower.getAuthority()
							.getAuthorityId());
			if (borrowedNumber < borrowMaxTimes) {
				Book b = testService.getBookById(Integer.valueOf(bookId));
				b.setBorrower(borrower);
				b.setBorrowedDate(new Date());
				b.setRenewedTimes(0);
				testService.addBook(b);
				return "../admin/borrowBook";
			}
			return "../error/borrowMaxError";
		} catch (Exception e) {
			return "../error/borrowError";
		}
	}

	@RequestMapping(value = "/returnb", method = RequestMethod.POST)
	public String returnBook(String bookId) {
		try {
			Book b = testService.getBookById(Integer.valueOf(bookId));

			Date borrowedDate = b.getBorrowedDate();
			LocalDate date = LocalDate.parse(
					new SimpleDateFormat("yyyy-MM-dd").format(borrowedDate),
					DateTimeFormatter.ISO_LOCAL_DATE);
			int renewedTimes = b.getRenewedTimes();
			b.setBorrower(null);
			b.setBorrowedDate(null);
			b.setRenewedTimes(0);
			testService.addBook(b);
			
			System.out.println(date);
			System.out.println(LocalDate.now());
			if(date.plusDays((renewedTimes+1)*30).isAfter(LocalDate.now()))
				return "../admin/borrowBook";
			return "../admin/forfeit";
		} catch (Exception e) {
			return "../error/returnError";
		}
	}
}
