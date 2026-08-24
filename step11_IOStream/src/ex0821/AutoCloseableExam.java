package ex0821;

class Test implements AutoCloseable{
//	AutoCloseable 추상메소드를 구현을 해서 
//	close()메소드를 오버라이딩을 한다면
//	자동으로 try가 빠져나갈때 close()를 호출한다.
//	try구문 -> close구문 -> finally구문
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("close호출");
	}
	
}
public class AutoCloseableExam {
	public static void main(String[] args) {
		System.out.println("start");
		try (Test test = new Test()){//autoClose를 하려면 사용해야하는 것
			System.out.println(test);
			System.out.println("after test");

		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			System.out.println("finally");
		}
		
		System.out.println("end");
	}
}
