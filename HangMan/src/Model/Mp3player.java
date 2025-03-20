package Model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.Buffer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Mp3player {
	
	private String mp3; //음악파일 경로
	private Player player; // jlayer에서 가져온 플레이어 클래스의 객체
	private int position; //위치값
	
	public Mp3player(String mp3) {
		this.mp3 = mp3;
	} //생성자
	
	public void play() {
		
		BufferedInputStream bis  = null;
		
		try {
			bis= new BufferedInputStream(new FileInputStream(mp3));
			
			player = new Player(bis);
			//플레이어 객체가 bis를 통해서 mp3파일을 바이트단위로 읽어와서 플레이
			//음악 재생 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread t = new Thread() {
			
			public void run(){
				
				try {
					// 플레이어 객체를통해 클래스 Play 메소드를 사용
					player.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); //이걸 하면 오류남 
					System.out.println("재생이 안돼?");
					//=> 	BufferedInputStream bis  = null;
					//버퍼 스트림 오류다 
				}
			};
			
		};
		t.setDaemon(true); //이걸 안해주면 3종료를 눌러도 음악이 종료가 안됌 
		
		t.start();
		
	} //play
	
	public void close() {
		if(player !=null) {
			player.close();
		}
	}
	
	

}//class