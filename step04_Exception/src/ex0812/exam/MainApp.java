package ex0812.exam;

public class MainApp {
	
	public static void main(String[] args) {
		ShoppingMall sh = new ShoppingMall();
		for(int i=0;i<10;i++) {
			int age = (int)(Math.random()*55)+1;
			try {
				sh.checkAge(age);
			} catch (NoKidsException e) {
				System.out.print("age: " + age+"\t");
				NoKidsException.count++;
				System.out.println(e.getMessage());
			}
		}
		System.out.println("count: "+ NoKidsException.count);
	}
}
