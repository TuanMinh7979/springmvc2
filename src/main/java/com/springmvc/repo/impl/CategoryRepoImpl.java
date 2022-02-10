package com.springmvc.repo.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.springmvc.pojo.Category;
import com.springmvc.repo.CategoryRepo;

@Repository
@Transactional
public class CategoryRepoImpl implements CategoryRepo {
	@Override
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		Session session = this.ses.getObject().getCurrentSession();
		return session.get(Category.class, categoryId);

	}

	@Autowired
	private LocalSessionFactoryBean ses;

	@Override

	public List<Category> getCategories() {
		Session s = ses.getObject().getCurrentSession();
		Query q = s.createQuery("FROM Category");
		return q.getResultList();

	}

}
