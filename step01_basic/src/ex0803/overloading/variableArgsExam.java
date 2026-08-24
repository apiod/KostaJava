package ex0803.overloading;

public class variableArgsExam {
//	public void aa(Object ... i) {//String, int 다양하게 받을수 있다.
	public void aa(int ... i) {//i는 배열이 된다. 
		System.out.println("i= "+ i);
		System.out.println(i.length);
		for(int a=0;a<i.length;a++){System.out.print(i[a]+" ");}
		System.out.println("\n-------------");
	}
	public void bb(int i,String ... s) {// varargs는 마지막 파라미터로만된다.
		
	}
	
	public static void main(String[] args) {
		variableArgsExam ve = new variableArgsExam();
		System.out.println("메소드 호출");
		ve.aa(5);
		ve.aa(5,3,1);
		ve.aa();
		ve.aa(5,1,2,3,4,5,6,7);
		

	}

}
