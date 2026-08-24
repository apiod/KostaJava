package ex0812;

public class ExceptionReturnExam {
	public void aa(int i ) {
		try {
			if(i==0) {
				return;
			}
			System.out.println("i: "+i);
			} finally {
			System.out.println("-- aa 끝");
		}
		
	}
	public static void main(String[] args) {
		System.out.println("-- main 시작");
		ExceptionReturnExam er = new ExceptionReturnExam();
		er.aa(0);
		System.out.println("-- main 끝");
	}
}
