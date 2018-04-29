package com.zjipst.cjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import com.zjipst.cjj.model.User;

//@CacheNamespace(implementation=(com.zjipst.cjj.cache.RedisCache.class))
public interface UserDao {
	
	@Select("select * from users") 
	public List<User> findAllUsers();
}
