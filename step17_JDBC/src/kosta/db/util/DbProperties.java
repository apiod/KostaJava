package kosta.db.util;

/**
 * DB설정 정보를 상수로 관리
 * interface는 모든 변수는 public static final을 이용
 */
public interface DbProperties {
	String DRVIER_NAME="com.mysql.cj.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306/mydb";
	String USER_ID="java";
	String USER_PASS="java";
}
