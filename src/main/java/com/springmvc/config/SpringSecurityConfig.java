package com.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springmvc.config.handler.LoginSuccessHandler;
import com.springmvc.config.handler.LogoutHandler;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.springmvc.repo", "com.springmvc.service" })
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationSuccessHandler loginSuccessHandler;

	@Autowired
	private LogoutSuccessHandler logoutHandler;



	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		// return 1 class o ben ngoai de tao bean(dung de autowired)
		return new LoginSuccessHandler();

	}

	@Bean
	public LogoutSuccessHandler logoutHandler() {
		return new LogoutHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	// Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password");

//		http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
		// muon lam gi khi dang nhap thi dung phuong thuc nay
		http.formLogin().successHandler(this.loginSuccessHandler).failureUrl("/login?error");

//		http.logout().logoutSuccessUrl("/login");
		http.logout().logoutSuccessHandler(this.logoutHandler);

		http.exceptionHandling().accessDeniedPage("/login?accessDenied");
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.csrf().disable();
	}
}
