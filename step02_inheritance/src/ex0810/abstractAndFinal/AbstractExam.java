package ex0810.abstractAndFinal;

import java.security.PublicKey;

abstract class Animal{
	int legs;
	public abstract void sound();
	public abstract void run();
	public void eat() {
		System.out.println("먹는다");
	}
}
class Dog extends Animal{
	@Override
	public void sound() {
		System.out.println("dog sound");
	}
	@Override
	public void run() {
		System.out.println("dog run");
	}
}
class Cat extends Animal{
	@Override
	public void sound() {
		System.out.println("cat sound");
		
	}
	@Override
	public void run() {
		System.out.println("cat run");
		
	}
	
}
class Pig extends Animal{
	@Override
	public void sound() {
		System.out.println("pig sound");	
	}
	@Override
	public void run() {
		System.out.println("pig run");
		
	}
	@Override
	public void eat() {
		System.out.println("pig eat");
	}
}
public class AbstractExam {
	
	public void test(Animal ani) {
		ani.eat();
		ani.sound();
		ani.run();
		System.out.println("--------");
	}
	public static void main(String[] args) {
		
		AbstractExam ab = new AbstractExam();
		ab.test(new Cat());
		ab.test(new Dog());
		ab.test(new Pig());
		Cat cat= new Cat();
		Dog dogs = new Dog();
		Pig pig = new Pig();
		
	}

}
