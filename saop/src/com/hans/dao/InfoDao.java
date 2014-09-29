package com.hans.dao;

import java.util.List;

import com.hans.bean.Info;

public interface InfoDao {
	int add(Info info);

	List<Object> getAll();

	int delete(String id);

	List<Object> getByid(int id);

	int saveById(Info info);

	//Pagination getByPage(int pageSize, int pageNumber);
}
