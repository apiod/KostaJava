package ex0806.enumex;

public class EnumTest {

	public static void main(String[] args) {
		Grade g = Grade.GOLD;
		switch(g) {
		case BASIC: System.out.println("일반고객");break;
		case SILVER: System.out.println("실버");break;
		case GOLD: System.out.println("골드");break;
		}
		System.out.println(g.getKind());
		System.out.println(g.getPoint());
		System.out.println(g.getRole());
			
		
	}

}
