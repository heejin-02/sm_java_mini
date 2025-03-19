package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	public void getConn() { //DB 접속 메소드
		try {
			// getConn
			// - 드라이버 로딩, url/user/pw로 db접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
		conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public void close() { //도구 회수 메소드

		try {
			if(rs != null)
				rs.close();
			if (psmt != null) 
				psmt.close();
			if (conn != null) 
				conn.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
