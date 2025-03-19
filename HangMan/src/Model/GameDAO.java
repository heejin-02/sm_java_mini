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
	
	GameDTO result = null;
	
	public void getConn() { //DB 접속 메소드
		try {
			// getConn
			// - 드라이버 로딩, url/user/pw로 db접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "hapjeong_24SW_DS_p1_1";
			String password = "smhrd1";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
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
	
	public GameDTO getWord(GameDTO dto) {
		
		getConn();
		 
		String sql = "select * \r\n"
				+ "from (select * from question order by DBMS_RANDOM.RANDOM)\r\n"
				+ "where sub_id = ? and difficulty = ? and rownum <2";
		
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,dto.getSub_id());
			psmt.setInt(2, dto.getDifficult());
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				GameDTO result = new GameDTO(rs.getInt("que_id"),rs.getString("que_word"),rs.getString("script"));
				
				
			}else{
				System.out.println("문제가 없습니다!");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
}
