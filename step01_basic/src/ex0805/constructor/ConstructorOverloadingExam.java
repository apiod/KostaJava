package ex0805.constructor;
class Puppy3{
	/*String 타입 전역 변수 선언
	  int 타입 전역 변수 선언*/
		String name;
		int num;
	
	/*인수가 없는 생성자작성
		String 타입 전역변수에 "메리" 할당
		"puplic Puppy3()호출되었습니다"출력
		전역변수 출력
	*/		
	public Puppy3() {
		this.name="메리";
		System.out.println("puplic Puppy3()호출되었습니다");
		System.out.printf("이름: %s \t번호: %d\n",this.name, this.num);
		
	}
	
	/*String 타입의 인수 1개를 받는 생성자작성
		String 타입 전역변수에 인수 할당
		"public Puppy3()호출되었습니다"출력
		전역변수 출력
	*/	
	public Puppy3(String str) {
		this.name=str;
		System.out.println("puplic Puppy3(str)호출되었습니다");
		System.out.printf("이름: %s \t번호: %d\n",name, num);
		
	}
		
	
	/*String 타입의 인수 2개를 받는 생성자작성
		인수2개를 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"출력
	*/		
	public Puppy3(String str, String str2) {
		this(str+str2);
		System.out.println("puplic Puppy3(str+str)호출되었습니다");
		
	}
	
	
	/*boolean 타입의 인수 1개를 받는 생성자작성
		인수를 "쫑"과 붙여 하나의 String으로 만들어
		String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
		"puplic Puppy3()호출되었습니다"  출력
	*/			
	public Puppy3(boolean bo) {
		this(bo+"쫑");
		System.out.println("puplic Puppy3(boolean)호출되었습니다");
	}
	
	/*char 타입의 인수 1개를 받는 생성자작성
			인수가 없는 생성자를 호출하고
			인수로 받은 data를 int타입 전역변수에 할당	
			"puplic Puppy3()호출되었습니다"출력
			int형 전역변수출력
	*/			
	public Puppy3(char ch) {
		this();
		this.num=ch;
		System.out.println("puplic Puppy3(char)호출되었습니다");
		System.out.println(num);
		
	}
	
	
	/*메소드 printMemberVariable
	리턴 없슴
	전역변수를 출력
	*/	
	public void printMemberVariable() {
		System.out.printf("이름: %s \t번호: %d\n",name, num);
	}

	
}

public class ConstructorOverloadingExam{
		//메인메소드에서
		public static void main(String [] args){
			//Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
			System.out.println("\tpu1-----");
			Puppy3 pu1 = new Puppy3();
			System.out.println("\tpu2-----");
			Puppy3 pu2 = new Puppy3("강아지");
			System.out.println("\tpu3-----");
			Puppy3 pu3 = new Puppy3("콩","두부");
			System.out.println("\tpu4-----");
			Puppy3 pu4 = new Puppy3(true);
			System.out.println("\tpu5-----");
			Puppy3 pu5 = new Puppy3('z');
			
		//각 객체의 printMemberVariable메소드를 한번씩 호출
			pu1.printMemberVariable();
			pu2.printMemberVariable();
			pu3.printMemberVariable();
			pu4.printMemberVariable();
			pu5.printMemberVariable();
			
	}
}