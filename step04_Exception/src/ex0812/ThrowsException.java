package ex0812;

public class ThrowsException {
	public void aa(int i) throws ArithmeticException{
		System.out.println("aa 시작");
		try {
			this.bb(i);	
		} finally {
			System.out.println("aa 끝");
		}
		
	}
	public void bb(int i) throws ArithmeticException{ //throw를 하는 이유
		System.out.println("bb 시작");
		try {
			int result = 100/i;
			System.out.println("나눈결과 = "+result);
				
//		} catch (ArithmeticException e) {
//			e.printStackTrace();
//		}
		}finally {
			System.out.println("bb 끝");	
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		ThrowsException te = new ThrowsException();
		try {
			te.aa(0);	
		} catch (ArithmeticException e) {
			System.out.println("메인 예외처리");
			e.printStackTrace();
		}
		System.out.println("main 끝");
	}
}
