package com.zjipst.cjj.service;

import java.util.List;

import com.zjipst.cjj.model.User;

public interface UserService {
	
	 public User getUserById(int userId); 
	 
	 public List<User> getAllUsers(); 

}
