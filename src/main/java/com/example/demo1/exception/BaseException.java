package com.example.demo1.exception;


/** 
 * @Description: 签名CHECK异常
 * @ClassName: SignCheckException 
 * @author
 * @date
 */
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = -105500584464532362L;
	
	public BaseException(String errorCode, Throwable message) {
		super(errorCode, message);
	}
	public BaseException(String message) {
		super(message);
	}
	public BaseException() {
		super();
	}
}
