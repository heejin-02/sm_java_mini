package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void getConn() { //DB 접속 메소드
		try {
			// getConn
			// - 드라이버 로딩, url/user/pw로 db접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@ project-db-campus.smhrd.com:1523:xe";
			String user = "hapjeong_24SW_DS_p1_1";
			String password = "smhrd1";
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
