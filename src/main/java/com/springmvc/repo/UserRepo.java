package com.springmvc.repo;

import java.util.List;

import com.springmvc.pojo.User;

public interface UserRepo {
	boolean addUser(User user);
    List<User> getUsers(String username);
    User getUserById(int userid);
    

}
