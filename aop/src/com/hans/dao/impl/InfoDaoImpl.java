package com.hans.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hans.bean.Info;
import com.hans.dao.InfoDao;
import com.hans.mapping.MappingFactory;

public class InfoDaoImpl extends BaseDao implements InfoDao {

	@Override
	public int add(Info info) throws SQLException {

		String sql = "insert into info values (null,?,?)";

		int row = jdbcTemplate.update(sql, info.getName(), info.getMessage());
		return row;
	}

	@Override
	public List<Object> getAll() throws SQLException {
		String sql = "select * from info";
		return jdbcTemplate.query(sql,
				mappingFactory.getMapping(MappingFactory.INFO_MAPPING));
	}

}
