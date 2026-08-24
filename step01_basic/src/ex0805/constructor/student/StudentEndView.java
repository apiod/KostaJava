package ex0805.constructor.student;
/**
 * 사용자 요청에 대한 최종 결과를 모니터에 출력을 담당하는 클래스
 */
public class StudentEndView {
	//여기서 필드가 없고, 오고가는 데이터가 없기때문에 출력구문에서는
	//통상적으로 static을 많이 쓴다.
	
	/**
	 * 전체 학생의 정보 모니터에 출력
	 */
	//nowIndex를 static으로 설정
	//왜 인수로 넘기지 않았는가. 넘기는거랑 차이가 무엇인가
	public static void printSelectAll(Student[] stArr) {
		System.out.printf("학생의 정보 %d명\n", StudentService.nowIndex);
		for(int i=0;i<StudentService.nowIndex;i++) {
			System.out.printf("이름: %s | 나이: %d | 주소: %s\n",
					stArr[i].getName(),stArr[i].getAge(), stArr[i].getAddr());
		}
	}
	/**
	 * 이름에 대한 학생 정보를 출력
	 */
	public static void printSelcetByName(Student std) {
		System.out.printf("이름: %s\n",std.getName());
		System.out.printf("나이: %d | 주소: %s\n",
				std.getAge(), std.getAddr());
	}
	/**
	 * 성공 or 실패에 따른 출력문구
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
