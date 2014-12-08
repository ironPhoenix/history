package com.hans.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hans.model.BookKind;
import com.hans.service.TestService;
import com.hans.util.PaginationUtil;

@Controller
@RequestMapping("/search")
public class SearchControl {
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	@RequestMapping(value = "/find")
	public String findBook(String bookName,String pageNumber, ModelMap map,HttpSession session) {
		int pageSize = 10;
		int pageNumberInt;
		if(bookName==null) {
			bookName= (String) session.getAttribute("bookName");
		}else {
			session.setAttribute("bookName", bookName);
		}
		pageNumberInt = (pageNumber==null)?1:Integer.parseInt(pageNumber);
		PaginationUtil paginationUtil = testService.getBookKindsByPage(bookName, pageSize, pageNumberInt);
		map.put("bookKindList", paginationUtil.getList());
		map.put("currentPageNumber", paginationUtil.getCurrentPageNumber());
		System.out.println(paginationUtil.getCurrentPageNumber());
		map.put("maxPageNumber", paginationUtil.getMaxPageNumber());
		return "../user/resultList";
	}
	@RequestMapping(value = "/look")
	public String lookBook(String indexNumber, ModelMap map) {
		BookKind bk = testService.getBookKindByIndexNumber(indexNumber);
		map.put("bookKind", bk);
		return "../user/bookInfo";
	}
}
