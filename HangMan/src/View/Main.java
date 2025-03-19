package View;

import java.util.Scanner;

import Controller.UserController;
import Controller.GameController;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserController con = new UserController();
		
		GameController GameCon = new GameController();
		
		int input = 0;
	
		//adsgkjadslgjlsgjldsngladskng
		System.out.println(" _                                              \n"
				+ "| |                                             \n"
				+ "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n"
				+ "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n"
				+ "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n"
				+ "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n"
				+ "                    __/ |                      \n"
				+ "                   |___/                       ");

		System.out.println();

		System.out.print("[1] 로그인 [2] 회원가입 >> ");
		input = sc.nextInt();

		if (input == 1) {
			// 로그인
			System.out.print("아이디를 입력하세요 >");
			String id = sc.next();
			System.out.print("비밀번호를 입력하세요 >");
			String pw = sc.next();
			
			// 로그인 여부
			boolean log = con.Login(id, pw);

			if (log) {
				
				while(true) {
					
					
				System.out.println("===========반복문============");
				System.out.println("[1] 게임플레이 [2] 내정보보기 [3] 명예의전당 [4] 회원탈퇴 [5] 종료");
				System.out.print(">>");
				input = sc.nextInt();
				if(input == 1){
					
					
					// 게임플레이(핵심 기능)
					
					System.out.println("=======난이도 설정=======");
					System.out.println("[1] 쉬움 [2] 중간 [3] 어려움");
					System.out.print(">>");
					input = sc.nextInt();
					
					
					
					String[] hangMan = GameCon.hangMan();
					for(String h : hangMan){
						
						System.out.println(h);
						 for (String al : GameCon.alphabet()) {
					            System.out.print(al + " ");
					        }
						 
						System.out.print(">>");
						String sel = sc.next();
						System.out.println();
						System.out.println("S  T  R  I  N  G");
						System.out.println("_  _  _  _  _  _");
					}
					
					
					
					
				}else if(input == 2){
					// 내정보 보기 
					
					
				}else if(input == 3){
					// 명예의 전당
					
				}else if(input == 4){
					// 회원 탈퇴 
					
				}else {
					// 종료
					System.out.println("행맨이 종료되었습니다");
					break;
				}
				
				
				
				
				}
			}

		} else if(input == 2) {
			// 회원가입

		}

	}

}
