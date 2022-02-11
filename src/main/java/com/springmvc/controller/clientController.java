package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springmvc.pojo.CartI;
import com.springmvc.service.CategoryService;
import com.springmvc.utils.utils;

@Controller
public class clientController {
	@Autowired
	private CategoryService categoryService;
	@ModelAttribute
	public void commonAtr(Model model) {
		model.addAttribute("categories", this.categoryService.getCategories());
	}

	@ModelAttribute
	public void getcartCounter(Model model, HttpSession ses) {

		model.addAttribute("cartCounter", utils.countCart((Map<Integer, CartI>) ses.getAttribute("cartMap")));
	}

}
