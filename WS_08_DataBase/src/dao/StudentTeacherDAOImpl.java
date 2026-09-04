package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBSet;
import vo.Room;
import vo.Student;
import vo.Subject;
import vo.Teacher;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {
	/**
	 * 1번 : 성별이 여자인 학생의 정보 검색
       select * from student where  수_주민등록번호 like '%-2%'
	 * */
	@Override
	public List<Student> getGenderByWomen() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from student where jumin like '%-2%'";
		List<Student> list = new ArrayList<>();
		try {
			con = DBSet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student(
						rs.getInt(1), 
					rs.getString("Name"), 
					rs.getString("jumin"),
					rs.getString("phone"),
					rs.getString("addr"),
					rs.getString("email")
				);
				list.add(student);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			DBSet.dbClose(con, ps, rs);
		}
		return list;
	}
	/**
	 * 3.  "구"를 인수로 전달받아 구에 거주하는 강사의 정보 검색
	 *      select * from teacher  where addr like ?
	 * */
	@Override
	public List<Teacher> getTeacherInfoByAddr(String gu) {
		String sql = "select * from teacher where addr like ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> list = new ArrayList<>();
		
		try {
			con = DBSet.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+gu+"%");
			System.out.println(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher(
					rs.getInt(1), 
					rs.getString("name"), 
					rs.getString("jumin"),
					rs.getString("phone"),
					rs.getString("addr"),
					rs.getString("email"),
					rs.getString("sub_code")
				);
				list.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBSet.dbClose(con, ps, rs);
		}
		return list;
	}
	/**
	 * 5. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리) 
         select * from teacher where sub_code = 
          (select sub_code from subject where upper(sub_name)=upper( ? ))
	 * */
	@Override
	public Teacher getTeacherInfoBySubject(String subject) {
		String sql = "select * from teacher where sub_code = "
				+ "(select sub_code from subject where upper(sub_name)=upper( ? ))";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher teacher=null;
		
		try {
			con = DBSet.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, subject);
			System.out.println(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				teacher = new Teacher(
					rs.getInt(1), 
					rs.getString("name"), 
					rs.getString("jumin"),
					rs.getString("phone"),
					rs.getString("addr"),
					rs.getString("email"),
					rs.getString("sub_code")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBSet.dbClose(con, ps, rs);
		}
		return teacher;
	}

	/**
	 * 8강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다
	 *   select * from v_teacherInfo  where 강사번호=?
	 * 
	 * */
	@Override
	public Teacher getTeacherInfoByNo(int teacherNo) {
		String sql = "select * from v_teacherInfo where num=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher teacher = new Teacher();
		
		try {
			con = DBSet.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, teacherNo);
			System.out.println(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Subject sub = new Subject(
						rs.getString("sub_code"),
						rs.getString("sub_name"));
				Room room = new Room(rs.getInt("room_num"),rs.getInt("capacity"));
				//과목이름, 코드, 이름, 번호, 용량
				teacher.setSubject(sub);
				teacher.setRoom(room);
				teacher.setTeacherNo(rs.getInt("num"));
				teacher.setTeacherName(rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBSet.dbClose(con, ps, rs);
		}
		return teacher;
	}

}
