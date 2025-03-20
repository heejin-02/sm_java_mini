package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.ScoreDTO;
import Model.UserDAO;
import Model.UserDTO;

public class UserController {
	
	// db 연결 쿼리문
	UserDAO dao = new UserDAO();
	int result = 0;
	
	
	public int Join(String id, String pw, String name) { // 회원가입
	      UserDTO dto = new UserDTO(id, pw, name);
	      result = dao.join(dto);

	      return result;
	   }

	   public boolean Login(String id , String pw){ // 로그인 
	      UserDTO dto = new UserDTO(id,pw);
	      return dao.Login(dto);
	   }    
	   

	   public int Withdrawal(String id, String pw) { // 회원탈퇴
	      UserDTO dto = new UserDTO();
	      dto.setUser_id(id);
	      dto.setUser_pw(pw);

	      result = dao.delete(dto);
	      return result;
	   }
	

	
	public ArrayList<ScoreDTO> UserInfo(String id){ // 내정보보기
		ArrayList<ScoreDTO> resultList = new ArrayList<>();
		
		resultList = dao.info_list(id);
		
		return resultList;
	}
	


	   public List<UserDTO> getTop5User() {
		      return dao.getTop5Users(); // 최신 점수 반영된 상위 5명 가져오기
		   } 
	
	
}
