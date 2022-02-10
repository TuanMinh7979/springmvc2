package com.springmvc.repo.impl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.springmvc.pojo.Comment;
import com.springmvc.repo.CommentRepo;

@Repository
@Transactional
public class CommentRepoImpl implements CommentRepo {
	@Autowired
	private LocalSessionFactoryBean ses;

	@Override
	public Comment addComment(Comment c) {
		Session session = this.ses.getObject().getCurrentSession();
		try {
			session.save(c);
			return c;
		} catch (HibernateException ex) {
			ex.printStackTrace();

		}
		return null;
	}

}
