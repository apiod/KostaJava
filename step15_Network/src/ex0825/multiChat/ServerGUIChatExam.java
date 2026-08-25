package ex0825.multiChat;

import java.awt.PrintJob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerGUIChatExam {
	List<ClientSkThread> list = new ArrayList<>();
	Socket sk;

	public ServerGUIChatExam() {
		try (ServerSocket server = new ServerSocket(8000)) {
			while (true) {
				System.out.println("Client 접속 대기중");
				sk = server.accept();
				// 클라이언트 스레드 시작
				ClientSkThread th = new ClientSkThread();
				th.start();
				
				// 리스트에 추가
				list.add(th);
				System.out.println("--- " + sk.getInetAddress() + "님 접속 ---");
				System.out.println("현재 접속 인원:" + list.size() + "명\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 모든 client에게 데이터 전송하는 메소드
	 */
	public void SendMessage(String message) {
		for (ClientSkThread th : list) {
			th.pw.println(message);
		}

	}

	/**
	 * client의 이름이 중복인지 판단하는 메소드
	 * 
	 * @return 중복이면 1 중복이 아니면 2
	 */
	public int checkName(String name) {
			for (ClientSkThread cst : list) {
				if (name.equals(cst.name)) {
					return 1;
				}
			}
		return 2;
	}

	/**
	 * 접속한 클라이언트의 sk를 Thread로 만들어서 관리
	 */
	class ClientSkThread extends Thread {
		PrintWriter pw;
		BufferedReader br;
		String name;

		public ClientSkThread() {

			try {
				pw = new PrintWriter(sk.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 클라이언트가 보내오는 내용을 읽어서 접속한 모든 클라이언트에 전송
			try {
//				name = br.readLine();
				while (true) {
					int state=0;
					String str = br.readLine();
					
					state = checkName(str);
					System.out.println(state);
					pw.println(state);
					if (state==2) {//중복이 아닐때 
						name=str;
						break;
					}
				}
				SendMessage("[" + name + "]님 입장하셧습니다. ");
				while (true) {
					String inputData = br.readLine();
					if(inputData==null)break;
					SendMessage("[" + name + "]: " + inputData);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 스레드가 종료가 되었다. -> 클라이언트가나갔다.
				list.remove(this);

				// 남은 클라이언트에게 메시지 전송
				SendMessage("[" + name + "]님 퇴장하셨습니다.");
				System.out.println("[" + name + "] 퇴장");
				System.out.println("현재인원: " + list.size());
			}
		}
	}

	
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}
}
