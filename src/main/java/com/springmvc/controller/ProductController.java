package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmvc.pojo.Product;
import com.springmvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
  
	@GetMapping("/products/{productId}")
	public String detail(Model model, @PathVariable(value = "productId") int productId) {
		Product p= this.productService.getProductById(productId);
		model.addAttribute("p", p);
		//chi getComment hay get trong view thi deu can dung EAGER
		//neu khong muon dung EAGER(do join nhieu) thi ta truy van thang vao bang comment
		
		model.addAttribute("comments", p.getComments());
		return "product-detail";

	}
}
