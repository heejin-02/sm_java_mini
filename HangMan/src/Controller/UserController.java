package Controller;

import java.util.ArrayList;

import Model.UserDAO;
import Model.UserDTO;

public class UserController {
	UserDAO dao = new UserDAO();
	
	public int Join(String id,String pw , String name){ // 회원가입
		
		return 0;
	}
	
	public boolean Login(String id , String pw){ // 로그인 
		UserDTO dto = new UserDTO(id,pw);
		return dao.Login(dto);
	} 	
	
	public int Withdrawal(String id, String pw) { // 회원탈퇴
		
		
		
		return 0;
	}
	

	
	public ArrayList<UserDTO> UserInfo(String id , String pw){ // 내정보보기
	
		
		
		return null;
	}
	
	public ArrayList<UserDTO> Rank(){ //명예의 전당
		
	
		
		
		return null;
	}
	
	
}
