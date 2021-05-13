package fr.bufalo.acme.exception;


/**
* Throws an exception when a given number value is negative, but shouldn't be.
* 
* @date Created 11/05/2021
* @author Frederic Thebault
* @version 1.0
* 
*/
public class NegativeValueException extends Exception {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	
	public NegativeValueException() {
		super();
	}
	
	public NegativeValueException(String message) {
		super(message);
	}
	
	public NegativeValueException(String message, Throwable cause) {
		super(message, cause);
	}
}
