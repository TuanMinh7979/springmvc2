package com.springmvc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.pojo.Comment;
import com.springmvc.pojo.Product;
import com.springmvc.pojo.User;
import com.springmvc.repo.CommentRepo;
import com.springmvc.repo.ProductRepo;
import com.springmvc.repo.UserRepo;
import com.springmvc.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Override
	public Comment addComment(String content, int productId) {
		// TODO Auto-generated method stub
		Product p = productRepo.getProductById(productId);
		User u = userRepo.getUserById(1);

		Comment c = new Comment();
		c.setNoidung(content);
		c.setProduct(p);
		c.setUser(u);
		c.setCreatedDate(new Date());
		c = commentRepo.addComment(c);
		return c;
	}

}
