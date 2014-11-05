package com.hans.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hans.model.Info;
import com.hans.service.InfoService;
import com.hans.util.PaginationUtil;

@Controller
@RequestMapping("/info")
public class InfoControl {

	public InfoService getInfoService() {
		return infoService;
	}

	@Autowired
	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	private InfoService infoService;

	@RequestMapping("/add")
	public String add(String name, String message) {
		Info info = new Info();
		info.setName(name);
		info.setMessage(message);
		info.setInfoTime(new Date());
		infoService.add(info);
		return "forward:list";

	}

	@RequestMapping("/list")
	public String list(String pageNumber, ModelMap map) {
		System.out.println(pageNumber);

		int pageSize = 10;

		int pageNumberInt;
		try {
			// 获取当前页码

			pageNumberInt = Integer.parseInt(pageNumber);
			System.out.println(pageNumberInt);

		} catch (Exception e) {
			// 如果没有获取到当前页码那么将当前页码设置为1
			pageNumberInt = 1;
		}

		PaginationUtil paginationUtil = infoService.getByPage(pageSize,
				pageNumberInt);
		map.put("infoList", paginationUtil.getList());
		map.put("currentPageNumber", paginationUtil.getCurrentPageNumber());
		System.out.println(paginationUtil.getCurrentPageNumber());
		map.put("maxPageNumber", paginationUtil.getMaxPageNumber());
		return "../allInfo";

	}
}
