package com.springmvc.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmvc.pojo.User;
import com.springmvc.repo.UserRepo;
import com.springmvc.service.UserService;

@Service("UserDetailsService")
//ten su dung de di autowired mot doi tuong UserService extends UserDetailsService
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> users = this.getUsers(username);
		if (users.isEmpty())
			throw new UsernameNotFoundException("Nguoi dung khong ton tai");
		User user = users.get(0);
		Set<GrantedAuthority> auths = new HashSet<>();
		auths.add(new SimpleGrantedAuthority(user.getUserRole()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auths);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		String password = user.getPassword();
		user.setPassword(this.passwordEncoder.encode(password));
		user.setUserRole(User.USER);

		return this.userRepo.addUser(user);
	}

	@Override
	public List<User> getUsers(String username) {
		// TODO Auto-generated method stub
		return this.userRepo.getUsers(username);
	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return userRepo.getUserById(userid);
	}

}
