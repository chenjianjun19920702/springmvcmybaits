package com.zjipst.cjj;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String name;

    private String content;

    private Date time;

    private String status;

    private Integer blogId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
    
    @Override
    public String toString() {
    	return "commentId:"+commentId+",blogId:"+blogId+",name:"+name
    			+",content:"+content+",time:"+time+",status:"+status;
    }

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}