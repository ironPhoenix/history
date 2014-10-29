package com.hans.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hans.model.Info;
import com.hans.service.InfoService;

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
		infoService.add(info);
		return "forward:list";

	}

	@RequestMapping("/list")
	public String list(ModelMap map) {
		map.put("infoList", infoService.getAll());
		return "../allInfo";

	}
}
