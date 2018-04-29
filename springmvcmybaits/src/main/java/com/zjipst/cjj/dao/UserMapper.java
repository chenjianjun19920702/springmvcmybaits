package com.zjipst.cjj.dao;

import java.util.List;

import com.zjipst.cjj.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Short id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public List<User> findAllUsers();
}