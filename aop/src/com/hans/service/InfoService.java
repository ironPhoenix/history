package com.hans.service;

import java.util.List;

import com.hans.bean.Info;

public interface InfoService {
	int add(Info info);
	List<Object> getAll();
	int delete(String id);
	Object getByid(int id);
	int saveById(Info info);
}
