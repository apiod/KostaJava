package ex0804.array;

class ObjectOne{
	public int a;
}

public class ObjectInArray{
	//메인 메소드에서 
	public static void main(String[] args) {
		//ObjectOne 타입을 5개 까지 저장하는 배열을 선언하고
		 ObjectOne[] o=new ObjectOne[5];
		//5개의 ObjectOne객체를 생성하세요.
		 for(int i=0;i<5;i++) {
			 o[i]=new ObjectOne();
			 
		 }
		 int j=10;
		 System.out.println(o);
		 for(ObjectOne obj:o) {
//			각 객체가 갖고있는 전역변수 출력
			 System.out.print("값: "+obj.a);
//			 각 객체의 주소값 출력
			 System.out.print("\t주소값: "+obj);//주소값
//			 각각의 ObjectOne객체가 서로 다른 a의 값을 갖도록 a의 값을 변경하세요.
			 obj.a=j++;
//			 각 ObjectOne 객체의 a를 출력하세요
			 System.out.println("\t변경된 값: "+obj.a);
		 }
	}

			
		
	
}
