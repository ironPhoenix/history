package com.hans.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hans.util.PropertyUtil;

public class DBManager {
	private Properties prop;
	private String path = "src/datainfo.properties";
	private PropertyUtil propertyUtil;
	private static DBManager dbManager = null;
	private Log logger = LogFactory.getLog(DBManager.class);

	private DBManager() {
	}

	public static DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}

	/**
	 * @return ����ݿ����l��
	 */
	public Connection getConnection() {
		if (propertyUtil == null) {
			propertyUtil = PropertyUtil.getInstance();
			if (prop == null) {
				prop = propertyUtil.getProperty(path);
				if (logger.isInfoEnabled()) {
					logger.info("��ȡ��ݿ������ļ���	" + path);
				}
			}
		}
		Connection conn = null;
		try {
			Class.forName(prop.getProperty("DRIVER"));
			conn = DriverManager.getConnection(
					prop.getProperty("DBURL") + prop.getProperty("DBNAME"),
					prop.getProperty("USERNAME"), prop.getProperty("USERPWD"));
			conn.setAutoCommit(false);// ��������Զ��ύ���Ժ���ҵ���������񣬾���Ҫ����Ϊfalse��
			if (logger.isInfoEnabled()) {
				logger.info("��ȡ��ݿ������ļ��ɹ���");
			}
		} catch (ClassNotFoundException e) {
			if (logger.isErrorEnabled()) {
				logger.error("�Ҳ�����ݿ���");
			}
		} catch (SQLException e) {
			if (logger.isErrorEnabled()) {
				logger.error("l��ʧ�ܣ�");
			}
		}
		return conn;
	}
}
