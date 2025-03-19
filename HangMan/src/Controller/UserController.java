package Controller;

import java.util.ArrayList;

import Model.UserDAO;
import Model.UserDTO;

public class UserController {
	
	// db 연결 쿼리문
	UserDAO dao = new UserDAO();
	// 유저 정보 반환 변수
	ArrayList<UserDTO> resultList = new ArrayList<>();
	
	
	public int Join(String id,String pw , String name){ // 회원가입
		
		
		
		return 0;
	}
	
	public boolean Login(String id , String pw){ // 로그인 
		
		
		
		return true;
	} 	
	
	public int Withdrawal(String id, String pw) { // 회원탈퇴
		
		
		
		return 0;
	}
	

	
	public ArrayList<UserDTO> UserInfo(String id , String pw){ // 내정보보기
		resultList = dao.info_list();
		
		return resultList;
	}
	
	public ArrayList<UserDTO> Rank(){ //명예의 전당
		
	
		
		
		return null;
	}
	
	
}
