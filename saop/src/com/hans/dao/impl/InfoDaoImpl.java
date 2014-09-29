package com.hans.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hans.bean.Info;
import com.hans.dao.InfoDao;

@Component("InfoDao")
public class InfoDaoImpl extends BaseDao implements InfoDao {

	@Override
	public int add(Info info) {
		this.getHibernateTemplate().save(info);
		return 0;
	}

	@Override
	public List<Object> getAll() {
		// this.getHibernateTemplate().setMaxResults(3);
		List<Object> list = (List<Object>) this.getHibernateTemplate().find(
				"from Info limit " + 1 + "," + 3);
		return list;
	}

	@Override
	public int delete(String id) {
		Info info = (Info) this.getHibernateTemplate().get(Info.class,
				Integer.valueOf(id));
		System.out.println(info + "qwerrrrrrrrrrrrrrrrrrrrr");
		this.getHibernateTemplate().delete(info);

		return 0;
	}

	@Override
	public List<Object> getByid(int id) {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find(
				"from Info i where i.id = ?", id);
		return list;
	}

	@Override
	public int saveById(Info info) {
		this.getHibernateTemplate().update(info);
		return 0;
	}

	public List<Object> getByPage(int pageSize, int pageNumber) {
		String sql = "select * from info";

		this.getHibernateTemplate().setMaxResults(pageSize);
		return null;
	}

}
