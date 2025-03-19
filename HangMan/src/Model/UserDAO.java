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
	int result = 0;
	
	
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
	
	public boolean Login(UserDTO dto) {
		getConn();
		String sql = "SELECT * FROM USERS WHERE USER_ID = ? USER_PW =?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return true;
	
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
