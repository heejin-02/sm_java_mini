package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.UserController;
import Model.GameDTO;
import Controller.GameController;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserController con = new UserController();

		GameController GameCon = new GameController();

		int input = 0;

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

				while (true) {

					System.out.println("===========반복문============");
					System.out.println("[1] 게임플레이 [2] 내정보보기 [3] 명예의전당 [4] 회원탈퇴 [5] 종료");
					System.out.print(">>");
					input = sc.nextInt();
					if (input == 1) {

						// 주제 설정
						System.out.println("=======주제 설정=======");
						System.out.println("[1] 자바 [2] 파이썬 [3] C언어 [4] SQL");
						System.out.print(">>");
						int sub = sc.nextInt();
						// 난이도 설정
						System.out.println("=======난이도 설정=======");
						System.out.println("[1] 쉬움 [2] 중간 [3] 어려움");
						System.out.print(">>");
						int level = sc.nextInt();

						// jdbc로 문제 불러오기
						GameDTO dto = GameCon.GameQuestion(level, sub);

						// 행맨 아스키아트 리스트
						String[] hangMan = GameCon.hangMan();
						// 알파벳 리스트
						ArrayList<String> alphList = GameCon.alphabet();
						// 문제문장 리스트
						char[] queList = GameCon.QueList(dto.getQue_word());

						// 문제 반복문
						for (int i = 0; i < hangMan.length; i++) {
							// 행맨 출력
							System.out.println(hangMan[i]);
							// 알파벳 출력
							for (String al : alphList) {
								System.out.print(al + " ");
							}

							System.out.print(">>");
							String sel = sc.next();
							// 알파벳 입력 받기(대소문자 변환)
							sel = sel.toUpperCase();

							// 알파벳이 포함될시 작업
							if (dto.getQue_word().toUpperCase().contains(sel)) {
								// 문제문장 리스트에 알파벳 추가 메소드
								queList = GameCon.alphAdd(queList, sel, dto.getQue_word());
								i--;

							}
							// 개행
							System.out.println("\n");
							// 문제문장 출력
							for (char que : queList) {

								System.out.print(que + " ");

							}
							System.out.println("\n");

							// 사용된 알파벳 제거
							alphList.remove(String.valueOf(sel));

							// 정답 맞출시 반복문 종료
							if (new String(queList).equals(dto.getQue_word())) {

								System.out.println("게임종료");
								break;
							}

						}

					} else if (input == 2) {
						// 내정보 보기

					} else if (input == 3) {
						// 명예의 전당

					} else if (input == 4) {
						// 회원 탈퇴

					} else {
						// 종료
						System.out.println("행맨이 종료되었습니다");
						break;
					}

				}
			}

		} else if (input == 2) {
			// 회원가입

		}

	}

}
