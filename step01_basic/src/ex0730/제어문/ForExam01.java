package ex0730.제어문;

public class ForExam01 {

	public static void main(String[] args) {
		
		//1. 1~ 100가지 한줄로 출력
		System.out.print("1. ");
		for(int i=1;i<=100;i++) {
			System.out.print(i+" ");
		}
		
		//2. A ~Z 까지 한줄로 출력
		System.out.print("\n2. ");
		for (char i='A';i<='Z';i++) {
			System.out.print(i+" ");
		}
		
		//3. 1~ 10 까지  합 구해서 출력
		System.out.print("\n3. ");
		int sum=0;
		for(int i =1;i<=10;i++) {
			sum +=i;
		}
		System.out.print(sum);
		
		//4. 1 ~ 100 사이의 7의 배수만 출력
		System.out.print("\n4. ");
		for(int i =1;i<=100;i++) {
			if(i%7 == 0) System.out.print(i+" ");
		}
		//5. 100 ~ 1 사이의 5 의 배수만 출력
		System.out.print("\n5. ");
		for(int i = 100;i>=1;i--) {
			if(i%5 ==0) System.out.print(i+" ");
		}
		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		System.out.println("\n1. ----------------------");
		for (int i = 0;i<10;i++) {
			for(int j = 1;j<11;j++) {
				System.out.print(i*10+j+" ");
			}
			System.out.println();
		}
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)
		System.out.println("\n2. ----------------------");
		for (int i = 1;i<=100;i++) {
			System.out.print(i+" ");
			if(i%10==0) System.out.println();
		}		
		//3. 구구단 출력  -  for 문안에 for문이용
		System.out.println("\n3. ----------------------");
		for (int i =2;i<10;i++) {
			for(int j =1;j<10;j++) {
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();
		}
	}

}
