package fr.bufalo.acme.exception;


/**
* Throws an exception when a number value is negative, but shouldn't be
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
