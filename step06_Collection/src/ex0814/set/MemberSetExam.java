package ex0814.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
	
	public MemberSetExam() {
		set.add(new Member("희정1", 10, "서울"));
		set.add(new Member("희정1", 101, "서울1"));
		set.add(new Member("희정2", 102, "서울2"));
		
		System.out.println("저장된 객체의 수 = "+set.size());
	}
	public static void main(String[] args) {
		new MemberSetExam();
	}
}
