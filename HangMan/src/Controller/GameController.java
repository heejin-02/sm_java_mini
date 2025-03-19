package Controller;

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
	
	
	
}
