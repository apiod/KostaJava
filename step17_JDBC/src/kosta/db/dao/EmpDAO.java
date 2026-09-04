package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kosta.db.dto.EmpDTO;
import kosta.db.util.DbManager;

public class EmpDAO {
	/**
	 * emp테이블에서 사원의 모든 이름 검색
	 */
	
	public void selectNames() {
		//로드 연결 실행  닫기
		Connection con = null;
		Statement st = null;
		ResultSet rs= null;
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select ename from emp");
			while(rs.next()) {
				//앞으로 커서가  이동한다면(true)
				//열을조회
				String ename = rs.getString("ename");
				System.out.println(ename);
			}
			System.out.println("END_________");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con,st,rs);
		}
	}
	/**
	 * 번호에 따른 삭제
	 * @param empno
	 */
	public void deleteByEmpno(int empno) {
		Connection con = null;
		Statement st = null;
		String sql = "delete from emp where empno="+empno;
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			int re = st.executeUpdate(sql);
			if(re==0) System.out.println("삭제되지 않았습니다.");
			else System.out.println("삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con,st);
		}
	}
	
	/**
	 * 위 delete를 PreparedStatement방식
	 */
	public void deleteByEmpno2(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from emp where empno=?";
		
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			//?의  개수만큼 순서대로 setXxx()설정 필요
			ps.setInt(1, empno);
			
			//실행요청
			int re = ps.executeUpdate();
			if(re==0) System.out.println("삭제되지 않았습니다.");
			else System.out.println("삭제되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con,ps);
		}
	}
	
	/**
	 * 모든 사원의 정보 검색하기
	 */
	public List<EmpDTO> selectAll() {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp";
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		try {
			con=DbManager.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 ps.setXx()필수
			//없어도 상관없다.
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				
				EmpDTO dto = new EmpDTO(empno, ename, job, sal, hiredate);
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return list;
	}
	/**
	 * 사원번호에 해당하는 사원정보 검색하기
	 * select empno, ename, job, sal, hiredate from emp where empno=?
	 */
	public EmpDTO selectByEmpno(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp where empno=?";
		EmpDTO dto=null;
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
//			ps.setInt(empno, empno);
			rs = ps.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				dto = new EmpDTO(no, ename, job, sal, hiredate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return dto;
	}
	
	/**
	 * 사원 정보 등록하기
	 * insert into emp(empno, ename, job, sal, hiredate) values (?,?,?,?,now());
	 */
	public int insert(int empno, String ename, String job, int sal) {
		Connection con =null;
		PreparedStatement ps = null;
		int re = 0;
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values (?,?,?,?,now())";
		try {
			con = DbManager.getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, empno);
			ps.setString(2, ename);
			ps.setString(3, job);
			ps.setInt(4, sal);
			re= ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	

}
