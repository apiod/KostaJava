package ex0731.Scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = sc.nextLine();
		/*
		 * nextLine, next, nextInt
		 */
		sc.nextLine();
		System.out.print("국어 > ");
		int kor = Integer.parseInt(sc.nextLine());
//		문자 입력시 에러 -
//		int kor = sc.nextInt();
		
		System.out.print("영어 > ");
		int eng = sc.nextInt();
		
		
		
		System.out.println(name+ "님의 성적\nkor: "+kor+"\teng: "+eng);
		

	}

}
