package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.pojo.CartI;
import com.springmvc.service.CategoryService;
import com.springmvc.service.ProductService;
import com.springmvc.utils.Utils1;

@Controller
@ControllerAdvice
public class HomeController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	// chi co cac trang trong HomeController moi co the co cac modelAttribute chung
	// nay thoi
	// =>TA DUNG CONTROLLER ADVICE THI TAT CA CAC PAGE KO PHAI CUA CONTROLLER NAY
	// CUNG CO THE CO CAC
	// ATTRIBUTE BEN DUOI
	@ModelAttribute
	public void commonAtr(Model model, HttpSession ses) {
		model.addAttribute("categories", this.categoryService.getCategories());
		model.addAttribute("currentUser", ses.getAttribute("currentUser"));
	}

	@ModelAttribute
	public void getcartCounter(Model model, HttpSession ses) {

		model.addAttribute("cartCounter", Utils1.countCart((Map<Integer, CartI>) ses.getAttribute("cartMap")));
	}
	// chi co cac trang trong HomeController moi co the co cac modelAttribute chung
	// nay thoi

	@GetMapping("/")
	public String index(Model model, @RequestParam Map<String, String> params, HttpSession ses) {

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
