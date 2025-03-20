package Controller;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Model.GameDAO;
import Model.GameDTO;
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
		}else {
			 result  = dao.quefail(id);
		}
		
		
		
		
		return result;
		
	}
	

	
	
}
