package ex0729.제어문;

public class IfExam02 {

	public static void main(String[] args) {
		//1이면 월요일~7 토요일
		int num = (int)(Math.random()*12+1);
		String day="";
		System.out.println(num);
		if(num == 1) day = "월";
		else if(num==2) day = "화";
		else if(num==3) day = "수";
		else if(num==4) day = "목";
		else if(num==5) day = "금";
		else if(num==6) day = "토";
		else day = "일";
		
		System.out.println(num + ": "+day+"요일");
	}

}
