package ex0824;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadExam extends JFrame {// 창역할 - Container

	JTextField text1 = new JTextField(5);
	JTextField text2 = new JTextField(5);
	JButton button1 = new JButton("버튼");

	public GUIThreadExam() {
		super("시계");

		// 창 크기 설정
		super.setSize(500, 400);
		// 중앙에 놓기
		super.setLocationRelativeTo(null);

		// JFrame의 레이아웃(배치도)변경
		super.setLayout(new FlowLayout());

		// Container
		Container con = super.getContentPane();
		// component를 JFrame위에 올리기
		con.add(button1);
		con.add(text1);
		con.add(text2);
		
		
		// 창보이기
		super.setVisible(true);
		// x버튼을 누르면 프로그램 종료
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 스레드 시작
		new NowTimeThread().start();
		
		//1~1000까지
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				
//			}
//		}).start();
		
		//람다
		new Thread(()->{
			for(int i=1;i<1000;i++) {
				text1.setText(i+"");
				try {
					Thread.sleep((int)(Math.random()*100));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		button1.addActionListener((e)->{
			new Thread(()->{
				for(char ch = 'a';ch<='z';ch++) {
					text2.setText(ch+" ");
					try {
						Thread.sleep((int)(Math.random()*100));
					} catch (InterruptedException ex) {
						ex.getStackTrace();
					}
				}
				
				
			}
					).start(); 
		});
	}	

	public static void main(String[] args) {
		new GUIThreadExam();
	}

	/**
	 * 현재 시간을 구해서 JFrame Title에 1초마다 시간 갱신하는 스레드
	 */
	class NowTimeThread extends Thread {

		@Override
		public void run() {
			while(true) {
				// 현재 시간 구한다.
				Calendar cal = Calendar.getInstance();// 년 월 일 시:분:초
	
				int y = cal.get(Calendar.YEAR);
				int M = cal.get(Calendar.MONTH) + 1;// 0~11까지 나온다 따라서 +1을 해준다
				int d = cal.get(Calendar.DATE);
				int h = cal.get(Calendar.HOUR);
				int m = cal.get(Calendar.MINUTE);
				int s = cal.get(Calendar.SECOND);
				StringBuilder sb = new StringBuilder();
				sb.append(y);
				sb.append("년 ");
				sb.append(M);
				sb.append("월 ");
				sb.append(d);
				sb.append("일 ");
				sb.append(h);
				sb.append("시");
				sb.append(m);
				sb.append("분");
				sb.append(s);
				//outerClass.this //Jframe호출
				GUIThreadExam.this.setTitle(sb.toString());
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
