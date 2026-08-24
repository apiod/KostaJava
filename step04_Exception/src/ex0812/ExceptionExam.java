package ex0812;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("***Exception Test***");
		
		System.out.println("args = " + args);
		try {
			System.out.println("args[0] = " +args[0]);
			int convertNo = Integer.parseInt(args[0]);
			System.out.println(convertNo);
			int convertNo1 = Integer.parseInt(args[1]);
			System.out.println(convertNo1);
		
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("인수의 값을전달: "+ e);
//		}catch (NumberFormatException e) {
//			System.out.println("에러메세지: "+e.getMessage());
		}catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();//개발자를위한메소드 (예외정보를 detail하게 추적할수 있다.)
		}
		
		
		
		
		

		System.out.println("***Exception Test End***");
	}

}
