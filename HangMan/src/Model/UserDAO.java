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
		String sql = "SELECT * FROM USERS WHERE USER_ID = ? AND USER_PW =?";
		boolean is_login = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());
			rs = psmt.executeQuery();
			if (rs.next()) { 
				// 로그인 성공
				// 이름 님 환영합니다 출력
				String uName = rs.getString("user_name");
				System.out.println(uName + "님 환영합니다~");
				is_login = true;

			} else {
				System.out.println("로그인이 실패했습니다..");
				System.out.println("아이디와 비밀번호를 확인해보세요.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return is_login;
	
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
