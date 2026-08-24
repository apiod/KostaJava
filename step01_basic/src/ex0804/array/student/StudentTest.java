package ex0804.array.student;

public class StudentTest {
	public static void main(String[] args) {
		String[][] data = {
				{"김춘배","32","오리"},
				{"홍길동","20","상록수"},
				{"김나영","27","성남"},
		};
		StudentService service = new StudentService();//StudentService의 전역변수들이 초기화
		service.init(data); // 초기 데이터 세팅
		System.out.println("***학생 관리 프로그램 시작합니다.******");
		 
		
		
		//전체학생정보 출력
		Student[] stArr = service.selectAll();
		StudentEndView.printSelectAll(stArr);
//		StudentEndView.printSelectAll(service.selectAll());
//		
		//등록하기
		System.out.println("--1. 등록하기 -----");
		Student student = new Student();
		student.setName("미미");
		student.setAge(25);
		student.setAddr("오리역");
		
		//정보 삽입
		int check=service.insert(student);;
		if(check==-1) {
			StudentEndView.printMessage("더 이상 추가할수 없습니다.");
		}else if(check==0) {
			StudentEndView.printMessage("이름 중복");
		}else if(check==1) {
			StudentEndView.printMessage("등록 완료");
			StudentEndView.printSelectAll(service.selectAll());
		}
		
		//이름으로 검색하기
		System.out.println("--3. 이름으로 검색 -----");
		Student st = service.selectByName("김춘배");
		
		if (st != null) StudentEndView.printSelcetByName(st);
		else StudentEndView.printMessage("해당하는 정보가 없습니다.");
		
		System.out.println("--이름이 없는경우----");
		st= service.selectByName("삼순이");
		if (st != null) StudentEndView.printSelcetByName(st);
		else StudentEndView.printMessage("해당하는 정보가 없습니다.");
		
		
		//수정하기 
		System.out.println("--4. 수정하기 -----");
		Student st2 =new Student();
		st2.setName("김나영");//조건
		st2.setAge(23);
		st2.setAddr("대전");
		
		if(service.update(st2)) {
			StudentEndView.printMessage("수정되었습니다.");
		}else StudentEndView.printMessage("수정되지 않았습니다.");
			
		
		System.out.println("---변경후 ---");
		StudentEndView.printSelectAll(service.selectAll());

	}

}








