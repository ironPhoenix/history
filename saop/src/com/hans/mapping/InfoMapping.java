package com.hans.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hans.bean.Info;

public class InfoMapping implements EntityMapping {
	public Object mapping(ResultSet rs) throws SQLException {
		Info info = new Info();
		info.setId(rs.getInt("id"));
		info.setName(rs.getString("name"));
		info.setMessage(rs.getString("message"));
		return info;
	}
}
