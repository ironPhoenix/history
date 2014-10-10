package com.hans.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hans.bean.Info;

@Controller
@RequestMapping("/info.do")
public class InfoAction {
	@RequestMapping(params = "method=reg")
	public String reg(String name) {
		System.out.println(name);
		return "index";
	}
	@RequestMapping(params = "method=add")
	public String add(Info info) {
		System.out.println("update");
		return "index";
	}
	
	@RequestMapping(params = "method=updateById")
	public String updateById(int id) {
		System.out.println("update");
		return "index";
	}
	
	@RequestMapping(params = "method=getById")
	public String getById(int id,HttpServletRequest request) {
		request.setAttribute("info", id);
		return "index";
	}
	
	@RequestMapping(params = "method=show")
	public String show(HttpServletRequest request) {
		request.getSession().setAttribute("id", "id");
		return "redirect:index";
	}
}
