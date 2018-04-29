package com.zjipst.cjj;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

public interface BlogMapper {
	
	  Blog selectBlog(int blogId);
	  
	  List<Blog> selectBlogs();
	  
	  List<BlogDetail> selectBlogDetails(int blogId);
	  
	  int insertBlog(Blog blog);
	  
	  int insertBlogs(List<Blog> blog);
	  
	  int updateBlog(Blog blog);
	  
	  int deleteBlog(int blogId);
	  
	  /*映射器注解*/
	  @Select("SELECT "
	  		+ "blog_id as blogId,"
	  		+ "author_id as authorId,"
	  		+ "name as name,"
	  		+ "brief as brief,"
	  		+ "content as content,"
	  		+ "source as source "
	  		+ "FROM blog "
	  		+ "WHERE "
	  		+ "blog_id = #{blogId}")
	  Blog selectBlogWithAnnotation(int blogId);
	  
	  /*@Insert("insert into blog (id,author,brief,content,source) values(#{nameId},#{author},#{brief},#{content},#{source})")
	  @SelectKey(statement="call next value for blog", keyProperty="nameId", before=true, resultType=int.class)
	  int insertBlogWithAnnotation(Blog blog);*/
	  
	  @Select("select * from blog")
	  @Results({
	    @Result(property = "blogId", column = "blog_id", id = true),
	    @Result(property = "authorId", column = "author_id"),
	    @Result(property = "brief", column = "brief"),
	    @Result(property = "name", column = "name"),
	    @Result(property = "content", column = "content"),
	    @Result(property = "source", column = "source")
	  })
	  List<Blog> getBlogs();
	  
	  @SelectProvider(type = BlogSqlBuilder.class, method = "buildGetBlogsByName")
	  @Results({
		  	@Result(property = "blogId", column = "blog_id", id = true),
		    @Result(property = "authorId", column = "author_id"),
		    @Result(property = "brief", column = "brief"),
		    @Result(property = "name", column = "name"),
		    @Result(property = "content", column = "content"),
		    @Result(property = "source", column = "source")
		  })
	  List<Blog> getBlogsByName(@Param("name") String name, @Param("orderByColumn") String orderByColumn);
	  
	  @SelectProvider(type = BlogSqlBuilder.class, method = "buildGetBlogsByName22")
	  @Results({
		    @Result(property = "blogId", column = "blog_id", id = true),
		    @Result(property = "authorId", column = "author_id"),
		    @Result(property = "brief", column = "brief"),
		    @Result(property = "name", column = "name"),
		    @Result(property = "content", column = "content"),
		    @Result(property = "source", column = "source")
		  })
	  List<Blog> getBlogsByName22(String author);
}