package com.hans.dao;

import java.sql.SQLException;
import java.util.List;

import com.hans.bean.Info;

public interface InfoDao {
	int add(Info info) throws SQLException;

	List<Object> getAll() throws SQLException;

	int delete(String id) throws SQLException;

	List<Object> getByid(int id) throws SQLException;

	int saveById(Info info) throws SQLException;
}
