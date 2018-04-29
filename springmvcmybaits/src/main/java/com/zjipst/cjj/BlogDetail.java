package com.zjipst.cjj;

import java.util.List;

public class BlogDetail {
    private Integer blogId;

    private Integer authorId;

    private String name;

    private String brief;

    private String content;

    private String source;
    
    private Author author;
    
    private List<Comment> comments;
    
    private List<Forward> forwards;
    
    @Override
    public String toString() {
    	return "blogId:"+blogId+",authorId:"+authorId+",name:"+name
    			+",content:"+content+",brief:"+brief+",source:"+source;
    }
    
    public void print() {
    	System.out.println("*******************BlogDetail Begin*************************");
    	System.out.println("blogId:"+blogId+",authorId:"+authorId+",name:"+name
    			+",content:"+content+",brief:"+brief+",source:"+source);
    	System.out.println(author.toString());
		for (Comment c : comments) {
			System.out.println(c.toString());
		}
		for (Forward f : forwards) {
			System.out.println(f.toString());
		}
		System.out.println("*******************BlogDetail End*************************");
    }
 
    
    public BlogDetail(Integer blogId,Integer authorId,String name,
    		String brief,String content,String source) {
    	this.blogId = blogId;
    	this.authorId = authorId;
    	this.name = name;
    	this.brief = brief;
    	this.content = content;
    	this.source = source;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Forward> getForwards() {
		return forwards;
	}

	public void setForwards(List<Forward> forwards) {
		this.forwards = forwards;
	}
}