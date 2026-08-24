package ex0814.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	
	Set<String> set = new TreeSet<>();
	Set<String> set1 = new HashSet<>(set);
	public SetExam(String[] data) {
		//데이터 추가
		for(String s:data) { 
			boolean re = set.add(s);//중복 불가 
//			System.out.println(s+".add후 결과: "+re);
			set1.add(s);
		}
		System.out.println("최종결과------------\nTreeSet: " + set);
		System.out.println("HashSet: "+set1);
		System.out.println("저장된 갯수: "+set.size());
		
		//Iterator는 자료 구조안에 있는 데이터를 꺼낼수 있는 메소드 제공
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {//hasNext()다음 요소가 있다면 true리턴
//			System.out.print("next전 요소"+ set);
			String s = iterator.next();
			System.out.print(s+" ");
		}
		
		System.out.println("\n---개선된 for 변경---");
		for(String s: set) {
			System.out.print(s+" ");
		}
		System.out.println("\n요소 제거");
		boolean rer = set.remove("사과");
		System.out.println("rer: "+rer);
		
		System.out.println("제거후: "+set);
		
		System.out.println("요소 찾기");
		boolean rec = set.contains("사과");
		System.out.println("rec: " + rec);
	}
	public static void main(String[] args) {
		new SetExam(args);
	}
}
