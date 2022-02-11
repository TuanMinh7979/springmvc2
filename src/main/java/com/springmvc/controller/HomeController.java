package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.pojo.CartI;
import com.springmvc.service.CategoryService;
import com.springmvc.service.ProductService;
import com.springmvc.utils.utils;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@ModelAttribute
	public void commonAtr(Model model) {
		model.addAttribute("categories", this.categoryService.getCategories());
	}

	@ModelAttribute
	public void getcartCounter(Model model, HttpSession ses) {

		model.addAttribute("cartCounter", utils.countCart((Map<Integer, CartI>) ses.getAttribute("cartMap")));
	}

	@GetMapping("/")
	public String index(Model model, @RequestParam Map<String, String> params) {

		String kw = params.getOrDefault("kw", null);
		int page = Integer.parseInt(params.getOrDefault("page", "1"));

		String cateId = params.get("CateId");
		if (cateId == null) {
			model.addAttribute("products", this.productService.getProducts(kw, page));

		} else {
			model.addAttribute("products", this.categoryService.getCategoryById(Integer.valueOf(cateId)).getProducts());
		}
		model.addAttribute("discussProducts", this.productService.getMostDisscussProduct(3));
		model.addAttribute("productCounter", this.productService.countProduct());

		return "index";
	}
}
