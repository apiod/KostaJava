package ex0824;

import java.util.Random;

public class ThreadExam {
	public static void main(String[] args) {
		System.out.println("---- 메인 시작 ----");

		NumberThread th1 = new NumberThread("첫 번째 Thread");
		NumberThread th2 = new NumberThread("두 번째 Thread");

		AlphaThread al1 = new AlphaThread();
//		Thread th3 = new Thread(al1);
		Thread th3 = new Thread(al1, "세번째 Thread");
		
//		run을 직접 호출하면 싱글 메인 스레드로 동작
//		th1.run();
//		th2.run();
//		th3.run();
		
//		각 thread의 start를 호출해서 실행 준비 상태로 만든다.
//		실행 준비상태에 있는스레드중에 가장우선순위가 높은
//		스레드가running 상태가 되어 일을 한다. -서로 번갈아가면서..
		th1.start();
		th2.start();
		th3.start();
		
//		try {
//			th1.join();//th1스레드가 마무리 할때까지현재 스레드(메인정지상태)	
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("총합 = "+th1.sum);
		
		System.out.println("---- 메인 종료 ----");
	}
}
/**
 * 1~100까지 출력하는 스레드 
 */
class NumberThread extends Thread{
	public NumberThread(String message) {
		super(message);
	}
	/**
	 * Thread로 작업할 기능 작성 - run()메소드 재정의 
	 */
	int sum = 0;
	@Override
	public void run() {
		Random random = new Random();
		for(int i=1;i<=100;i++) {
			System.out.println(super.getName() + " -> "+i);
			sum+=i;
			
//			try {
////				int no = random.nextInt(100);//0~99
//				Thread.sleep(10);
////				Thread.sleep(no);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Thread.yield();
		}
		System.out.println(super.getName()+" End ----");
	}
}

/**
 * A~Z까지 출력하는 스레드
 */
class AlphaThread implements Runnable{
	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for(char ch = 'A';ch<='Z';ch++) {
			System.out.println(th.getName()+" -> "+ch);
			Thread.yield();
		}
		System.out.println(th.getName()+" End");
		
	}
}