package ex0805.constructor.student;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	private final int maxIndex=5;
	//다른 클래스 내에서도 사용하기 위해 public
	//객체생성안하고 사용하기 위해서 static
	public static int nowIndex=0;
	private Student[] stArr=new Student[maxIndex];
	/**
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
	public StudentService(String[][] data) {//생성자
		int row=data.length;//3 3명의 정보
		for(int i=0;i<row;i++) {
			stArr[nowIndex++]=createStudent(data[i]);
		}
	}
	
	/**
	 *  Student객체를 생성해서 리턴해주는 메소드 작성
	 * */
	 private Student createStudent(String[] row) {
		 Student st =new Student(row[0], Integer.parseInt(row[1]),row[2]);
		 return st;
	 }
	 private Student createStudent(Student std) {
		 Student st =new Student(std.getName(), std.getAge(), std.getAddr());
		 return st;
	 }
	 /**
	   학생의 정보 등록하기 
	   	학생의 이름이 중복이면 등록할수 없다.
	    : 배열의 경계를 벗어나면 더이상 추가할수 없다.
	      이외의 상황은 추가
	      
	      @return 0 중복, -1더이상 등록불가, 1성공
	  **/
	 public int insert(Student std) {
		 
		 if (nowIndex>=maxIndex-1) {
			 
			 return -1;
		 }
		 else if(selectByName(std.getName())!=null) {//이름 중복
			 return 0;
		 }
		 else {
			 stArr[nowIndex++]=createStudent(std);
			 return 1;
		 }
	 }
	/**
	 * 전체 학생의 정보 조회하기
	 * */
	 public Student[] selectAll() {
		 return stArr;
//		 for(int i =0;i<nowIndex;i++) {
//			 System.out.println("이름: "+stArr[i].getName());
//			 System.out.println("나이: "+stArr[i].getAge());
//			 System.out.println("주소: "+stArr[i].getAddr());
//			 System.out.println("-------------------------");
//		 }
	 }
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를출력하고
	 *     없으면 "찾는정보가 없습니다." 출력한다.
	 *     @return Student | null
	 * */
	 public Student selectByName(String name) {
		 for(int i=0;i<nowIndex;i++) {
			 if (stArr[i].getName().equals(name)) {
				 return stArr[i];
			 }
		 }
		 return null;
	 }
	 
	
	
	/**
	 * 이름에 해당하는 학생의 나이와 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 false
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
	 *   true 리턴
	 *   @param : Student
	 *   @return : boolean
	 * */
	public boolean update(Student std) {
		Student searchStd = this.selectByName(std.getName());
		if (searchStd ==null) return false;
		searchStd.setAge(std.getAge());
		searchStd.setAddr(std.getAddr());
		return true;
	}

}

