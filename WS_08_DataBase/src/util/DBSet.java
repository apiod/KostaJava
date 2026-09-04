package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSet {
	/**
	 * DB로드
	 */
	static {
		try {
			Class.forName(DBProperties.DRVIER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB연결
	 */
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(
				DBProperties.URL, 
				DBProperties.USER_ID,  
				DBProperties.USER_PASS);
		return con;
	}
	/**
	 * 닫기 (DDL, DML인 경우)
	 */
	public static void dbClose(Connection con, Statement st) {
		
			try {
				if(st!=null) st.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	/**
	 * 닫기 (Select)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
