package com.springmvc.repo.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.pojo.User;
import com.springmvc.repo.UserRepo;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

	@Autowired
	private LocalSessionFactoryBean ses;

	@Override
	public boolean addUser(User user) {

		// TODO Auto-generated method stub
		Session session = ses.getObject().getCurrentSession();
		try {
			session.save(user);
			return true;
		} catch (HibernateException ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public List<User> getUsers(String username) {
		// TODO Auto-generated method stub
		Session session = ses.getObject().getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> q = builder.createQuery(User.class);
		Root root = q.from(User.class);

		q = q.select(root);

		if (!username.isEmpty()) {
			Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
			q = q.where(p);
		}
		Query qu = session.createQuery(q);
		return qu.getResultList();

	}

}
