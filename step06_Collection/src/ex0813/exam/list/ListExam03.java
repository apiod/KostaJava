package ex0813.exam.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListExam03 extends ArrayList<Emp>{
	public ListExam03() {
		add(new Emp(20, "홍길동",  20, "성남"));
		add(new Emp(10, "김덕배", 30, "서울"));
		add(new Emp(1, "김춘자", 29, "대전"));
		add(new Emp(2, "김덕자", 31, "대구"));
		add(new Emp(3, "쌀백", 22, "서울"));
		add(new Emp(4, "온돌", 33, "수원"));
	}
	
	/**
	 * 저장된 모든  사원의 정보 검색
	 */
	public List<Emp> selectAll() {
		
		return this;
	}
	
	/**
	 * 사원의 사원번호에 해당하는  사원  정보 검색
	 * @param int empno
	 * @return Emp객체 | null
	 */
	public Emp selectByEmpno(int empno) {
		for (Emp e:this){
			if(e.getEmpno()==empno) {
				return e;
			}
			
		}
		
//		for (int i = 0; i < super.size(); i++) {
//			if(super.get(i).getEmpno()==empno) {
//				return super.get(i);
//			}
//		}
		return null; 
	}
	
	/**
	 * 주소를 인수로 전달받아 동일한 주소에 해당하는 사원정보 검색
	 * @param String addr
	 * @return List<Emp> | null
	 */
	public List<Emp> selectByAddr(String addr) {
		List<Emp> list = new ArrayList<Emp>();
		for(Emp e: this) {
			if(e.getAddr()==addr) {
				list.add(e);
			}
		}
//		for (int i = 0; i < super.size(); i++) {
//			if(super.get(i).getAddr()==addr) {
//				list.add(super.get(i));
//			}
//		}
		return list;
	}
	
	/**
	 * 사원번호를 기준으로 사원정보 정렬 
	 * @param args
	 */
	public List<Emp> sortByEmpno() {
		List<Emp> list = new ArrayList<>(this);
		//sort를 하기 위한 객체는 반드시 comparable를 구현한 객체여야한다.
		//이렇게 하면 정렬이 된 상태로 나온다.
//		Collections.sort(this);
		//이렇게 하면 부를때의 값만 정렬이 된 상태로 나온다.
		Collections.sort(list);
		
		return list;
	}
	
	/**
	 * 나이를 기준으로 사원정보 정렬
	 * @param args
	 */
	public List<Emp> sortByAge() {
		List<Emp> list = new ArrayList<Emp>(this);
		
//		Collections.sort(list, new Test());
//		익명 이너타입으로 선언
//		Collections.sort(list, new Comparator<Emp>() {
//			@Override
//			public int compare(Emp o1, Emp o2) {
//				
//				return o1.getAge()-o2.getAge();
//			}
//		});
//		람다식으로 선언
		Collections.sort(list, (o1,o2)-> o1.getAge()-o2.getAge());
		return list;
	}
	
	
	public static void main(String[] args) {
		ListExam03 ex = new ListExam03();
		List<Emp> list= ex.selectAll();
		for(Emp e:list) {
			System.out.println(e);
		}
		Emp list1= ex.selectByEmpno(4);
		System.out.println("4: "+list1);
		List<Emp> list2= ex.selectByAddr("서울");
		System.out.println("서울: "+list2);
		System.out.println("\n -------------정렬---------------");
		List<Emp> list3 = ex.sortByEmpno();
		for(Emp e:list3) {
			System.out.println(e);
		}
		System.out.println("\n -------------나이 정렬---------------");
		List<Emp> list4 = ex.sortByAge();
		for(Emp e:list4) {
			System.out.println(e);
		}
		
	}
}

class Test implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		return o1.getAge()-o2.getAge();
	}
	
}
