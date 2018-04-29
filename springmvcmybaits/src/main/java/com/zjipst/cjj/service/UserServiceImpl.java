package com.zjipst.cjj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjipst.cjj.dao.UserDao;
import com.zjipst.cjj.dao.UserMapper;
import com.zjipst.cjj.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource  
    private UserMapper userMapper;  
	
	@Resource  
    private UserDao userDao; 

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey((short) userId);  
	}
	
	public List<User> getAllUsers() {
		return this.userMapper.findAllUsers();  
	}

}
