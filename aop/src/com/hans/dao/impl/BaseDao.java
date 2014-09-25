package com.hans.dao.impl;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hans.db.JdbcTemplate;
import com.hans.mapping.MappingFactory;

public class BaseDao {
	protected JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	protected MappingFactory mappingFactory = MappingFactory.getInstance();
	protected Log logger = LogFactory.getLog("DAOLogger");

	/**
	 * 设置connectionݿ�l����
	 * 
	 * @param connection
	 */
	public void setConnection(Connection connection) {
		jdbcTemplate.setConnection(connection);
	}
}
