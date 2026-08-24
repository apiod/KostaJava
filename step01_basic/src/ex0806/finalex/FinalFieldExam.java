package ex0806.finalex;

/**
 * final 필드는 반드시 초기화 필수!
 * 	-> 초기화를 하는방법
 * 		1. 직접 명시적 초기화
 * 		2. 생성자를 안에서 초기화
 * 
 * static final 필드는 상수이다.
 * 	1. 직접 명시적 초기화, 생성자 안에서초기화 못함
 * 	2. static 블럭에서 초기화 가능
 */
public class FinalFieldExam {
	int i;
	final int j; //초기화를 해야한다.
	//static필드에 올라가면서 초기화가 되기 때문에 바로 초기화해야한다.
	static final int k=20;  
//	이것을초기화하는 방법은 static{}에서 작성해야한다.
	public FinalFieldExam () {
		j=50;
	}
	public FinalFieldExam (int j) {
		this.j=j;
//		this.k=j;//불가하다
	}
	
	public static void main(String[] args) {
		FinalFieldExam fe = new FinalFieldExam();
		fe.i=50;
//		fe.j=5; //final필드는 값변경 불가능

	}

}
