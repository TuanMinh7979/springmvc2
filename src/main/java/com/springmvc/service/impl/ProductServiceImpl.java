package com.springmvc.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.pojo.Product;
import com.springmvc.repo.ProductRepo;
import com.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo repo;

	@Override
	public List<Product> getProducts(String kw, int page) {
		// TODO Auto-generated method stub
		return repo.getProducts(kw, page);
	}

	@Override
	public boolean addOrUpdate(Product product) {
		MultipartFile img = product.getFile();
		String rootdir = "C:\\Users\\ASUS\\eclipse-workspace\\StaticResoure\\src\\main\\webapp\\resources\\img\\";

		System.out.println("vao day upload");
		String linktoimg = rootdir + product.getFile().getOriginalFilename();
		System.out.println(linktoimg);
		try {
			img.transferTo(new File(linktoimg));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.setImage(product.getFile().getOriginalFilename());
		return repo.addOrUpdate(product);

	}

	@Override
	public long countProduct() {

		return repo.countProduct();
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return repo.getProductById(productId);
	}

	@Override
	public List<Object[]> getMostDisscussProduct(int num) {
		// TODO Auto-generated method stub
		return repo.getMostDisscussProduct(num);
	}

}
