/**
 * 
 */
package com.project.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseException.
 */
public class BaseException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new base exception.
	 *
	 * @param exception the exception
	 */
	public BaseException(String exception) {
		super(exception);
	}
	
	/**
	 * Instantiates a new base exception.
	 *
	 * @param exception the exception
	 * @param cause the cause
	 */
	public BaseException(String exception, Throwable cause) {
		super(exception, cause);
	}
}
