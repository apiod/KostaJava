package ex0813.exam.list;

import java.util.ArrayList;
import java.util.Collections;

public class ListExam01 extends ArrayList<Integer>{
	//객체가 생성될때 부모의 생성자를 호출한다
	//ArrayList의 기본생성자는 10개의 List를 생성한다.
	//인수로 숫자를 주면 숫자만큼의 크기List가 생성된다.
	public ListExam01() {
		super(5); //5개 공간을 만든다. 
		add(3);
		super.add(10);
		this.add(20);
		add(2);
		add(1);
		add(7);
		add(4);
		
		System.out.println("저장된객체의 개수 = " + size());
		for(int i=0;i<size();i++) {
			System.out.println(get(i));
		}
		
		for(int j: this){
			System.out.println(j);
		}
		System.out.println(this);
		remove(2);
		System.out.println(this);
		Collections.sort(this);
		System.out.println(this);
		Collections.sort(this, Collections.reverseOrder());
		System.out.println(this);
	}
	
	public static void main(String[] args) {
		new ListExam01();
		
	}
}
