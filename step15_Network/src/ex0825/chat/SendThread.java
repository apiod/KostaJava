package ex0825.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대측(client or server)에게 데이터 전송하는 스레드
 */
public class SendThread extends Thread {
	private Socket sk;
	private String name;

	public SendThread(Socket sk, String name) {
		this.sk = sk;
		this.name = name;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			
			while (true) {
				String str = sc.nextLine();
				if(str.equals("exit")) {//exit가 탈출
					pw.println(str);//str값은 exit
					break;
				}
				pw.println(name+": "+str);
				
			}
			System.out.println(name+"의 보내는 스레드 종료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("--모든 프로그램 종료--");
			System.exit(0);
		}
	}
}
