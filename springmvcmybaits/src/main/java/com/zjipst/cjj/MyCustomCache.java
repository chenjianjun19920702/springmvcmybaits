package com.zjipst.cjj;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;

public class MyCustomCache implements Cache {

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private ConcurrentHashMap<Object, Object> cache = new ConcurrentHashMap<Object, Object>();
	private String id;

	public MyCustomCache() {
		// TODO Auto-generated constructor stub
	}

	public MyCustomCache(String id) {
		this.id = id;
	}

	public void clear() {
		cache.clear();
	}

	public String getId() {
		System.out.println("getId-->" + id);
		return id;
	}

	public Object getObject(Object obj) {
		System.out.println("getObject---key:" + obj);
		return cache.get(obj);
	}

	public ReadWriteLock getReadWriteLock() {
		System.out.println("getReadWriteLock");
		return lock;
	}

	public int getSize() {
		System.out.println("getSize");
		return cache.size();
	}

	public void putObject(Object obj, Object obj1) {
		System.out.println("putObject--key:" + obj);
		System.out.println("putObject--value:" + obj1);
		cache.put(obj, obj1);
	}

	public Object removeObject(Object obj) {
		System.out.println("remove:" + obj);
		return cache.remove(obj);
	}

}
