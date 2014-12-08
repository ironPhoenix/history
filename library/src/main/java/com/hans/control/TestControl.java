package com.hans.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hans.service.TestService;
@Controller
@RequestMapping("/test")
public class TestControl {
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	@RequestMapping(value = "/a", method = RequestMethod.POST)
	public void login(String vehicle) {
		System.out.println(vehicle.equals("A,B,C"));
	}
	
}
