package ex0810.superkeyword;

class Animal{
	int age=5;
	String bodyColor;
	public void sound() {
		System.out.println("super의 sound");
	}
	public void eat() {
		System.out.println("super의 eat");
	}
}

class Cat extends Animal{
	int age=10;
	int weight;
	
	@Override
	public void sound() {//annotation은 @를 뜻하고 클래스, 메소드, 필드위에 선언
		System.out.println("Cat의 sound");
	}
	public void run() {
		System.out.println("Cat의 run");
	}
	public void test() {
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
		System.out.println("-------------");

		System.out.println(bodyColor);
		System.out.println(this.bodyColor);
		System.out.println(super.bodyColor);
		System.out.println("-------------");

		System.out.println(weight);
		System.out.println(this.weight);
//		System.out.println(super.weight);
		System.out.println("-------------");

		sound();
		this.sound();
		super.sound();

		eat();
		this.eat();
		super.eat();
		
		run();
		this.run();
//		super.run();
	}
}

public class InheritanceFiledMethodExam {

	public static void main(String[] args) {
		Cat cat = new Cat();
//		cat.test();

		System.out.println(cat.age);
		System.out.println(cat.bodyColor);
		System.out.println(cat.weight);
		cat.sound();
		cat.eat();
		cat.run();

		Animal an = new Cat();
		System.out.println(an.age);
		System.out.println(an.bodyColor);
//		System.out.println(an.weight);

		an.sound();//오버라이딩을하여 최종으로 재정의된메소드가 사용된다.
		an.eat();
//		an.run();
		
//		if(an instanceof Cat) {
//			Cat anc =(Cat)an; //ObjectDownCasting

		if(an instanceof Cat anc) {// 이렇게  해도된다.
			
			System.out.println( "c="+anc);
			System.out.println(cat.weight);
			anc.run();
			
		}
	}

}
