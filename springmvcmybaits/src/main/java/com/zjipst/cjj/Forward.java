package com.zjipst.cjj;

public class Forward {
    private Integer forwardId;

    private String direction;

    private String name;

    private Integer blogId;
    
    @Override
    public String toString() {
    	return "forwardId:"+forwardId+",blogId:"+blogId+",name:"+name
    			+",direction:"+direction;
    }

    public Integer getForwardId() {
        return forwardId;
    }

    public void setForwardId(Integer forwardId) {
        this.forwardId = forwardId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}