package ex0813.exam.list;

import java.util.ArrayList;
import java.util.Collections;

public class ListExam02{
	ArrayList<Integer> list = new ArrayList<Integer>(5);
	//객체가 생성될때 부모의 생성자를 호출한다
	//ArrayList의 기본생성자는 10개의 List를 생성한다.
	//인수로 숫자를 주면 숫자만큼의 크기List가 생성된다.
	public ListExam02() {
		list.add(5); //5개 공간을 만든다. 
		list.add(3);
		list.add(10);
		list.add(20);
		list.add(2);
		list.add(1);
		list.add(7);
		list.add(4);
		
		System.out.println("저장된객체의 개수 = " + list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		for(int j: list){
			System.out.println(j);
		}
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		new ListExam02();
		
	}
}
