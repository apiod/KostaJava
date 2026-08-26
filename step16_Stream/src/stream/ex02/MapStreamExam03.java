package stream.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapStreamExam03 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("희정", 22, 80, "컴퓨터"), new Student("나영", 25, 60, "과학"),
				new Student("미영", 21, 82, "컴퓨터"), new Student("삼순", 30, 95, "국어"), new Student("삼식", 22, 70, "수학"),
				new Student("효경", 28, 80, "국어"));

		// 1. 전체 출력
		System.out.println("1. 전체 출력------------");

		list.stream().forEach(System.out::println);

		// 2.점수만 걸러내서 출력
		System.out.println("2.점수만 걸러내서 출력 ------");
//		list.stream().map(s->s.getScore());
		list.stream().map(Student::getScore).forEach(System.out::println);

		// 3. 점수의 총점
		System.out.println("3.점수의 총점--------");
		// IntStream을 써야 숫자와 관련된 함수를 쓸 수 있다.
		// mapToInt -> IntStream으로 바꿔준다.
		int re = list.stream().mapToInt(Student::getScore).sum();
		System.out.println("결과: " + re);
		// 4. 점수의 평균
		System.out.println("4.점수의 평균--------");
		double aver = list.stream().mapToInt(Student::getScore).average().getAsDouble();
		System.out.println(aver);
		// 5. 점수의 개수(인원수)
		System.out.println("5. 점수의 개수(인원수)--------");
		long c =list.stream().map(Student::getScore).count();
		System.out.println(c);
		// 점수가 80 이상인 학생들의 이름만 검색
		System.out.println("점수가 80 이상인 학생들의 이름만 검색--------");
		list.stream().filter(s->s.getScore()>=80).map(Student::getName).forEach(System.out::println);
	}

}
