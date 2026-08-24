package ex0812.exam;

public class ShoppingMall{
	int adult =18;
	public void checkAge(int age) throws NoKidsException{
		if(adult>age) {
			throw new NoKidsException("애들은 가라");
		}
	}
}
