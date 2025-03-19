package Controller;

import java.util.ArrayList;

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
	
	
	
	
	
}
