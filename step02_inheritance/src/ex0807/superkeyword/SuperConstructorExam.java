package ex0807.superkeyword;

class parent{
	public parent() {
		System.out.println(1);
	}public parent(int i) {
		System.out.println(2);
	}public parent(String s) {
		System.out.println(3);
	}
}
class child extends parent{
	public child() {
//		super();//자동으로 써진다 안넣어도 된다
		System.out.println(4);
	}public child(int i) {
		System.out.println(5);
	}public child(boolean b) {
		System.out.println(6);
	}
	
}

public class SuperConstructorExam {

	public static void main(String[] args) {
//		new child();//1 4
//		new child(10); //1 5
		
		
		

	}

}
