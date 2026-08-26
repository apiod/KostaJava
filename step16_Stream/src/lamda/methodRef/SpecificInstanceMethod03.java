package lamda.methodRef; 
import java.util.function.BiFunction; 
 
public class SpecificInstanceMethod03 { 
    public static void main(String[] args) {      
    //기존방식 <매개변수, 매개변수, 리턴>
    BiFunction<String, String, Boolean> beforeEquals = new BiFunction<>() {	
		@Override
		public Boolean apply(String s1, String s2) {
			return s1.equals(s2);
		}
	};
   
     //1. 람다식변경해보자
	BiFunction<String, String, Boolean> beforeEquals2 = (s1, s2)->s1.equals(s2);
	
	 //2. 메소드 참조로 변경해보자
//	BiFunction<인수1, 인수2, 리턴타입> 메소드명 = 객체::실행할 메소드 //여기서 객체는 인수1이 우선  
	BiFunction<String, String, Boolean> beforeEquals3 = String ::equals;
 
	 //3. 호출해보자
    System.out.println("결과1: "+beforeEquals.apply("qqq","www"));
    System.out.println("결과2: "+beforeEquals.apply("qqq","www"));
    System.out.println("결과3: "+beforeEquals.apply("qqq","www"));
    } 
} 


