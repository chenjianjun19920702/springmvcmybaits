package com.zjipst.cjj;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class ExampleTypeHandler extends BaseTypeHandler<String> {

	public ExampleTypeHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNullableResult(ResultSet arg0, String arg1)
			throws SQLException {
		return arg0.getString(arg1) + " ExampleTypeHandler...";
	}

	@Override
	public String getNullableResult(ResultSet arg0, int arg1)
			throws SQLException {
		return arg0.getString(arg1) + " ExampleTypeHandler...";
	}

	@Override
	public String getNullableResult(CallableStatement arg0, int arg1)
			throws SQLException {
		return arg0.getString(arg1) + " ExampleTypeHandler...";
	}

	@Override
	public void setNonNullParameter(PreparedStatement arg0, int arg1,
			String arg2, JdbcType arg3) throws SQLException {
		arg0.setString(arg1, "cjj ExampleTypeHandler...");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
