package ex0729.제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		//1이면 월요일~7 토요일
		int num = (int)(Math.random()*12+1);
		String day="토";
		switch (num) {
		case 1: day = "일"; break;
		case 2: day = "월"; break;
		case 3: day = "화"; break;
		case 4: day = "수"; break;
		case 5: day = "목"; break;
		case 6: day = "금"; break;
		default: System.out.println("0");
		}
		System.out.println(num + ": "+day+"요일");
	}

}
