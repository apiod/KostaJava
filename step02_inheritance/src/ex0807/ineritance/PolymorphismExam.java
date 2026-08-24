package ex0807.ineritance;

class CarCenter{
	public void engineer(Car cd){
//		System.out.println(cd.i);//부모 타입으로는 접근불가
		//부모타입을 자식타입변수에 담는다.
//		EfSonata e = cd //개념적으로 부모 > 자식 
		
		if (cd instanceof EfSonata) {
			EfSonata e = (EfSonata) cd;
			System.out.println(e.i);	
		}
		
		// 부모타입을 자식타입으로 ObjectDownCasting
		
		System.out.print(cd.carname+" 수리완료!\t");
		
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		Car c= new Car();
		
		
		System.out.println("ef.i = "+ ef.i);
		
//		cc.engineer(c);//
		cc.engineer(ef);//
//		cc.engineer(ca);//
//		cc.engineer(ex);//
		
		
	
	}
}
