package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.UserController;
import Model.UserDTO;
import Controller.GameController;
import Model.GameDTO;
import Model.ScoreDTO;
import Model.UserDAO;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserController con = new UserController();
        GameController GameCon = new GameController();
        UserDAO userDAO = new UserDAO();
        List<UserDTO> top5Users = userDAO.getTop5Users();
        ScoreDTO scoreDTO = new ScoreDTO();

        int input;

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
            System.out.print("아이디를 입력하세요 > ");
            String id = sc.next();
            System.out.print("비밀번호를 입력하세요 > ");
            String pw = sc.next();

            // 로그인 여부 확인
            boolean log = con.Login(id, pw);

            if (log) {
                while (true) {
                    System.out.println("===========메뉴============");
                    System.out.println("[1] 게임플레이 [2] 내정보보기 [3] 명예의전당 [4] 회원탈퇴 [5] 종료");
                    System.out.print(">> ");
                    input = sc.nextInt();

                    if (input == 1) {
                        // 주제 설정
                        System.out.println("======= 주제 설정 =======");
                        System.out.println("[1] 자바 [2] 파이썬 [3] C언어 [4] SQL");
                        System.out.print(">> ");
                        int sub = sc.nextInt();

                        // 난이도 설정
                        System.out.println("======= 난이도 설정 =======");
                        System.out.println("[1] 쉬움 [2] 중간 [3] 어려움");
                        System.out.print(">> ");
                        int level = sc.nextInt();

                        // 문제 가져오기
                        GameDTO dto = GameCon.GameQuestion(level, sub);

                        // 행맨 아스키아트 리스트
                        String[] hangMan = GameCon.hangMan();
                        // 알파벳 리스트
                        ArrayList<String> alphList = GameCon.alphabet();
                        // 문제문장 리스트
                        char[] queList = GameCon.QueList(dto.getQue_word());

                        // 게임 진행
                        for (int i = 0; i < hangMan.length; i++) {
                            // 행맨 출력
                            System.out.println(hangMan[i]);

                            // 알파벳 출력
                            for (String al : alphList) {
                                System.out.print(al + " ");
                            }
                            System.out.print("\n>> ");
                            String sel = sc.next().toUpperCase();

                            // 알파벳 포함 여부 체크
                            if (dto.getQue_word().toUpperCase().contains(sel)) {
                                // 문제문장 리스트에 알파벳 추가
                                queList = GameCon.alphAdd(queList, sel, dto.getQue_word());
                                i--; // 틀리지 않았으므로 기회 유지
                            }

                            // 문제문장 출력
                            System.out.println("\n");
                            for (char que : queList) {
                                System.out.print(que + " ");
                            }
                            System.out.println("\n");

                            // 사용된 알파벳 제거
                            alphList.remove(sel);

                            // 정답 맞췄을 때
                            if (new String(queList).equals(dto.getQue_word())) {
                                System.out.println("게임 종료! 정답을 맞췄습니다.");
                                break;
                            }

                            // 행맨이 끝났을 때
                            if (i == hangMan.length - 1) {
                                System.out.println("게임 실패! 정답은: " + dto.getQue_word());
                            }
                        }

                    } else if (input == 2) {
                        // 내정보 보기
                        System.out.println("======== 내 기록 보기 ========");
                        ArrayList<ScoreDTO> f_score = con.UserInfo(id);
                        if (f_score != null) {
                            System.out.println("플레이 넘버: " + scoreDTO.getScore_id());
                            System.out.println("아이디: " + scoreDTO.getUser_id());
                            System.out.println("점수: " + scoreDTO.getF_score());
                        } else {
                            System.out.println("현재 플레이 기록이 존재하지 않습니다.");
                        }

                    } else if (input == 3) {
                        // 명예의 전당
//                        System.out.println("=== 점수 상위 5명 ===");
//                        List<UserDTO> top5Users = con.getTop5Users(); // 수정된 부분
//                        for (UserDTO user : top5Users) {
//                            System.out.println("아이디: " + user.getUser_id() + ", 이름: " + user.getUser_name() + ", 점수: " + user.getScore());
//                        }

                    } else if (input == 4) {
                        // 회원 탈퇴
                        System.out.println("=== 회 원 탈 퇴 ===");
                        System.out.print("ID : ");
                        String user_id = sc.next();
                        System.out.print("PW : ");
                        String user_pw = sc.next();

                        int result = con.Withdrawal(user_id, user_pw);
                        if (result > 0) {
                            System.out.println("회원탈퇴 완료되었습니다.");
                            break; // 회원 탈퇴 후 종료
                        } else {
                            System.out.println("회원탈퇴 실패. 다시 시도해주세요.");
                        }

                    } else if (input == 5) {
                        // 종료
                        System.out.println("행맨이 종료되었습니다.");
                        break;
                    } else {
                        System.out.println("올바른 입력이 아닙니다. 다시 선택해주세요.");
                    }
                }
            } else {
                System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
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
