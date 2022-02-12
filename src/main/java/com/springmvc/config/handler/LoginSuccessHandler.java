package com.springmvc.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.springmvc.pojo.User;
import com.springmvc.service.UserService;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	private UserService userDetailsService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User user = this.userDetailsService.getUsers(authentication.getName()).get(0);
		request.getSession().setAttribute("currentUser", user);
		response.sendRedirect("/Springmvc1/");

	}

}
