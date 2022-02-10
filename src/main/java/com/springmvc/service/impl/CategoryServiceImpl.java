package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.pojo.Category;
import com.springmvc.repo.CategoryRepo;
import com.springmvc.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo repo;

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.repo.getCategories();
	}

	@Override
	public Category getCategoryById(int categoryId) {
		
		return repo.getCategoryById(categoryId);
	}

}
