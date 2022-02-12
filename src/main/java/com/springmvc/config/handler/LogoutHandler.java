package com.springmvc.config.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class LogoutHandler implements LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("currentUser");
		System.out.println("ABC: Da remove currentUser");
		response.sendRedirect("/Springmvc1/login");
		
	}
	
	

}
