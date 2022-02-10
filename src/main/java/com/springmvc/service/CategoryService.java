package com.springmvc.service;

import java.util.List;

import com.springmvc.pojo.Category;

public interface CategoryService {
	List<Category> getCategories();

	public Category getCategoryById(int categoryId);
}
