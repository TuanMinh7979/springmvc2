package com.springmvc.repo;

import java.util.List;

import com.springmvc.pojo.Category;

public interface CategoryRepo {
//	default List<Category> getCategories1(){
//		return null;
//	}
	
    List<Category> getCategories();

	public Category getCategoryById(int categoryId) ;
		

}
