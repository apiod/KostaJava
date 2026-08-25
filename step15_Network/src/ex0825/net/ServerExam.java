package ex0825.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public ServerExam() {
		try (ServerSocket server = new ServerSocket(8000)){
			while(true) {
				System.out.println("클라이언트 접속 대기중");
				Socket sk = server.accept();//클라이언트 접속 대기 -접속되면 수락되어 Socket반환
				//접속된 클라이언트 IP조회
				String ip = sk.getInetAddress().toString();
				System.out.println(ip+"님 접속되었습니다.");
				
				//클라이언트로부터 전송된 데이터 읽기
				BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				String clientData = br.readLine();
				System.out.println("클라이언트가 보내온 내용: "+clientData);
				
				//클라이언트에게 데이터 전송
				PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
				pw.println("Server에 접속했습니다.");
				System.out.println();
			}			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerExam();
	}
}
