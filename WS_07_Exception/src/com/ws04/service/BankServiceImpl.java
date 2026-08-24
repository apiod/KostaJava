package com.ws04.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ws04.dto.AccountDto;
import com.ws04.dto.InstallAccountDto;
import com.ws04.dto.LoanAccountDto;
import com.ws04.dto.SavingAccountDto;
import com.ws04.dto.UserDto;
import com.ws04.exception.BalanceLackException;
import com.ws04.exception.UserAccountNotFoundException;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

public class BankServiceImpl implements BankService{
	List<AccountDto> accountList = new ArrayList<>();
	List<UserDto> userList =new ArrayList<>();
	
    
	
	/**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankServiceImpl() {
		//배열 생성
//		 userList = new UserDto[USER_SIZE]; //5
//		 accountList = new AccountDto [ACCOUNT_SIZE]; //10
		
		// 각 배열방에 고객과 계좌를 생성한다.
		userList = new ArrayList<UserDto>(); 
		accountList = new ArrayList<AccountDto>(); 

		userList.add( new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false) );
		userList.add( new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true) );
		userList.add( new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false) );
		
		accountList.add( new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000) );
		accountList.add( new SavingAccountDto(10, "00100101001001", 500, 111, 100) );
		accountList.add( new LoanAccountDto(60, "00600606006006", 500, 333, "House") );
		accountList.add( new LoanAccountDto(30, "00300303003003", 0, 111, "Building") );
		accountList.add( new SavingAccountDto(70, "00700707007007", 500, 333, 200) );
		accountList.add( new LoanAccountDto(50, "00500505005005", 200, 222, "Car") );
		accountList.add( new SavingAccountDto(40, "00400404004004", 1000, 222, 50) );
	
		 
	}//생성자 끝
	
    /**
	  특정 사용자의 계좌 목록을 배열로 리턴 하는 메소드를 작성한다
	*/
	@Override
	public ArrayList<AccountDto> getAccountList(int userSeq) {
		ArrayList<AccountDto> aDtos=new ArrayList<>();
		for (AccountDto adtos: accountList) {
			if(adtos.getUserSeq()==userSeq) {
				aDtos.add(adtos);
			}
		}
		return aDtos;
	}
	@Override
	public ArrayList<AccountDto> getAccountList() {
		return (ArrayList<AccountDto>) accountList;
	}
	
	
	/**
	   특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
	   
	   @param : 고객의 sequence
	   @return : null이면 고객의정보없다 
	**/
	@Override
	public UserDto getUserDetail(int userSeq) {
		for(UserDto ud: userList) {
			if(ud.getUserSeq() == userSeq) {
				return ud;
			}
		}
//		for (int i=0;i<USER_CURRENT_SIZE;i++) {
//			if (userList[i].getUserSeq()==userSeq) {
//				return userList[i];
//			}
//		}
		return null;
	}
	/**
	 * 잔액기준으로 리스트 정렬
	 * @return
	 */
	@Override
	public ArrayList<AccountDto> getAccountListSortByBalance() {
		ArrayList<AccountDto> list =new ArrayList<>(accountList);
		Collections.sort(list);
		return list;
	}
	/**
	 * userSeq기준으로 리스트 정렬
	 * @return
	 */
	@Override
	public ArrayList<AccountDto> getAccountListSortByUserSeq() {
		ArrayList<AccountDto> list = new ArrayList<>(accountList);
		Collections.sort(list, (o1, o2)->o1.getUserSeq()-o2.getUserSeq());
		return list;
		
	}
	@Override
	public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {
		for(AccountDto aDto :accountList) {
			if(aDto.getUserSeq() == userSeq && aDto.getAccountSeq()==accountSeq) {
				return aDto;
			}
		}
		throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다.");
	}
	@Override
	public int withdraw(int userSeq, int accountSeq, int amount)
			throws BalanceLackException, UserAccountNotFoundException {
		AccountDto aDto = getUserAccount(userSeq, accountSeq);
		if(aDto.getBalance()<amount) {
			throw new BalanceLackException("잔액이 부족합니다.");
		}
		return aDto.getAccountSeq()-amount;
	}

}










