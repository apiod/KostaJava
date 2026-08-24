package ex0730.제어문;

public class WhileExam01 {

	public static void main(String[] args) {
		//1. 1~ 100가지 한줄로 출력
		int i =1,j=1;
		System.out.println("1. ");
		while(i<=100) {
			System.out.print(i+" ");
			i++;
		}
		System.out.println("\n2. ");
		//2. A ~Z 까지 한줄로 출력
		i='A';
		while(i<='Z') {
			System.out.print((char)i+" ");
			i++;
		}
		System.out.println("\n3. ");
		//3. 1~ 10 까지  합 구해서 출력
		int sum =0;
		i=1;
		while(i<=10) {
			sum+=i;
			i++;
		}
		System.out.println(sum+"\n4. ");
		//4. 1 ~ 100 사이의 7의 배수만 출력
		i=1;
		while(i<=100) {
			if(i%7==0)
				System.out.print(i+" ");
			i++;
		}
		System.out.println();
		//5. 100 ~ 1 사이의 5 의 배수만 출력
		i=100;
		while (i>1) {
			if(i%5==0) System.out.print(i+" ");
			i--;
		}
		System.out.println();
		//====================================

		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		i=0;
		System.out.println("----1. -----");
		while(i<10) {
			j=1;
			while(j<=10) {
				System.out.print(i*10+j+" ");
				j++;
			}
			System.out.println();
			i++;
		}
		
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)
		i=1;
		System.out.println("----2. ----");
		while(i<=100) {
			System.out.print(i+" ");
			if(i%10==0) {
				System.out.println();
			}
			i++;
		}
		//3. 구구단 출력  -  for 문안에 for문이용
		System.out.println("---3---");
		i=2;
		while(i<10) {
			System.out.print(i+"단 ");
			j=1;
			while(j<10) {
				System.out.print(i+"*"+j+"="+i*j+" ");
				j++;
			}
			i++;
			System.out.println();
		}
	}

}
