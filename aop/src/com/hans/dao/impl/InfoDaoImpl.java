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

	@Override
	public int delete(String id) throws SQLException {
		String sql = "delete from info where id=?";
		
		int row = jdbcTemplate.update(sql, id);
		System.out.println(row+"        "+id);
		return row;
	}

	@Override
	public List<Object> getByid(int id) throws SQLException {
		String sql = "select * from info where id=?";
		return jdbcTemplate.query(sql,
				mappingFactory.getMapping(MappingFactory.INFO_MAPPING),id);
	}

	@Override
	public int saveById(Info info) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE info SET name = ?, message = ? WHERE id=?";

		int row = jdbcTemplate.update(sql, info.getName(), info.getMessage(),info.getId());
		return row;
	}

}
