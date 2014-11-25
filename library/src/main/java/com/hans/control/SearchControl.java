package com.hans.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String findBook(String bookName,String pageNumber, ModelMap map,HttpSession session) {
		int pageSize = 10;
		int pageNumberInt;
		if(bookName==null) {
			bookName= (String) session.getAttribute("bookName");
		}else {
			session.setAttribute("bookName", bookName);
		}
		pageNumberInt = (pageNumber==null)?1:Integer.parseInt(pageNumber);
/*		try {
		// 获取当前页码
		pageNumberInt = Integer.parseInt(pageNumber);
		System.out.println(pageNumberInt);
		} catch (Exception e) {
		// 如果没有获取到当前页码那么将当前页码设置为1
		pageNumberInt = 1;
		}*/
		PaginationUtil paginationUtil = testService.getBookKindsByPage(bookName, pageSize, pageNumberInt);
		map.put("bookKindList", paginationUtil.getList());
		map.put("currentPageNumber", paginationUtil.getCurrentPageNumber());
		System.out.println(paginationUtil.getCurrentPageNumber());
		map.put("maxPageNumber", paginationUtil.getMaxPageNumber());
		return "../user/resultList";
	}
	@RequestMapping(value = "/look", method = RequestMethod.POST)
	public String lookBook(String indexNumber, ModelMap map) {
		BookKind bk = testService.getBookKindByIndexNumber(indexNumber);
		map.put("bookKind", bk);
		return "../user/bookInfo";
	}
}
