package com.hans.dao;

import java.sql.SQLException;
import java.util.List;

import com.hans.bean.Info;

public interface InfoDao {
	int add(Info info) throws SQLException;

	List<Object> getAll() throws SQLException;
}
