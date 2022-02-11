package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.pojo.CartI;

@Controller
public class CartController  {

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		Map<Integer, CartI> cartMap = (Map<Integer, CartI>) session.getAttribute("cartMap");
		if (cartMap != null)
			model.addAttribute("carts", cartMap.values());
		else
			model.addAttribute("carts", null);

		return "cart";
	}
}
