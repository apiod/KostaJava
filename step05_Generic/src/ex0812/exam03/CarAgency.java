package ex0812.exam03;

public class CarAgency implements Rentable<Car> {
	public Car rent() {
		return new Car();
	}
}
