package com.hans.service;

import java.util.List;

import com.hans.bean.Info;

public interface InfoService {
	int add(Info info);
	List<Object> getAll();
}
