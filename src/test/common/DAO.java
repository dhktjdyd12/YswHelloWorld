package test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection getConect() {
		Connection conn = null;
		
		// DB 접속정보
		String user = "ysw";       // 접속할 곳 아이디
		String passwd ="ysw";      // 접속할 곳 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 드라이버 로딩변수 driver 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
	
		try {
			// 드라이버 로딩
			Class.forName(driver);
			
			// 연결을 관리하는 connection 객체 conn 생성
			conn = DriverManager.getConnection(url, user, passwd);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
