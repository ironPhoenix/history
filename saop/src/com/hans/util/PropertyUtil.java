package com.hans.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtil {
	private Properties prop;
	private static PropertyUtil propertyUtil = null;
	private Log logger = LogFactory.getLog(PropertyUtil.class);

	private PropertyUtil() {
	}

	public static PropertyUtil getInstance() {
		if (propertyUtil == null) {
			propertyUtil = new PropertyUtil();
		}
		return propertyUtil;
	}

	/**
	 * ��ȡ�����������ļ�
	 */
	public Properties getProperty(String path) {
		if (logger.isDebugEnabled()) {
			logger.debug("��ȡ�����ļ�:" + path);
		}
		prop = new Properties();
		// BufferedInputStream in;
		try {
			// in = new BufferedInputStream(new FileInputStream(path));
			// prop.load(in);
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("datainfo.properties"));
		} catch (FileNotFoundException e) {
			if (logger.isErrorEnabled()) {
				logger.error("�Ҳ��������ļ�", e);
			}
		} catch (IOException e) {
			if (logger.isErrorEnabled()) {
				logger.error("��ȡ�ļ�ʧ��", e);
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("��ȡ�����ļ��ɹ�");
		}
		return prop;
	}
}
