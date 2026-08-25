package ex0825.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * client와 1:1채팅을 위한 Server
 */
public class ServerChatExam {
	ServerSocket server;

	public ServerChatExam() {
		try {
			server = new ServerSocket(8001);
			System.out.println("클라이언트 접속 대기중");
			Socket sk = server.accept();
			System.out.println(sk.getInetAddress()+"님과 대화 시작합니다.");
			
			//보내는 스레드 새로 클래스 만들기
			new SendThread(sk, "[Server]").start();
			//받는 스레드
			new Thread(()->{//run 메소드
				
				try {
					//들어온 데이터 받기
					BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
					while (true) {
						String readData = br.readLine();
						if("exit".equals(readData)) break;
						
						System.out.println(readData);
					}
					System.out.println("서버 받는 스레드 종료");
					} catch (IOException e) {
					e.printStackTrace();
					}finally {
						System.exit(0);
					}
			}).start();
			
		} catch (Exception e) {
			e.getStackTrace();
		} 

	}

	public static void main(String[] args) {
		new ServerChatExam();
	}
}
