package ex0821;

import java.io.Serializable;

/**
 * Serializable 구현한 객체는 직렬화 대상이 된다.
 * 즉,  파일에 직렬화해서저장 할 수 있다.
 */

public class Member implements Serializable{
	
	
	/**
	 * 직렬화된 객체와 현재 크르래스가 서로 호환되는 버전인지 확인하기 위한 버전 번호
	 * serial
	 * 멤버필드가 업데이트가 되어 속성이 추가된다면 값이 
	 * 바뀌어도 같은 객체로 인식을 하고 복원해준다. 
	 * 이 값을 아무거나 해도상관은 없다.
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int age;
	private String addr;
//	private transient String addr;//직렬화 대상에서 제외
//	private static addr; //직렬화 대상에서 제외
	
	
	
	public Member() {}
	public Member(String id, int age, String addr) {
		super();
		this.id = id;
		this.age = age;
		this.addr = addr;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [id=");
		builder.append(id);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
