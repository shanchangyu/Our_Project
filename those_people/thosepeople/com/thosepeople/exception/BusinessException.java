/**
 * 
 */
package com.thosepeople.exception;

/**
 * @author chenzhuo
 * 
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
