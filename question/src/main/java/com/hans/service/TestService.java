package com.hans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.dao.TestDao;
import com.hans.model.Dan;
import com.hans.model.Duo;
import com.hans.model.Pan;
import com.hans.model.User;

@Service
public class TestService {
	private TestDao testDao;

	public TestDao getTestDao() {
		return testDao;
	}

	@Autowired
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	public void addDan(Dan dan) {
		testDao.addDan(dan);
	}
	public void saveUser(User user) {
		testDao.saveUser(user);
	}

	public boolean checkPhoneNumberExist(String phoneNumber) {
		return testDao.checkPhoneNumberExist(phoneNumber);
	}

	public List<Dan> getDanListByIntList(List<Integer> intlist) {
		List<Dan> list = new ArrayList<>();
		for (int i : intlist) {
			list.add(testDao.getDanById(i));
		}
		return list;
	}

	public List<Pan> getPanListByIntList(List<Integer> intlist) {
		List<Pan> list = new ArrayList<>();
		for (int i : intlist) {
			list.add(testDao.getPanById(i));
		}
		return list;
	}

	public List<Duo> getDuoListByIntList(List<Integer> intlist) {
		List<Duo> list = new ArrayList<>();
		for (int i : intlist) {
			list.add(testDao.getDuoById(i));
		}
		return list;
	}

	public String getDanResultById(int id) {
		Dan d = testDao.getDanById(id);
		return d.getAnswer();
	}

	public String getPanResultById(int id) {
		Pan p = testDao.getPanById(id);
		return p.getAnswer();
	}

	public String getDuoResultById(int id) {
		Duo d = testDao.getDuoById(id);
		return d.getAnswer();
	}
}
