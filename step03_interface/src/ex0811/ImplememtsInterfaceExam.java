package ex0811;

//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00{
	abstract void interfaceExam00();
}


interface InterfaceExam01 extends InterfaceExam00{
	final int i = 767;
	/* protected */ int k = 999; //public 이 베이스
	
	void interfaceExam01(int i, int k);
}



interface InterfaceExam02{
	int j =747;
	/* private */int privateInt = 8;  // 마찬가지 public이 베이스
	/* private */void interfaceExam02(int j); 
	
}

class SuperClassExam{
	String superString = "Super";

	String superMethod(){
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam //다중 상속 불가능, interface는 extends가 아닌implements로 구현
implements InterfaceExam01{
	public void interfaceExam00() {
		System.out.println("SubClassExam01.interfaceExam00()");
	}
	public void interfaceExam01(int i, int k) {
		System.out.printf("SubClassExam01.interfaceExam01(%d,%d)",i,k);
	}
		
	
} 



 class SubClassExam02 extends SuperClassExam 
				implements InterfaceExam01, InterfaceExam02{
	 public void interfaceExam00() {
		 System.out.println("SubClassExam02.interfaceExam00");
	 }
	 public void interfaceExam01(int i, int k) {
		 System.out.printf("SubClassExam02.interfaceExam01(%d,%d)\n",i,k);
	 }
	 public void interfaceExam02(int j) {
		 System.out.printf("SubClassExam02.interfaceExam02(%d)\n",j);
	 }

}
 
abstract class SubClassExam03 extends SuperClassExam //class는 implements불가
		implements InterfaceExam01, InterfaceExam02{} //오버라이딩 안해도 되는  이뉴는 abstract class이기 때문
			

class SubClassExam04 extends SubClassExam02{
	//여기에 필요한 것들을 추가하여 문제를 해결하세요..
	public void interfaceExam00(){System.out.println("SubClassExam04.interfaceExam00");}
	public void interfaceExam01(int i, int k){System.out.printf("SubClassExam04.interfaceExam01(%d,%d)\n",i,k);}
	public void interfaceExam02(int j){System.out.printf("SubClassExam04.interfaceExam02(%d)\n",j);}

	SubClassExam04(){ //생성자
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = "+i);
		System.out.println(" j = "+j);
	}
	SubClassExam04(String s1, String s2){
		System.out.println(s1+" 타입 "+"subClassExam04("+s2+") 객체 생성");
		
	}
	void printSuperString(){
//		InterfaceExam01 ie01 = new InterfaceExam01(); //객체 생성불가
		

		System.out.println(" superString = "+superString);
	}
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam{ 
	public static void main(String args[]){		
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
		SuperClassExam  superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		sub04.interfaceExam00();
		sub04.interfaceExam01(1,7);
		sub04.superMethod();
	}
}

