package Controller;

import java.util.ArrayList;

import Model.GameDAO;
import Model.GameDTO;
import Model.Mp3player;
import Model.SubjectDTO;

public class GameController {

	
	public String[] hangMan(){
		String[] hangman = {
	            """
	            
	               -----
	               |   |
	                   |
	                   |
	                   |
	                   |
	            =========
	            """,
	            """
	            
	               -----
	               |   |
	               O   |
	                   |
	                   |
	                   |
	            =========
	            """,
	            """
	            
	               -----
	               |   |
	               O   |
	               |   |
	                   |
	                   |
	            =========
	            """,
	            """
	            
	               -----
	               |   |
	               O   |
	              /|   |
	                   |
	                   |
	            =========
	            """,
	            """
	            
	               -----
	               |   |
	               O   |
	              /|\\  |
	                   |
	                   |
	            =========
	            """,
	            """
	            
	               -----
	               |   |
	               O   |
	              /|\\  |
	              /    |
	                   |
	            =========
	            """,
	            """
	            
	               -----
	               |   |
	               O   |
	              /|\\  |
	              / \\  |
	                   |
	            =========
	            """
	         
	        };
		
		
		return hangman;
	}
	
	public ArrayList<String> alphabet(){
		ArrayList<String> alphList = new ArrayList<String>();
		 for (int i = 0; i < 26; i++) {
			 alphList.add(String.valueOf((char) ('A' + i))) ;
	    }
		
		 return alphList;
	}
	
	
	public GameDTO GameQuestion(int level , int sub){
		
		
		
		GameDTO dto = new GameDTO(sub,level);
		GameDAO dao = new GameDAO();
		GameDTO result = dao.getWord(dto);
		
		
		return result;
		
	}
	
	
	public char[] QueList(String word){
		
		char[] wordList = new char[word.length()];
		
		for(int i = 0 ; i<wordList.length;i++){
			wordList[i] = '_';
			
			
		}
		return wordList;
	}
	
	
	public char[] alphAdd(char[] queList , String alph, String word){
		
		char alpha = Character.toLowerCase(alph.charAt(0)); 
		
		for(int i = 0 ; i<word.length();i++){
			
			if(Character.toLowerCase(word.charAt(i)) == alpha){
				queList[i] = alpha;
				
			}
			
		}
		
		
		return queList;
		
	}
	
	public void StartGame() {
		//게임 시작시 배경음악
		Mp3player bgm = new Mp3player("music/music.mp3");
		bgm.play();
		
		System.out.println("게임 시작");
	}
	
	public void welcomeSound() {
		Mp3player welcomeSound = new Mp3player("music/join.mp3");
		welcomeSound.play();
	}
	
	 public void playCorrectSound() {
	    // 정답 맞췄을 때 효과음
	        Mp3player correctSound = new Mp3player("music/correct.mp3");
	        correctSound.play();
	}
	    
	public void playWrongSound() {
	  // 오답일 때 효과음
	  Mp3player wrongSound = new Mp3player("music/wrong.mp3");
	        wrongSound.play();
	}
	
	public void playTypingSound() {
		Mp3player typingSound = new Mp3player("music/typing.mp3");
			typingSound.play();
	}
	
	public void playSuccessSound() {
		Mp3player successSound = new Mp3player("music/success.mp3");
			successSound.play();
	}
	public void playdieSound() {
		//게임 오버 효과음
		Mp3player dieSound = new Mp3player("music/die.mp3");
			dieSound.play();
	}

	
	//노래 멈추기
	public void stop() {
		Mp3player bgm = new Mp3player("music/music.mp3");
		bgm.stop();
	}
	
}
