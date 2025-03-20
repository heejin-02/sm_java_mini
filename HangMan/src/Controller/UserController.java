package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.UserDAO;
import Model.UserDTO;

public class UserController {
		
	UserDAO dao = new UserDAO();

	int result = 0;
	ArrayList<UserDTO> resultList = new ArrayList<>();
	
	
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
		UserDTO dto = new UserDTO(id,pw);
		dto.setUser_id(id);
		dto.setUser_pw(pw);

		result = dao.delete(dto);
		return result;
	}

	
	public ArrayList<UserDTO> UserInfo(String id , String pw){ // 내정보보기
	
		return null;
	}
	


	public List<UserDTO> getTop5User() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
