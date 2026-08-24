package ex0730.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// 
		//키보드 입력
		Scanner sc = new Scanner(System.in);//ctrl + shift+o -> 자동 import
		int menu=1;
		while(true){
			System.out.println("1. 성적표 \t2. 종료");
			System.out.print("원하는 메뉴 번호 입력");
			menu = sc.nextInt();//숫자 입력
			if(menu==1) {
				System.out.print("이름: ");
				String name = sc.next(); //공백 무시
		
				System.out.println("국어점수: ");
				int korScore = sc.nextInt();//숫자 입력
				
				System.out.println("영어점수: ");
				int engScore = sc.nextInt();//숫자 입력
				
				System.out.println(name+"님의 성적표");
				System.out.println("국어점수: " +korScore);
				System.out.println("영어점수: " +engScore);
				System.out.println("총점수: " +(korScore+engScore));	
			}
			else if(menu==2)System.out.println("프로그램종료"); break;
		}

	}

}
