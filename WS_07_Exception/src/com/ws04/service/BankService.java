package com.ws04.service;

import java.util.ArrayList;

import com.ws04.dto.AccountDto;
import com.ws04.dto.UserDto;
import com.ws04.exception.BalanceLackException;
import com.ws04.exception.UserAccountNotFoundException;

public interface BankService {
	ArrayList<AccountDto> getAccountList(int userSeq);
	UserDto getUserDetail(int userSeq);
	ArrayList<AccountDto> getAccountList();
	ArrayList<AccountDto> getAccountListSortByBalance();
	ArrayList<AccountDto> getAccountListSortByUserSeq();
	AccountDto getUserAccount(int userSeq, int accountSeq) 
			throws UserAccountNotFoundException;
	int withdraw(int userSeq, int accountSeq, int amount) 
             throws BalanceLackException,  UserAccountNotFoundException;
}
