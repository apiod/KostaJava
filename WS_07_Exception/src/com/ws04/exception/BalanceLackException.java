package com.ws04.exception;

public class BalanceLackException extends Exception{
	public BalanceLackException() {}
	public BalanceLackException (String message) {
		super(message);
	}
}
