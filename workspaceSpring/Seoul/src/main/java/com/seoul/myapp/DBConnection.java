package com.seoul.myapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	protected Connection conn = null;
	protected PreparedStatement pstmt= null;
	protected ResultSet rs = null;
	protected String sql = "";
	
	public DBConnection() {}
	
	// db����
	public void dbConn() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env");
			
			DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// db����
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			sql = "";
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
