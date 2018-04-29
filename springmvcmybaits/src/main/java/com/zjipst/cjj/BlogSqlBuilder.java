package com.zjipst.cjj;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class BlogSqlBuilder {

	// If not use @Param, you should be define same arguments with mapper method
	public String buildGetBlogsByName(
			final String name, final String orderByColumn) {
		return new SQL(){{
			SELECT("*");
			FROM("blog");
			WHERE("name like #{name} || '%'");
			ORDER_BY(orderByColumn);
		}}.toString();
	}

	// If use @Param, you can define only arguments to be used
//	public String buildGetBlogsByAuthor(@Param("orderByColumn") final String orderByColumn) {
//		return new SQL(){{
//			SELECT("*");
//			FROM("blog");
//			WHERE("author like #{author} || '%'");
//			ORDER_BY(orderByColumn);
//		}}.toString();
//	}

	public String buildGetBlogsByName22(final String name) {
		return new SQL(){{
			SELECT("*");
			FROM("blog");
			WHERE("name like #{name} || '%'");
			ORDER_BY("blog_id");
		}}.toString();
	}

}
