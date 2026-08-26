package stream.ex02;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String[] args) {
		System.out.println("1.String Array Stream ------------");
		String [] strArr = {"희정","현준","정화","민지","경찬"};
		/*for(String s:strArr) { //자료구조의 Iterator를 이용한 방식
			System.out.println(s);
		}*/
		
		//Stream을 이용해서  출력해보자
//		스트림은 단 한번만 사용가능하다.
		Stream<String> stream = Arrays.stream(strArr);
		//1) 람다식
		//람다기존
//		stream.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		});
		//람다
//		stream.forEach(t->System.out.println(t));
		
		//2) 메소드 참조
		stream.forEach(System.out::println);
		//3) 한번 사용한 Stream을 다시 사용해보자(사용불가x)
		
		
		System.out.println("2.int Array Stream ------------");
		int [] intArr = {1,2,3,4,5,6,7,8,9};
		//2의 배수만 출력
		Arrays.stream(intArr)
		.filter((n)->n%2==0)
		.forEach(System.out::println);
		
		System.out.println("3.range()  vs rangeClosed() ------------");
		//0~9
		System.out.println("IntStream.range(0, 10): " + IntStream.range(0, 10).sum());
		//0~10
		System.out.println("IntStream.rangeClosed(0, 10): " + IntStream.rangeClosed(0, 10).sum());

	}

}






