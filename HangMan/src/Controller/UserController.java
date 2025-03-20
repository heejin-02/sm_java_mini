package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.ScoreDTO;
import Model.UserDAO;
import Model.UserDTO;

public class UserController {
	
	// db 연결 쿼리문
	UserDAO dao = new UserDAO();
	
	
	public int Join(String id,String pw , String name){ // 회원가입
		
		
		
		return 0;
	}
	
	public boolean Login(String id , String pw){ // 로그인 
		
		
		
		return true;
	} 	
	
	public int Withdrawal(String id, String pw) { // 회원탈퇴
		
		
		
		return 0;
	}
	

	
	public ArrayList<ScoreDTO> UserInfo(String id){ // 내정보보기
		ArrayList<ScoreDTO> resultList = new ArrayList<>();
		
		resultList = dao.info_list(id);
		
		return resultList;
	}
	


	public List<UserDTO> getTop5User() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
