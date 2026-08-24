package step05_Lamda;

public class MainApp {
	
	public static void main(String[] args) {
		//1. 기존방식
//		AInterface aInterface = new Test();
//		aInterface.aa();
		
		//2. 익명의 이너클래스(AnonymouseInnerclass) 타입을 작성
//		AInterface  ai = new AInterface() {
//			
//			@Override
//			public void aa() {
//				System.out.println("익명의 AnonymouseInnerClass() aa 호출");
//				
//			}
//		};
//		ai.aa();
		
		/*람다식
		 * : 반드시 interface안에 메소드한개있을 경우에 사용할수 있다.
		 * : FunctionalInterface라고 한다
		 * 	문법
		 * 		인수가 없는경우
		 * 		()->{}
		 * 		인수가 있는 경우
		 * 		(변수이름,...) ->{}
		 * 		기능이한문장인 경우
		 * 		()->  기능
		 */
		AInterface ai = ()->{System.out.println("인수없는 람다식");};
		ai.aa();
		BInterface bi=(a)->{
			System.out.println("BInterface a: " + a);
		};
		bi.bb(50);
		CInterface ci = (i,j) -> i*j;
//			System.out.println("인수가 2개인 함수, 리턴있는 함수");
			
		
		int result = ci.cc(5,10);
		System.out.println(result);
	}
}
class Test implements AInterface{
	@Override
	public void aa() {
		System.out.println("Test의  aa메소드입니다. ");
		
	}
}
