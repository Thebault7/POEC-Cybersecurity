package fr.bufalo.acme.exception;

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
