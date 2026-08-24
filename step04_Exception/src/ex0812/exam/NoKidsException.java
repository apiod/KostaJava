package ex0812.exam;

public class NoKidsException extends Exception {
	static int count=0;
	
	NoKidsException(){}
	NoKidsException(String message){
		super(message);
	}
}
