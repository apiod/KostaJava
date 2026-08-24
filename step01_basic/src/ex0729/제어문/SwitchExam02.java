package ex0729.제어문;

public class SwitchExam02 {

	public static void main(String[] args) {
		int mon = (int)(Math.random()*12+1);
		int day = 31;
//		switch (mon) {
//		case 4,6,9,11: day=31;break;
//		case 2: day=28;break;
//		default: day=30;
//		}
			if(mon==2)day=28;
			else if(mon==4|mon==6 |mon==9|mon==11) day=30;
			else day=31;
			System.out.println(mon + "월 "+day+"일");
	}
}
