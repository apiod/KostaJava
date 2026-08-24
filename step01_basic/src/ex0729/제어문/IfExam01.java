package ex0729.제어문;

public class IfExam01 {

	public static void main(String[] args) {
		//정수형 변수 선언
		//선언한 정수의 값이 짝,홀 구분
		//랜덤수 * 경우의수 + 최솟값 ->
		
		int a = (int)(Math.random() * 56 + 45);
		System.out.print(a+" : ");
		if (a % 7 == 0) {
			System.out.println("7의배수");
		}
		else {
			System.out.println("NO");
		}
	}

}
