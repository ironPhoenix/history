package com.hans.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hans.model.Dan;
import com.hans.model.Duo;
import com.hans.model.Pan;
import com.hans.model.User;

@Repository
public class TestDao {

	private SessionFactory sessionFactory;

	@Autowired
	public TestDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addDan(Dan dan) {
		sessionFactory.getCurrentSession().saveOrUpdate(dan);
	}

	public void addPan(Pan pan) {
		sessionFactory.getCurrentSession().saveOrUpdate(pan);
	}

	public void addDan(Duo duo) {
		sessionFactory.getCurrentSession().saveOrUpdate(duo);
	}

	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public boolean checkPhoneNumberExist(String phoneNumber) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from User u where u.phoneNumber = :phoneNumber");
		query.setString("phoneNumber", phoneNumber);
		long l = (Long) query.uniqueResult();
		return l == 1;
	}

	public Dan getDanById(long id) {
		return (Dan) sessionFactory.getCurrentSession().get(Dan.class, id);
	}

	public Pan getPanById(long id) {
		return (Pan) sessionFactory.getCurrentSession().get(Pan.class, id);
	}

	public Duo getDuoById(long id) {
		return (Duo) sessionFactory.getCurrentSession().get(Duo.class, id);
	}
}
