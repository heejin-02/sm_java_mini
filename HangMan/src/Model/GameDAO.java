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
	int result = 0;
	GameDTO question = null;

	public void getConn() { // DB 접속 메소드
		try {
			// getConn
			// - 드라이버 로딩, url/user/pw로 db접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "hapjeong_24SW_DS_p1_1";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void close() { // 도구 회수 메소드

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public GameDTO getWord(GameDTO dto) { // 문제 메소드

		getConn();

		String sql = "select que_id ,lower(que_word) as que_word ,script \r\n"
				+ "from (select * from question order by DBMS_RANDOM.RANDOM)\r\n"
				+ "where sub_id = ? and difficulty = ? and rownum <2";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSub_id());
			psmt.setInt(2, dto.getDifficult());

			rs = psmt.executeQuery();

			if (rs.next()) {
				question = new GameDTO(rs.getInt("que_id"), rs.getString("que_word"), rs.getString("script"));

			} else {
				System.out.println("문제가 없습니다!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return question;

	}

	public int quewin(String id) {

		getConn();

		UserDTO dto = new UserDTO();

		String sql = "update users set score = score + 20 where user_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			close();
		}

		return result;

	}

	public int quefail(String id) {

		getConn();

		UserDTO dto = new UserDTO();

		String sql = "update users set score = score - 10 where user_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			close();
		}

		return result;

	}
	
	public int scoreSave(String id , String YN) {
	      
	      getConn();
	      String sql = "insert into final_score values (default , ? , (select score from users where user_id = ?) , ?)";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, id);
	         psmt.setString(2, id);
	         psmt.setString(3, YN);
	         
	         result = psmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      
	      
	      return result;
	      
	   }

	

}
