package Model;

public class UserDTO {

	private String user_id;
	private String user_pw;
	private String user_name;
	private int score;
	
	
	public UserDTO() {

	   }

	   public UserDTO(String id, String pw, String name) {

	      this.user_id = id;
	      this.user_pw = pw;
	      this.user_name = name;

	   }

	   // 회원조회하고 탈퇴를 위한 메소드
	   public UserDTO(String id, String pw) {
	      this.user_id = id;
	      this.user_pw = pw;
	   }

	   public String getUser_id() {
	      return user_id;
	   }

	   public void setUser_id(String user_id) {
	      this.user_id = user_id;
	   }

	   public String getUser_pw() {
	      return user_pw;
	   }

	   public void setUser_pw(String user_pw) {
	      this.user_pw = user_pw;
	   }

	   public String getUser_name() {
	      return user_name;
	   }

	   public void setUser_name(String user_name) {
	      this.user_name = user_name;
	   }

	   public int getScore() {
	      return score;
	   }

	   public void setScore(int score) {
	      this.score = score;
	   }

	
	
	
	
	
	
	
	
	
	
	
}
