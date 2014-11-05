package com.hans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.dao.InfoDao;
import com.hans.model.Info;
import com.hans.util.PaginationUtil;

@Service
public class InfoService {
	private InfoDao infoDao;

	public int add(Info info) {
		return infoDao.add(info);
	}

	public void delete(Info info) {
		infoDao.delete(info);
	}

	public void update(Info info) {
		infoDao.update(info);
	}

	public List<Info> getAll() {
		return infoDao.getAll();
	}

	public PaginationUtil getByPage(int pageSize, int pageNumber) {
		return infoDao.getByPage(pageSize, pageNumber);
	}

	public Info getById(int id) {
		return infoDao.getById(id);
	}

	public InfoDao getInfoDao() {
		return infoDao;
	}

	@Autowired
	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}
}
