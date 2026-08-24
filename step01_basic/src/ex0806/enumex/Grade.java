package ex0806.enumex;

/*
 * enum은 열거형으로 안에 정의된 정보는 static final이다.
 * 따로 선언을 안해되 자동으로 static final 선언
 * 제한자, 변수명을 입력하지않는다.
 */
public enum Grade {
	BASIC("일반", 100,5), SILVER("우수", 200, 10), GOLD("최우수", 300, 30);
	private final String kind;
	private final int point;
	private final int role;
	//Grade.BASIC 선언시 -> 생성자 호출하여 값 설정
	
//	enum타입 안에 있는 생성자는 무조건 private
	private Grade(String kind, int point, int role) {
		this.kind=kind;
		this.point=point;
		this.role=role;
	}
	
	public String getKind() {
		return kind;
	}
	public int getPoint() {
		return point;
	}
	public int getRole() {
		return role;
	}
}
