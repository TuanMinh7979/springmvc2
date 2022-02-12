package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.pojo.User;
import com.springmvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userDetailsService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String registerView(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(Model model, @ModelAttribute(value = "user") User user) {
		System.out.println("VAO DAY DANG KY");
		if (user.getPassword().isEmpty() || !user.getPassword().equals(user.getConfirmPassword())) {
			model.addAttribute("errMsg", "Mat khau khong khop");
		} else {
			if (this.userDetailsService.addUser(user)) {
				return "redirect:/login";
			}
			model.addAttribute("errMsg", "co loi xay ra vui long quay lai sau!");
		}
		return "register";
	}
}
