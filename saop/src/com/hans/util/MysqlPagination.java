package com.hans.util;

import java.sql.Connection;
import java.util.List;
import java.util.regex.Pattern;

import com.hans.db.DBManager;
import com.hans.db.JdbcTemplate;
import com.hans.mapping.EntityMapping;

public class MysqlPagination implements Pagination {

	private int pageSize = 5;

	private int pageNumber = 1;

	private int maxPages;

	private int maxElements;
	private String sql;
	private DBManager db;
	private JdbcTemplate jtm;
	private Connection conn;



	public MysqlPagination(String sql) {
		this.sql = sql;
		init();
	}

	public MysqlPagination(String sql, int pageSize, int pageNumber) {
		this.sql = sql;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		init();
		this.setPageNumber(pageNumber);
	}

	private void init() {
		db = DBManager.getInstance();
		conn = db.getConnection();
		jtm = JdbcTemplate.getInstance();
		jtm.setConnection(conn);
		setMaxElements();
		setMaxPages();
	}


	private void setMaxElements() {


		String regex = "select((.)+)from";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		String[] s = p.split(this.sql);
		String newSql = "select count(1) as total from " + s[1];

		this.maxElements = jtm.query(newSql);
	}


	private void setMaxPages() {
		if (maxElements != 0 && (maxElements % pageSize == 0)) {
			maxPages = maxElements / pageSize;
		} else {
			maxPages = maxElements / pageSize + 1;
		}
	}


	private String sqlModify(String sql, int begin, int end) {
		StringBuffer target = new StringBuffer(200);
		target.append(sql);
		target.append(" limit ");
		target.append(begin-1);
		target.append(",");
		target.append(end-begin+1);
		return target.toString();
	}


	private int getEndElement() {
		int endElement = pageNumber * pageSize;
		if (endElement >= maxElements) {
			return maxElements;
		} else {
			return endElement;
		}
	}

	private int getBeginElement() {
		return (pageNumber - 1) * pageSize + 1;
	}


	public List<Object> getList(EntityMapping mapping) {
		String newSql = this.sqlModify(this.sql, this.getBeginElement(), this
				.getEndElement());
		return (List<Object>) jtm.query(newSql, mapping);
	}



	public int getMaxElements() {
		// Auto-generated method stub
		return maxElements;
	}

	public int getMaxPages() {
		return maxPages;
	}


	public int getNext() {
		if (pageNumber + 1 >= this.getMaxPages()) {
			return getMaxPages();
		}
		return pageNumber + 1;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPrevious() {
		if (pageNumber - 1 <= 1) {
			return 1;
		} else {
			return pageNumber - 1;
		}
	}

	public boolean hasNext() {
		return pageNumber < this.getMaxPages();
	}

	public boolean hasPrevious() {
		return pageNumber > 1;
	}

	public boolean isFirst() {
		return pageNumber == 1;
	}

	public boolean isLast() {
		return pageNumber >= this.getMaxPages();
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber > maxPages) {
			this.pageNumber = maxPages;
		} else if (pageNumber < 1) {
			this.pageNumber = 1;
		} else {
			this.pageNumber = pageNumber;
		}

	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;

	}

}
