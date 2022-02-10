package com.springmvc.repo;

import java.util.List;

import com.springmvc.pojo.Product;

public interface ProductRepo {
	List<Product> getProducts(String kw, int page);

	long countProduct();

	boolean addOrUpdate(Product product);

	Product getProductById(int productId);
}
