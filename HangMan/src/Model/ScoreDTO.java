package Model;

public class ScoreDTO {
	private String score_id;
	private String user_id;
	private int f_score;
	
	
	public ScoreDTO() {
		
	}
	
	
	public ScoreDTO(String score_id, String user_id, int f_score) {
		this.score_id = score_id;
		this.user_id = user_id;
		this.f_score = f_score;
	}
	
	public String getScore_id() {
		return score_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public int getF_score() {
		return f_score;
	}
	
	
}
