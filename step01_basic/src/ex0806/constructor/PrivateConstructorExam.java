package ex0806.constructor;

/**
 * 싱글톤 클래스 작성
 * 1. private 생성자 만든다
 * 2. 객체를 static 멤버필드로 선언
 * 3. 객체를 직접생성해서 반환해주는 메소드 작성
 */
class Test{
	private Test() {}
	//객체생성을 못하니 static선언해서 접근
	static Test instance = new Test();
	public static Test getInstance() {
//		Test instance = new Test();
		return instance;
	}
}

public class PrivateConstructorExam {

	public static void main(String[] args) {
//		new Test();// private 생성자이므로 외부에서 객체생성 못한다.
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		System.out.println("t1: "+t1);
		System.out.println("t2: "+t2);
	}

}
