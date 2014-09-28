package com.hans.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapping {
	public Object mapping(ResultSet rs) throws SQLException;
}
