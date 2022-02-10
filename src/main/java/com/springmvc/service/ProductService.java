package com.springmvc.service;

import java.util.List;

import com.springmvc.pojo.Product;

public interface ProductService  {
	List<Product> getProducts(String kw, int page);
	boolean addOrUpdate(Product product);
	long countProduct();
	public Product getProductById(int productId) ;
}
