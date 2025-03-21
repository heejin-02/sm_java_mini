package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int result = 0;

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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("");
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

	public int join(UserDTO dto) {
		getConn();
		String sql = "INSERT INTO users VALUES(?,?,?,default)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());
			psmt.setString(3, dto.getUser_name());

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int delete(UserDTO dto) {
		getConn();

		String sql = "DELETE FROM users WHERE user_ID=? AND user_PW=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());

			result = psmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return result;

	}

	
	public List<UserDTO> getTop5Users() {
		List<UserDTO> userList = new ArrayList<>();
		String sql = "SELECT USER_ID, USER_NAME, SCORE FROM (SELECT * FROM USERS ORDER BY SCORE DESC) WHERE ROWNUM <= 5";

		try {
			getConn(); // DB 연결
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			// 조회된 데이터 UserDTO 객체에 저장
			while (rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				int score = rs.getInt("SCORE");

				// UserDTO 객체에 값을 넣어 리스트에 추가
				userList.add(new UserDTO(userId, null, userName, score)); // 패스워드는 null로 처리
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // DB 연결 종료
		}
		return userList;
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

	public ArrayList<ScoreDTO> info_list(String id) {
		ArrayList<ScoreDTO> result = new ArrayList<>();

		getConn();

		String sql = "select * from FINAL_SCORE where USER_ID = ? order by score_id desc";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String score_id = rs.getString("SCORE_ID");
				String user_id = rs.getString("USER_ID");
				int f_score = rs.getInt("F_SCORE");
				String game_result = rs.getString("GAME_RESULT");
				result.add(new ScoreDTO(score_id, user_id, f_score, game_result));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public int updateScore(UserDTO dto) {
		getConn();
		String sql = "UPDATE users SET SCORE = ? WHERE USER_ID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getScore()); // 얻은 점수를 설정
			psmt.setString(2, dto.getUser_id()); // 아이디로 해당 유저 찾기

			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

}
