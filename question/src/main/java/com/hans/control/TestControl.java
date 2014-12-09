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
		LocalTime startTime = LocalTime.now();
		session.setAttribute("startTime", startTime);
		session.setAttribute("isCommitTest", false);
		return getTest(map, session);
	}

	private String getTest(ModelMap map, HttpSession session) {
		List<Integer> danInt = RandomInt.getRandomIntList(25, 0, 38);
		List<Dan> listDan = testService.getDanListByIntList(danInt);
		List<Integer> panInt = RandomInt.getRandomIntList(10, 0, 19);
		List<Pan> listPan = testService.getPanListByIntList(panInt);
		List<Integer> duoInt = RandomInt.getRandomIntList(10, 0, 18);
		List<Duo> listDuo = testService.getDuoListByIntList(duoInt);
		map.put("listDan", listDan);
		map.put("listPan", listPan);
		map.put("listDuo", listDuo);
		session.setAttribute("danInt", danInt);
		session.setAttribute("panInt", panInt);
		session.setAttribute("duoInt", duoInt);
		return "../user/test";
	}

	// public String getResult(String dan0,String pan0,String duo0,ModelMap
	// map,HttpSession session)
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String getResult(String dan0, String dan1, String dan2, String dan3,
			String dan4, String dan5, String dan6, String dan7, String dan8,
			String dan9, String dan10, String dan11, String dan12,
			String dan13, String dan14, String dan15, String dan16,
			String dan17, String dan18, String dan19, String dan20,
			String dan21, String dan22, String dan23, String dan24,
			String pan0, String pan1, String pan2, String pan3, String pan4,
			String pan5, String pan6, String pan7, String pan8, String pan9,
			String duo0, String duo1, String duo2, String duo3, String duo4,
			String duo5, String duo6, String duo7, String duo8, String duo9,
			ModelMap map, HttpSession session) {
		if((boolean)session.getAttribute("isCommitTest")) {
			return "../error/commitBan";
		}
		session.setAttribute("isCommitTest", true);
		List<Integer> danInt = (List<Integer>) session.getAttribute("danInt");
		List<Integer> panInt = (List<Integer>) session.getAttribute("panInt");
		List<Integer> duoInt = (List<Integer>) session.getAttribute("duoInt");
		LocalTime startTime = (LocalTime) session.getAttribute("startTime");
		if (LocalTime.now().isAfter(startTime.plusHours(1))) {
			return "../error/timeout";
		}
		int score = 0;
		if (testService.getDanResultById(danInt.get(0)).equals(dan0))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(1)).equals(dan1))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(2)).equals(dan2))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(3)).equals(dan3))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(4)).equals(dan4))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(5)).equals(dan5))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(6)).equals(dan6))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(7)).equals(dan7))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(8)).equals(dan8))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(9)).equals(dan9))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(10)).equals(dan10))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(11)).equals(dan11))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(12)).equals(dan12))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(13)).equals(dan13))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(14)).equals(dan14))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(15)).equals(dan15))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(16)).equals(dan16))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(17)).equals(dan17))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(18)).equals(dan18))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(19)).equals(dan19))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(20)).equals(dan20))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(21)).equals(dan21))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(22)).equals(dan22))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(23)).equals(dan23))
			score = score + 2;
		if (testService.getDanResultById(danInt.get(24)).equals(dan24))
			score = score + 2;
		// 写25次
		if (testService.getPanResultById(panInt.get(0)).equals(pan0))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(1)).equals(pan1))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(2)).equals(pan2))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(3)).equals(pan3))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(4)).equals(pan4))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(5)).equals(pan5))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(6)).equals(pan6))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(7)).equals(pan7))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(8)).equals(pan8))
			score = score + 2;
		if (testService.getPanResultById(panInt.get(9)).equals(pan9))
			score = score + 2;
		// 写10次
		if (testService.getDuoResultById(duoInt.get(0)).equals(duo0))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(1)).equals(duo1))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(2)).equals(duo2))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(3)).equals(duo3))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(4)).equals(duo4))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(5)).equals(duo5))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(6)).equals(duo6))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(7)).equals(duo7))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(8)).equals(duo8))
			score = score + 3;
		if (testService.getDuoResultById(duoInt.get(9)).equals(duo9))
			score = score + 3;
		// 写10次
		User user = (User) session.getAttribute("user");
		user.setScore(score);
		testService.saveUser(user);
		map.put("score", score);
		if (score >= 70)
			return "../user/success";
		return "../user/fail";
	}
}
