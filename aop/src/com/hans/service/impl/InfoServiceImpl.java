package com.hans.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hans.bean.Info;
import com.hans.dao.InfoDao;
import com.hans.dao.impl.InfoDaoImpl;
import com.hans.db.DBManager;
import com.hans.service.InfoService;

public class InfoServiceImpl implements InfoService {

	public int add(Info info) {
		// TODO Auto-generated method stub
		int row = 0;
		DBManager db = DBManager.getInstance();
		Connection conn = db.getConnection();
		InfoDaoImpl idi = new InfoDaoImpl();
		idi.setConnection(conn);

		InfoDao id = new InfoDaoImpl();

		try {
			row = id.add(info);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(this.getClass().getName() + "rollback出错");
				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(this.getClass().getName() + "关闭连接出错");
			}
		}
		return row;

	}

	@Override
	public List<Object> getAll() {
		DBManager db = DBManager.getInstance();
		Connection conn = db.getConnection();
		InfoDaoImpl idi = new InfoDaoImpl();
		idi.setConnection(conn);
		List<Object> list = null;

		InfoDao id = new InfoDaoImpl();
		try {
			list = id.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
