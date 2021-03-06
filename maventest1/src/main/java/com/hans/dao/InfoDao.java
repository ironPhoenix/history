package com.hans.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hans.model.Info;
import com.hans.util.PaginationUtil;

@Repository
public class InfoDao {
	private SessionFactory sessionFactory;

	@Autowired
	public InfoDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int add(Info info) {
		sessionFactory.getCurrentSession().save(info);
		return 0;
	}

	public void delete(Info info) {
		sessionFactory.getCurrentSession().delete(info);
	}

	public void update(Info info) {
		sessionFactory.getCurrentSession().update(info);
	}

	public List<Info> getAll() {
		List<Info> list = new ArrayList<>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Info info").setFirstResult(1)
				.setMaxResults(3);
		list = query.list();
		return list;
	}

	public PaginationUtil getByPage(int pageSize, int pageNumber) {
		String hql = "from Info info";
		return new PaginationUtil(sessionFactory.getCurrentSession(), hql,
				pageSize, pageNumber);

	}

	public Info getById(int id) {
		return (Info) sessionFactory.getCurrentSession().get(Info.class, id);
	}
}
