package Model;

public class ScoreDTO {
	private String score_id;
	private String user_id;
	private int f_score;
	private String game_result;

	public ScoreDTO() {

	}
	
	// 유저 스코어 조회
	public ScoreDTO(String score_id, String user_id, int f_score, String game_result) {
		this.score_id = score_id;
		this.user_id = user_id;
		this.f_score = f_score;
		this.game_result = game_result;
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
	
	public String getGame_result() {
		return game_result;
	}

}
