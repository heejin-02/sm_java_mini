package Controller;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Model.GameDAO;
import Model.GameDTO;
import Model.Mp3player;
import Model.SubjectDTO;

public class GameController {
	private Mp3player bgmstop;
	
	public String[] hangMan(){
		String[] hangman = {
	            """
	           
                ====================================
                |            HELP  ME !!!           |
                | THERE ARE STILL BUG LEFT TO FIX.. |
                ====================================
                 ________
	               --------------------
	               |                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	            ===========================
	            """,
	            """
	              --------------------
	               |                  |
	               |                  |
	              😵                  |  
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	            ===========================
	             
	            
	            """,
	            """
	            
	              ---------------------
	               |                  |
	               |                  |
	              😵                  |  
	             /||                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	            ===========================
	            """,
	            """
	              ---------------------
	               |                  |
	               |                  |
	              😵                  |  
	             /||\\                 |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	            ===========================
	         
	            """,
	            """
	            
	              ---------------------
	               |                  |
	               |                  |
	              😵                  |  
	             /||\\                 |
	             /                    |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	            ===========================
	            """,
	            """
	                      
	              ---------------------
	               |                  |
	               |                  |
	              😵                  |  
	             /||\\                 |
	             /  \\                 |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	            ===========================
	   
	            """,
	            """
                ---------------------
	               |                  |
	               |                  |
	              😵                  |  
	             /||\\                 |
	             /  \\                 |
	                                  |
	                                  |
	                                  |
	                                  |
	                                  |
	                       🖥🖱️       |
	            ===========================
	            """
	         
	        };
		
		
		return hangman;
	}
	
	public ArrayList<Character> alphabet(){
		ArrayList<Character> alphList = new ArrayList<Character>();
		 for (int i = 0; i < 26; i++) {
			 alphList.add(	(char)('A'+i)) ;
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
	
	
	public char[] alphAdd(char[] queList, char alph, String word) {
	    char alphaLower = Character.toLowerCase(alph); // 입력된 문자 소문자로 변환

	    for (int i = 0; i < word.length(); i++) {
	        char originalChar = word.charAt(i);
	        if (Character.toLowerCase(originalChar) == alphaLower) { // 대소문자 구분 없이 비교
	            queList[i] = originalChar; // 원래 대소문자 유지
	        }
	    }

	    return queList;
	}
	
	public int scoreCal(boolean winOrFail, String id){
	      GameDAO dao = new GameDAO();
	      int result = 0;
	      if(winOrFail) {
	          result  = dao.quewin(id);
	          dao.scoreSave(id ,"y");
	      }else {
	          result  = dao.quefail(id);
	          dao.scoreSave(id, "n");
	      }
	      return result;
	      
	   }
	
	public void StartGame() {
		//게임 시작시 배경음악
		Mp3player bgm = new Mp3player("music/music.mp3");
		bgm.play();
		
		System.out.println();
		System.out.println("   _____                         _____ _             _   \n"
				+ "  / ____|                       / ____| |           | |  \n"
				+ " | |  __  __ _ _ __ ___   ___  | (___ | |_ __ _ _ __| |_ \n"
				+ " | | |_ |/ _` | '_ ` _ \\ / _ \\  \\___ \\| __/ _` | '__| __|\n"
				+ " | |__| | (_| | | | | | |  __/  ____) | || (_| | |  | |_ \n"
				+ "  \\_____|\\__,_|_| |_| |_|\\___| |_____/ \\__\\__,_|_|   \\__|\n");
		System.out.println();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	        if (bgmstop != null) {
	            bgmstop.stop();
	        }
	 }
	
}
