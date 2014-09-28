package com.hans.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hans.mapping.EntityMapping;

public class JdbcTemplate {
	private Connection con;
	private PreparedStatement psta = null;
	private ResultSet rs = null;
	private static JdbcTemplate jdbcTemplate = null;
	private Log logger = LogFactory.getLog(JdbcTemplate.class);

	private JdbcTemplate() {
	}

	public static JdbcTemplate getInstance() {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate();
		}
		return jdbcTemplate;
	}

	/**
	 * ע�����ݿ�����
	 * 
	 * @param connection
	 */
	public void setConnection(Connection connection) {
		con = connection;
	}

	/**
	 * ����ִ��insert��update��delete��䣬�ɴ�����
	 * 
	 * @param sql
	 * @param values
	 * @return ����Ӱ������
	 * @throws DAOException
	 */
	public int update(String sql, Object... values) {
		if (logger.isDebugEnabled()) {
			logger.debug("����sql��䣺" + sql);
		}
		int row = 0;
		try {
			psta = con.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				psta.setObject(i + 1, values[i]);
			}
			row = psta.executeUpdate();
		} catch (SQLException e) {
			String errorMsg = "sql��䷢������sql���Ϊ��" + sql;
			if (logger.isErrorEnabled()) {
				logger.error(errorMsg, e);
			}
			throw new RuntimeException(errorMsg);
		} finally {
			close();
		}
		return row;
	}

	/**
	 * ��ѯһ��doubleֵ
	 * 
	 * @param sql
	 * @return
	 */
	public double queryDouble(String sql, Object... values) {
		if (logger.isDebugEnabled()) {
			logger.debug("����sql��䣺" + sql);
		}
		double result = 0;
		try {
			psta = con.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				psta.setObject(i + 1, values[i]);
			}
			rs = psta.executeQuery();
			if (rs.next()) {
				result = rs.getDouble(1);
			}
		} catch (SQLException e) {
			String errorMsg = "sql��䷢������sql���Ϊ��" + sql;
			if (logger.isErrorEnabled()) {
				logger.error(errorMsg, e);
			}
			throw new RuntimeException(errorMsg);
		} finally {
			close();
		}
		return result;
	}

	/**
	 * ����ִ��select count��*�����,���߻�ȡseq���е����
	 * 
	 * @param sql
	 * @return ���ص�һ��ֵ
	 * @throws DAOException
	 */
	public int query(String sql) {
		if (logger.isDebugEnabled()) {
			logger.debug("����sql��䣺" + sql);
		}
		int result = 0;
		try {
			psta = con.prepareStatement(sql);
			rs = psta.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			String errorMsg = "sql��䷢������sql���Ϊ��" + sql;
			if (logger.isErrorEnabled()) {
				logger.error(errorMsg, e);
			}
			throw new RuntimeException(errorMsg);
		} finally {
			close();
		}
		return result;
	}

	/**
	 * ����ִ�в�ѯ���ض�������sql���
	 * 
	 * @param sql
	 * @param mapping
	 * @param values
	 * @return ���ض�������
	 * @throws DAOException
	 */
	public List<Object> query(String sql, EntityMapping mapping,
			Object... values) {
		if (logger.isDebugEnabled()) {
			logger.debug("����sql��䣺" + sql);
		}
		List<Object> list = new ArrayList<Object>();
		try {
			psta = con.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				psta.setObject(i + 1, values[i]);
			}
			rs = psta.executeQuery();

			while (rs.next()) {

				list.add(mapping.mapping(rs));
				System.out.println(list.size());
			}
		} catch (SQLException e) {
			String errorMsg = "sql��䷢������sql���Ϊ��" + sql;
			if (logger.isErrorEnabled()) {
				logger.error(errorMsg, e);
			}
			throw new RuntimeException(errorMsg);
		} finally {
			close();
		}
		return list;
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @throws DAOException
	 */
	public void close() {
		try {
			if (psta != null) {
				psta.close();
				psta = null;
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			String errorMsg = "�ر�preparedstatment ��resultset��������";
			if (logger.isErrorEnabled()) {
				logger.error(errorMsg, e);
			}
			throw new RuntimeException(errorMsg);
		}
	}
}
