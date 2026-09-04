package kosta.db.view;

import java.util.List;

import kosta.db.dao.EmpDAO;
import kosta.db.dto.EmpDTO;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("main 시작");
		EmpDAO dao = new EmpDAO();
		//ename 컬럼만 보기
//		dao.selectNames();
		//삭제
//		dao.deleteByEmpno(7369);
		System.out.println("**전체검색**");
//		List<EmpDTO> list = dao.selectAll();
//		list.forEach(System.out::println);

		//		EmpDTO dto = dao.selectByEmpno(7566);
//		System.out.println(dto);

		int re=dao.insert(1234, "길동", "집", 1200);
		if(re==0) System.out.println("실패");
		else System.out.println("성공");
	}
		
}
