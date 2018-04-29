package com.zjipst.cjj;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zjipst.cjj.dao.UserMapper;
import com.zjipst.cjj.model.User;

public class MyBaitsConnect {

	public MyBaitsConnect() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String resource = "com/zjipst/cjj/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			inputStream = null;
			e.printStackTrace();
		} 
		// 这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在,最简单的就是使用单例模式或者静态单例模式
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		builder = null;
		// 每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Blog> blogs = null;
		Blog blog = new Blog();
		BlogMapper mapper = null;
		try {
			mapper = sqlSession.getMapper(BlogMapper.class);
			
			// 方式一  需要强制类型转换
//			blog = (Blog) sqlSession.selectOne("selectBlog", 1);
			
			// 方式二  使用映射器类
			// 映射器是创建用来绑定映射语句的接口。
//			blog = mapper.selectBlog(1);
			
			// 方式三 使用注解的方式
//			blog = mapper.selectBlogWithAnnotation(1);
//			System.out.println(blog.toString());
			
//			blog = new Blog();
//			blog.setAuthorId(1);
//			blog.setName("name");
//			blog.setBrief("ddddd2");
//			blog.setContent("xxxxx");
//			blog.setSource("zzzzzz");
//			int res = mapper.insertBlog(blog);
//			sqlSession.commit();
//			// 自增id直接映射到对象里了
//			System.out.println(blog.toString());
			
//			blogs = new ArrayList<Blog>();
//			for (int i=0;i<2;i++) {
//				Long time = System.currentTimeMillis();
//				blog = new Blog();
//				blog = new Blog();
//				blog.setAuthorId(1);
//				blog.setName("name"+time);
//				blog.setBrief("ddddd2"+time);
//				blog.setContent("xxxxx"+time);
//				blog.setSource("zzzzzz"+time);
//				blogs.add(blog);
//			}
//			int res = mapper.insertBlogs(blogs);
//			System.out.println(res);
//			sqlSession.commit();
//			for (Blog bl:blogs) {
//				System.out.println(bl.toString());
//			}
			
//			blog = new Blog();
//			blog.setAuthorId(1);
//			blog.setName("name1");
//			blog.setBrief("ddddd1");
//			blog.setContent("xxxxx1");
//			blog.setSource("zzzzzz1");
//			int res = mapper.updateBlog(blog);
//			sqlSession.commit();
//			System.out.println(blog.toString());
			
//			int res = mapper.deleteBlog(10);
//			System.out.println("id="+res);
//			sqlSession.commit();
			
//			blogs = mapper.selectBlogs();
//			System.out.println("******************selectBlogs***************************");
//			for (Blog bl : blogs) {
//				System.out.println(bl.toString());
//			}
			
//			blogs = sqlSession.selectList("getBlogs");
//			blogs = mapper.getBlogs();
//			System.out.println("*******************getBlogs*************************");
//			for (Blog bl : blogs) {
//				System.out.println(bl.toString());
//			}
			
//			有错误待解决
//			blogs = mapper.getBlogsByName("博客测试", "name");
//			System.out.println("*******************getBlogsByName*************************");
//			for (Blog bl : blogs) {
//				System.out.println(bl.toString());
//			}
			
//			System.out.println("*******************getBlogsByName22*************************");
//			blogs = mapper.getBlogsByName22("s");
//			for (Blog bl : blogs) {
//				System.out.println(bl.toString());
//			}
			
//			System.out.println("*******************selectBlogDetails*************************");
//			List<BlogDetail> blogDetails = mapper.selectBlogDetails(8);
//			for (BlogDetail bd : blogDetails) {
//				bd.print();
//			}
			
//			System.out.println("*******************MyCustomCache*************************");
//			blog = mapper.selectBlog(1);
//			blog = mapper.selectBlog(1);
//			blog = mapper.selectBlog(1);
			
		} finally {
			// 确保用完关闭，释放资源
			sqlSession.close();
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			inputStream = null;
			e.printStackTrace();
		}
	}

}
