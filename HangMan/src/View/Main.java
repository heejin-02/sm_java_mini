package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import Controller.UserController;
import Model.UserDTO;
import Controller.GameController;
import Model.GameDTO;
import Model.Mp3player;
import Model.ScoreDTO;
import Model.UserDAO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserController con = new UserController();
		GameController GameCon = new GameController();
		UserDAO userDAO = new UserDAO();
		List<UserDTO> top5Users = userDAO.getTop5Users();
		Timer timer = new Timer();
		ScoreDTO scoreDTO = new ScoreDTO();
		UserDTO userDTO = new UserDTO();

		int input;

		System.out.println();
		GameCon.welcomeSound();
		System.out.println(
				" ___  ___  ________  ________   ________          ________  _______   ___      ___ _______   ___       ________  ________  _______   ________      \n"
						+ "|\\  \\|\\  \\|\\   __  \\|\\   ___  \\|\\   ____\\        |\\   ___ \\|\\  ___ \\ |\\  \\    /  /|\\  ___ \\ |\\  \\     |\\   __  \\|\\   __  \\|\\  ___ \\ |\\   __  \\    \n"
						+ "\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\  \\___|        \\ \\  \\_|\\ \\ \\   __/|\\ \\  \\  /  / | \\   __/|\\ \\  \\    \\ \\  \\|\\  \\ \\  \\|\\  \\ \\   __/|\\ \\  \\|\\  \\   \n"
						+ " \\ \\   __  \\ \\   __  \\ \\  \\\\ \\  \\ \\  \\  ___       \\ \\  \\ \\\\ \\ \\  \\_|/_\\ \\  \\/  / / \\ \\  \\_|/_\\ \\  \\    \\ \\  \\\\\\  \\ \\   ____\\ \\  \\_|/_\\ \\   _  _\\  \n"
						+ "  \\ \\  \\ \\  \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\|\\  \\       \\ \\  \\_\\\\ \\ \\  \\_|\\ \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\_|\\ \\ \\  \\\\  \\| \n"
						+ "   \\ \\__\\ \\__\\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\_______\\       \\ \\_______\\ \\_______\\ \\__/ /     \\ \\_______\\ \\_______\\ \\_______\\ \\__\\    \\ \\_______\\ \\__\\\\ _\\ \n"
						+ "    \\|__|\\|__|\\|__|\\|__|\\|__| \\|__|\\|_______|        \\|_______|\\|_______|\\|__|/       \\|_______|\\|_______|\\|_______|\\|__|     \\|_______|\\|__|\\|__|\n");

		System.out.println();
		System.out.println("[1] 로그인\t[2] 회원가입");
		System.out.println("");
		System.out.print("선택 >> ");
		input = sc.nextInt();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

		if (input == 1) {

			while (true) {
				// 로그인
				System.out.println("=============== 로 그 인 ===============");
				System.out.println("");
				System.out.print("아이디를 입력하세요. >> ");
				String id = sc.next();
				System.out.print("비밀번호를 입력하세요. >> ");
				String pw = sc.next();

				// 로그인 여부 확인
				boolean log = con.Login(id, pw);

				if (log) {
					GameCon.StartGame();

					while (true) {
						System.out.println("================================= 메 뉴 =================================");
						System.out.println("");
						System.out.println("[1] 게임 플레이\t[2] 게임 방법\t[3] 내 기록 보기\t[4] 명예의 전당\t[5] 회원 탈퇴\t[6] 종료");
						System.out.println("");
						System.out.print("선택 >> ");
						input = sc.nextInt();
						System.out.println("");
						System.out.println("");
						System.out.println("");

						if (input == 1) {
							// 주제 설정
							System.out.println("================ 주 제  설 정 ================");
							System.out.println("");
							System.out.println("[1] 자바    [2] 파이썬   [3] C언어   [4] SQL");
							System.out.println("");
							System.out.print("선택 >> ");
							int sub = sc.nextInt();
							System.out.println("");
							System.out.println("");
							System.out.println("");

							// 난이도 설정
							System.out.println("========= 난 이 도  설 정 =========");
							System.out.println("");
							System.out.println("[1] 쉬움    [2] 중간    [3] 어려움");
							System.out.println("");
							System.out.print("선택 >> ");
							int level = sc.nextInt();
							System.out.println("");
							System.out.println("");

							// 문제 가져오기
							GameDTO dto = GameCon.GameQuestion(level, sub);

							// 행맨 아스키아트 리스트
							String[] hangMan = GameCon.hangMan();
							// 알파벳 리스트
							ArrayList<Character> alphList = GameCon.alphabet();

							// 문제문장 리스트
							char[] queList = GameCon.QueList(dto.getQue_word());

							// 게임 진행
							for (int i = 0; i <= hangMan.length; i++) {
								// 행맨 출력
								System.out.println(hangMan[i]);

								// 알파벳 출력
								for (Character al : alphList) {
									System.out.print(al + " ");
								}
								System.out.println("");
								System.out.print("\n알파벳을 골라주세요! >> ");

								char sel = sc.next().charAt(0);
								System.out.println("");
								System.out.println("===================================================");
								GameCon.playTypingSound();

								// 알파벳 포함 여부 체크
								if (dto.getQue_word().toLowerCase().contains(String.valueOf(sel))) { // 대소문자 구별 X
									GameCon.playCorrectSound();
									// 문제문장 리스트에 알파벳 추가
									queList = GameCon.alphAdd(queList, sel, dto.getQue_word());
									i--; // 틀리지 않았으므로 기회 유지
								} else {
									GameCon.playWrongSound();
								}

								// 문제문장 출력
								System.out.println("\n");
								for (char que : queList) {
									System.out.print(que + " ");
								}
								System.out.println("\n");

								// 사용된 알파벳 제거
								alphList.removeIf(c -> Character.toLowerCase(c) == Character.toLowerCase(sel));

								// 정답 맞췄을 때
								
								if (new String(queList).equals(dto.getQue_word())) {
									boolean win = true;
									int score = GameCon.scoreCal(win, id); // 점수 계산 메소드
									System.out.print("설명 : ");
									System.out.println(dto.getScript() + "\n");
									System.out.println("\u001B[32mpublic void gameSuccess() {\r\n"
						                    + "     System.out.println(\"당신은 개발자를 구했습니다!\");\r\n"
						                    + "}\u001B[0m");

									GameCon.playSuccessSound();
									GameCon.stop();
									if (score > 0)
										System.out.println("\u001B[33m + 20점\u001B[0m");
									System.out.println("한판 더?");
									System.out.print("[1] 네 [2] 아니오 >>");
									int conti = sc.nextInt();
									if (conti == 1) {
										i = -1;
										// 단어 알파벳리스트 문제리스트 초기화
										dto = GameCon.GameQuestion(level, sub);
										queList = GameCon.QueList(dto.getQue_word());
										alphList = GameCon.alphabet();
									} else if (conti == 2) {
										break;
									} else {
										System.out.println("잘못된 입력값입니다");
									}

								}

								// 행맨이 끝났을 때
								if (i == hangMan.length - 1) {
									GameCon.stop();
									GameCon.playdieSound();
									System.out.println("\u001B[31mpublic void gameOver() {\r\n"
										
											+ "     System.out.println(\"개발자를 구하지 못했습니다.\");\r\n"
											+ "}\u001B[0m" + "\n정답은: " + dto.getQue_word());
									System.out.println("한판 더?");
									System.out.print("[1] 네 [2] 아니오 >>");
									int conti = sc.nextInt();
									if (conti == 1) {
										i = -1;
										// 단어 알파벳리스트 문제리스트 초기화
										dto = GameCon.GameQuestion(level, sub);
										queList = GameCon.QueList(dto.getQue_word());
										alphList = GameCon.alphabet();
									} else if (conti == 2) {
										break;
									} else {
										System.out.println("잘못된 입력값입니다");
									}

								}
							}

						} else if (input ==2) {
							System.out.println("============= 게 임 방 법 =============");
							System.out.println("💡 게임 방법\r\n"
									+ "1️ 주어진 단어의 글자를 하나씩 추측해보세요!\r\n"
									+ "2️ 키워드는 Python, Java, SQL, C 언어에서 출제됩니다.\r\n"
									+ "3️ 정답을 맞히면 해당 개념에 대한 설명이 제공됩니다.\r\n"
									+ "4️ 정답을 맞히면 점수가 올라가고, 틀리면 점수가 감소합니다.\r\n"
									+ "5️ 랭킹 시스템을 통해 최고의 프로그래머에 도전하세요!\r\n"
									+ "\r\n"
									+ "🔥 실력을 키우고, 프로그래밍 지식을 쌓아보세요!\r\n\n"
									+ "🚀 준비됐나요? 그럼 게임을 시작해볼까요?");
						}
						
						
						
						
						
						
						
						else if (input == 3) {
							// 내정보 보기
							System.out.println("============= 내  기 록  보 기 =============");
							System.out.println("");
							ArrayList<ScoreDTO> f_score = con.UserInfo(id);
							if (f_score != null) {
								for (ScoreDTO score : f_score) {
									System.out.println("최종 점수: " + score.getF_score() + "   "
											+ (score.getGame_result().equals("y") ? "플레이 결과: 성공" : "플레이 결과: 실패"));
									System.out.println("");
								}
							} else {

								System.out.println("현재 플레이 기록이 존재하지 않습니다.");
							}

							System.out.println("");
							System.out.println("");
							System.out.println("");

						} else if (input == 4) {
							// 명예의 전당
							System.out.println("=============== T O P 5  ================");
							System.out.println("");
							List<UserDTO> top5User = con.getTop5User(); // 수정된 부분
							for (UserDTO user : top5User) {
								System.out.println("아이디: " + user.getUser_id() + ", 이름: " + user.getUser_name()
										+ ", 점수: " + user.getScore());
							}

						} else if (input == 5) {
							// 회원 탈퇴
							System.out.println("============= 회 원 탈 퇴 =============");
							System.out.print("아이디를 입력해주세요. >> ");
							String user_id = sc.next();
							System.out.print("비밀번호를 입력해주세요. >> ");
							String user_pw = sc.next();

							int result = con.Withdrawal(user_id, user_pw);
							if (result > 0) {
								System.out.println("회원탈퇴 완료되었습니다.");
								break; // 회원 탈퇴 후 종료
							} else {
								System.out.println("회원탈퇴 실패. 다시 시도해주세요.");
							}

						} else if (input == 6) {
							// 종료
							GameCon.stop();
							System.out.println("행맨이 종료되었습니다.");
							
							break;
						} else {
							System.out.println("올바른 입력이 아닙니다. 다시 선택해주세요.");
						}
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					
					GameCon.stop();
					}break;
				}
			}

		} else if (input == 2) {
			// 회원가입
			System.out.println("=== 회 원 가 입 ===");
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();
			System.out.print("이름 : ");
			String name = sc.next();

			int result = con.Join(id, pw, name);
			if (result > 0) {
				System.out.println("회원가입이 완료되었습니다!");
			} else {
				System.out.println("회원가입 실패. 다시 시도해주세요.");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}

		sc.close(); // 스캐너 닫기
	}
	
}
