package Controller;

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
	
	public String[] alphabet(){
		String[] alph = new String[26];
		 for (int i = 0; i < 26; i++) {
	            alph[i] = String.valueOf((char) ('A' + i));
	    }
		
		 return alph;
	}
	
	
	public GameDTO GameQuestion(int level , int sub){
		
		
		
		GameDTO dto = new GameDTO(level,sub);
		GameDAO dao = new GameDAO();
		GameDTO result= dao.getWord(dto);
		
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
