package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosta.db.util.DbManager;


public class TransactionDAO {
  /**
   * 계좌이체 기능 구현
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {
		Connection con = null;
		
		try {
			con = DbManager.getConnection();
			con.setAutoCommit(false);//자동커밋 해제
			
//			int result = this.withdraw(con, outputAccount, money);
//			if(result ==0) throw new SQLException("출금계좌번호 오류로 계좌이체 실패했습니다.");
			
			int result = this.deposit(con, inputAccount, money);
			if(result ==0) throw new SQLException("입금계좌번호 오류로 계좌이체 실패했습니다.");
			
			if(this.balanceCheck(con, inputAccount)) {
				throw new SQLException("입금계좌 잔액 초과로 계좌이체 실패하였습니다.");
			}
			System.out.println("계좌이체 성공");
			con.commit();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			
			try {
				con.rollback();	
			} catch (Exception e2) {
				System.err.println(e2.getMessage());
				e.printStackTrace();
			}
		} finally {
			DbManager.dbClose(con, null);
		}
	}
	/**
	 * 출금
	 * update bank set balance=balane-인출금액 where account = 출금계좌번호;
	 */
	public int withdraw(Connection con, String outputAccount, int money) throws SQLException{
		PreparedStatement ps = null;
		String sql = "update bank set balance=balance-? where account = ?";
		int result = 0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2,outputAccount);
			result = ps.executeUpdate();
			System.out.println(result);
		} finally {
			DbManager.dbClose(null, ps);
		}
		return result;
	}
	/**
	 * 입금	
	 * update bank set balance=balance+인출금액 where account =입금계좌번호;
	 * @throws SQLException 
	 */
	public int deposit(Connection con, String inputAccount, int money) throws SQLException {
		PreparedStatement ps = null;
		String sql = "update bank set balance=balance+? where account = ?";
		int result = 0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, inputAccount);
			result = ps.executeUpdate();
			
		} finally {
			DbManager.dbClose(null, ps);
		}
		return result;
	}
	/**
	 * 잔액조회
	 * select balance from bank where account='A02';
	 * @return: boolean
	 * 			true면 잔액초과, false 잔액초과 아님
	 */
	public boolean balanceCheck(Connection con, String checkAccount) throws SQLException {
		PreparedStatement ps= null;
		ResultSet rs = null;
		String sql = "select balance from bank where account=?";
		boolean result=false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, checkAccount);
			rs = ps.executeQuery();
			if(rs.next()) {
				int balance = rs.getInt(1);
				if(balance>=1000) result =  true;
			}
			
		} finally {
			DbManager.dbClose(null, ps, rs);
		}
		return result;
	}
	
	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
//		System.out.println("--1. 출금계좌 오류----");
//		dao.transfer("A02", "A01",100);//입금, 출금, 금액
		
		System.out.println("--2. 입금계좌 오류----");
		dao.transfer("A01", "A01",200);//입금, 출금, 금액
		
		
//		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		//dao.transfer("A02", "A01",700);//입금, 출금, 금액
		
//		System.out.println("--4. 성공----------");
//		dao.transfer("A02", "A01",100);//입금, 출금, 금액
	}
}











