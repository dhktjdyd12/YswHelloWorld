package com.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection getConect() {
		Connection conn = null;
		String user = "ysw";
		String passwd ="ysw";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String driver = "oracle.jdbc.driver.OracleDriver";
	
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

