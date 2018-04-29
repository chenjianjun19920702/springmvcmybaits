package com.zjipst.cjj.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.zjipst.cjj.util.SerializableUtil;

import redis.clients.jedis.Jedis;

public class RedisCache implements Cache {
	
	private static Logger logger = LogManager.getLogger(RedisCache.class);	//日志管理 
	private String id; 
//	private Jedis redisClient = createRedis(); //创建一个jedis连接 
//	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //读写锁
	private Jedis redisClient = null; //创建一个jedis连接 
	private ReadWriteLock readWriteLock = null; //读写锁

	public RedisCache() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 从连接池中取
	 * @return
	 */
	private static Jedis createRedis() { 
		// 从连接池获取redis连接 
		Jedis jedis = RedisPool.getPool().getResource(); 
		return jedis; 
	}
	
	public RedisCache(String id) { 
		if(id == null) { 
			throw new IllegalArgumentException("Cache instance requires an ID"); 
		} 
		logger.debug("create an cache instance with id" + id); 
		this.id = id; 
	}

	public String getId() {
		System.out.println("getId-->" + id);
		return this.id;
	}

	public void putObject(Object obj, Object obj1) {
		System.out.println("putObject--key:" + obj);
		System.out.println("putObject--value:" + obj1);
		byte[] keybyte = SerializableUtil.serialize(obj); 
		byte[] valuebyte = SerializableUtil.serialize(obj1); 
		this.redisClient.set(keybyte, valuebyte);
	}

	public Object getObject(Object obj) {
		System.out.println("getObject--key:" + obj);
		// 缓存穿透 
		byte[] values = this.redisClient.get(SerializableUtil.serialize(obj)); 
		// 算法：计算一定时间内没有命中的键，存起来 key->value 
		if (values == null) { 
			return null; 
		} 
		return SerializableUtil.unserizlize(values);
	}

	public Object removeObject(Object obj) {
		System.out.println("removeObject--value:" + obj);
		byte[] keybyte = SerializableUtil.serialize(obj); 
		return this.redisClient.expire(keybyte, 0);
	}

	public void clear() {
		this.redisClient.flushDB();
	}

	public int getSize() {
		System.out.println("getSize");
		Long size = this.redisClient.dbSize(); 
		int s =Integer.valueOf(size+""); 
		return s;
	}

	public ReadWriteLock getReadWriteLock() {
		System.out.println("getReadWriteLock");
		return this.readWriteLock;
	}
	
	public void setReadWriteLock(ReadWriteLock readWriteLock) { 
		this.readWriteLock = readWriteLock; 
	}

}
