package ex0730.제어문;

public class DoWhileExam01 {

	public static void main(String[] args) {
		int i =1,j=1;
		System.out.println("1. ");
		do{
			System.out.print(i+" ");
			i++;
		}while(i<=100); 
		System.out.println("\n2. ");
		//2. A ~Z 까지 한줄로 출력
		i='A';
		do{
			System.out.print((char)i+" ");
			i++;
		}while(i<='Z');
		System.out.println("\n3. ");
		//3. 1~ 10 까지  합 구해서 출력
		int sum =0;
		i=1;
		do{
			sum+=i;
			i++;
		}while(i<=10);
		System.out.println(sum+"\n4. ");
		//4. 1 ~ 100 사이의 7의 배수만 출력
		i=1;
		do {
			if(i%7==0)
				System.out.print(i+" ");
			i++;
		}while(i<=100); 
		System.out.println("\n5. ");
		//5. 100 ~ 1 사이의 5 의 배수만 출력
		i=100;
		do {
			if(i%5==0) System.out.print(i+" ");
			i--;
		}while (i>1); 
		System.out.println();
		//====================================

		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		i=0;
		System.out.println("----1. -----");
		do {
			j=1;
			do{
				System.out.print(i*10+j+" ");
				j++;
			} while(j<=10); 
			System.out.println();
			i++;
		}while(i<10) ;
		
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)
		i=1;
		System.out.println("----2. ----");
		do {
			System.out.print(i+" ");
			if(i%10==0) {
				System.out.println();
			}
			i++;
		}while(i<=100); 
		//3. 구구단 출력  -  for 문안에 for문이용
		System.out.println("---3---");
		i=2;
		do {
			System.out.print(i+"단 ");
			j=1;
			do {
				System.out.print(i+"*"+j+"="+i*j+" ");
				j++;
			}while(j<10); 
			i++;
			System.out.println();
		}while(i<10);
		
		
		
		
	}
}
