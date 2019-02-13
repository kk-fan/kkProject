package com.example.demo1.exception;


/** 
 * @Description: 签名CHECK异常
 * @ClassName: SignCheckException 
 * @author
 * @date
 */
public class BaseMsgException extends RuntimeException {
	private static final long serialVersionUID = -105500584464532362L;
	
	public BaseMsgException(String message) {
		super(message);
	}
	public BaseMsgException() {
		super();
	}
}
