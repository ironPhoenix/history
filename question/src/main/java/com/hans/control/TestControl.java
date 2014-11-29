package com.hans.control;

import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hans.model.Dan;
import com.hans.model.Duo;
import com.hans.model.Pan;
import com.hans.model.User;
import com.hans.service.TestService;
import com.hans.util.RandomInt;

@Controller
@RequestMapping("/test")
public class TestControl {
	private List<Integer> danInt;
	private List<Integer> panInt;
	private List<Integer> duoInt;
	private LocalTime startTime;

	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@RequestMapping(value = "/checkAndGet", method = RequestMethod.POST)
	public String checkAll(String username, String phoneNumber,
			String workSpace, HttpSession session, ModelMap map) {
		if (username == null || phoneNumber == null) {
			return "../error/nullValue";
		}
		if (!username.matches(".{2,4}") || !phoneNumber.matches("1\\d{10}")) {
			return "../error/matchError";
		}
		if (testService.checkPhoneNumberExist(phoneNumber)) {
			return "../error/phoneExist";
		}
		User user = new User();
		user.setPhoneNumber(phoneNumber);
		user.setUsername(username);
		user.setWorkSpace(workSpace);
		testService.saveUser(user);
		session.setAttribute("user", user);
		startTime = LocalTime.now();
		System.out.println(startTime);
		return getTest(map);
	}

	private String getTest(ModelMap map) {
		//danInt = RandomInt.getRandomIntList(25, 0, 39);
		danInt = RandomInt.getRandomIntList(2, 0, 2);
		List<Dan> listDan = testService.getDanListByIntList(danInt);
		//panInt = RandomInt.getRandomIntList(10, 0, 19);
		panInt = RandomInt.getRandomIntList(2, 0, 2);
		List<Pan> listPan = testService.getPanListByIntList(panInt);
		//duoInt = RandomInt.getRandomIntList(10, 0, 19);
		duoInt = RandomInt.getRandomIntList(2, 0, 2);
		List<Duo> listDuo = testService.getDuoListByIntList(duoInt);
		map.put("listDan", listDan);
		map.put("listPan", listPan);
		map.put("listDuo", listDuo);
		return "../user/test";
	}

	/*
	 * String getResult(String dan0...,String pan0...,String duo0...) {
	 * if(checkTime.isBefore(startTime+1hour)) { int score = 0;
	 * if(dan0.equals(getDanResultById(danInt.get(0))) score = score+2; //写25次
	 * if(pan0.equals(getPanResultById(panInt.get(0))) score = score+2; //写10次
	 * if(duo0.equals(getDuoResultById(duoInt.get(0))) score = score+3; //写10次
	 * updateUser if(score>=70) //胜利界面 else//失败界面 } }
	 */
}
