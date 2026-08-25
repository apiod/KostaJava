package ex0825.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
	public ClientExam() {
		try (Socket sk = new Socket("192.168.0.40", 8000)){//서버 접속
			
			//서버에게 데이터를 전송
			PrintWriter pw = new PrintWriter(sk.getOutputStream(),true);
			pw.println("오늘의 점심은 무엇을 먹을까요");
			
			//서버가 보내온 데이터를 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String clientData = br.readLine();
			System.out.println("서버가 보내온 데이터: "+clientData);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientExam();
	}
}
