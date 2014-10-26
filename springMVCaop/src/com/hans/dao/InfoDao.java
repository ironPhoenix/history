package com.hans.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hans.model.Info;

@Repository
public class InfoDao {
	private SessionFactory sessionFactory;
	
	@Autowired
	public InfoDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int add(Info info) {
		sessionFactory.getCurrentSession().save(info);
		System.out.println(info.getId());
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
				.createQuery("from Info info")
				.setFirstResult(1)
				.setMaxResults(3);
		list = query.list();
		return list;
	}

	public Info getById(int id) {
		return (Info) sessionFactory.getCurrentSession().get(Info.class, id);
	}
}
