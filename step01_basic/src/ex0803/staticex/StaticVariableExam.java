package ex0803.staticex;

class Test{
	int a;
	static int b;
	
	public void aa() {
		System.out.println(a);//0
		System.out.println(this.a);//0
		
		System.out.println(b);//0
		System.out.println(this.b);//0
		System.out.println(Test.b);//this보단 클래스명.변수명으로 쓸것
		
		//메소드 호출
		bb();
		this.bb();
		
		dd();
		this.dd();
		Test.dd();
	}
	public void bb() {
		
	}
	//static 메소드 안에서는 static만 접근가능, this사용 불가
	public static void cc() {
//		System.out.println(a);//static메소드내에서non-static사용불가
//		System.out.println(this.a);//this 사용불가
		
		System.out.println(b);//0
//		System.out.println(this.b);//0 사용불가
		System.out.println(Test.b);
	}
	public static void dd() {
//		bb(); //static 내에서 non-static불가
//		this.bb(); //static내에서 this불가
		
		dd();
//		this.dd();//static내에서 this불가
		Test.dd();
	}
}
public class StaticVariableExam {

	String s;
	public void bb() {}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		System.out.println("t1 = "+t1);
		System.out.println("t1 = "+t2);
		System.out.println("t1 = "+t3);
		
		System.out.println("** non-static변수 **");
		System.out.println("t1.a = "+t1.a);
		System.out.println("t2.a = "+t2.a);
		System.out.println("t3.a = "+t3.a);
		
		t2.a =100;
		System.out.println("** non-static변수 후 **");
		System.out.println("t1.a = "+t1.a);
		System.out.println("t2.a = "+t2.a);
		System.out.println("t3.a = "+t3.a);
		
		System.out.println("** static변수 **");
		System.out.println("t1.b = "+Test.b);
		System.out.println("t2.b = "+Test.b);
		System.out.println("t3.b = "+Test.b);
		Test.b =100;
		System.out.println("** non-static변수 후 **");
		System.out.println("t1.b = "+Test.b);
		System.out.println("t2.b = "+Test.b);
		System.out.println("t3.b = "+Test.b);
	}
	
	static {
		System.out.println("가장 먼저 실행");
	}

}
