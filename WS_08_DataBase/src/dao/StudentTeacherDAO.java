package dao;

import java.util.List;

import vo.Student;
import vo.Teacher;

public interface StudentTeacherDAO {
	/**
	 * 1번 : 성별이 여자인 학생의 정보 검색
       select * from student where jumin like '%-2%'
	 * */
	public List<Student> getGenderByWomen();
	
	/**
	 * 3.  "구"를 인수로 전달받아 구에 거주하는 강사의 정보 검색
	 *      select * from teacher  where addr like ?
	 * */
	public List<Teacher> getTeacherInfoByAddr(String gu);
	
	/**
	 * 5. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리) 
         select * from teacher where sub_code = 
          (select sub_code from subject where upper(sub_name)=upper( ? ))
	 * */
	
	public Teacher getTeacherInfoBySubject(String subject);
	
	

	/**
	 * 8강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다
	 *   select * from v_teacherInfo  where 강사번호=?
	 * 
	 * */
	public Teacher getTeacherInfoByNo(int teacherNo);
}





