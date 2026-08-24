package com.ws04.service;

import java.util.List;

import com.ws04.dto.AccountDto;
import com.ws04.dto.UserDto;

public interface BankService {
	public abstract List<AccountDto> getAccountList(int userSeq);
	UserDto getUserDetail(int userSeq);
	List<AccountDto> getAccountList();
	List<AccountDto> getAccountListSortByBalance();
	List<AccountDto> getAccountListSortByUserSeq();
}
