package com.springmvc.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springmvc.pojo.User;

public interface UserService extends UserDetailsService {
	boolean addUser(User user);

	List<User> getUsers(String username);
	User getUserById(int userid);
}
