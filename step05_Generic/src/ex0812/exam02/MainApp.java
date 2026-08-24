package ex0812.exam02;

public class MainApp {
	
	public static void main(String[] args) {
		Product<Tv, String> p1 =new Product<>();
		p1.setKind(new Tv());
		p1.setModel("삼성tv");
		Tv tv = p1.getKind();
		String modelString = p1.getModel();
		
		Product<Vedio, Integer> p2 = new Product<Vedio, Integer>();
		p2.setKind(new Vedio());
		p2.setModel(200);//autoboxing
		
		Vedio vedio = p2.getKind();
		int model = p2.getModel();//unboxing
		
	}
}
