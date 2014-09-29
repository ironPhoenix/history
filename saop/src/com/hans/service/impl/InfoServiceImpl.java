package com.hans.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hans.bean.Info;
import com.hans.dao.InfoDao;
import com.hans.service.InfoService;

@Component("infoService")
public class InfoServiceImpl implements InfoService {

	private InfoDao infoDao;

	public InfoDao getInfoDao() {
		return infoDao;
	}

	@Resource
	public void setInfoDao(InfoDao infoDao) {
		System.out.println(infoDao + "adsfasdfasdfasdfasdfasdfasdfasdfasdfasd");
		this.infoDao = infoDao;
	}

	@Override
	public int add(Info info) {
		System.out.println(this.infoDao + "adsfasdfasdfasdfasdfasdfasdfasdfasdfasd");
		infoDao.add(info);
		return 0;

	}

	@Override
	public List<Object> getAll() {

		List<Object> list = infoDao.getAll();
		return list;
	}

	@Override
	public int delete(String id) {
		infoDao.delete(id);
		return 0;
	}

	@Override
	public Object getByid(int id) {

		List<Object> list = null;

		list = infoDao.getByid(id);

		return list.get(0);
	}

	@Override
	public int saveById(Info info) {
		infoDao.saveById(info);
		return 0;
	}

	// @Override
	// public Pagination getByPage(int pageSize, int pageNumber) {
	// DBManager db = DBManager.getInstance();
	// Connection conn = db.getConnection();
	// InfoDaoImpl idi = new InfoDaoImpl();
	// idi.setConnection(conn);
	// Pagination pagination = null;
	//
	// InfoDao id = new InfoDaoImpl();
	// try {
	// pagination = id.getByPage(pageSize, pageNumber);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return pagination;
	// }

}
