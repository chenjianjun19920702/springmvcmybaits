package com.zjipst.cjj.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5069819006906154312L;

	private Short id;

    private String username;

    private String password;

    private Short age;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
    
    @Override 
    public String toString() { 
    	return "User [id=" + id + ", username=" + username + 
    			", password=" + password +  ", age=" + age + " ]"; 
    }
    
}