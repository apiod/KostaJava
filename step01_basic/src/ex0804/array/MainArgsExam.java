package ex0804.array;

public class MainArgsExam {
	public static void main(String[] args) {
		MainArgsExam m = new MainArgsExam();
		
		System.out.println(args);
		System.out.println(args.length);
		System.out.println("for문 호출");
		for(int i =0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		System.out.println("개선된 for문 호출");
		for(String s:args) {//자료형 변수:반복대상
			System.out.println(s);
		}
		
	}
	

}
