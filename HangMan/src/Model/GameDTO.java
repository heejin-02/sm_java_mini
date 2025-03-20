package Model;

public class GameDTO {
	
	
	private int que_id;
	private int sub_id;
	private String que_word;
	private int difficult;
	private String script;
	
	
	
	
	
	public GameDTO(int que_id, int sub_id, String que_word, int difficult, String script) {
		
		this.que_id = que_id;
		this.sub_id = sub_id;
		this.que_word = que_word;
		this.difficult = difficult;
		this.script = script;
	}
	
	
	
	
	
	public GameDTO(int que_id, String que_word, String script) {
		super();
		this.que_id = que_id;
		this.que_word = que_word;
		this.script = script;
	}





	public GameDTO() {
		
	}

	





	public GameDTO(int sub_id, int difficult) {
		
		this.sub_id = sub_id;
		this.difficult = difficult;
	}





	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getQue_word() {
		return que_word;
	}
	public void setQue_word(String que_word) {
		this.que_word = que_word;
	}
	public int getDifficult() {
		return difficult;
	}
	public void setDifficult(int difficult) {
		this.difficult = difficult;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	
	
	
	
	
}
