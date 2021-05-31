package fr.bufalo.acme.utils.reference;

/**
 * Enumerates the different java beans that have
 * a reference as an attribute.
 * 
 * @date Created 25/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public enum ReferenceType {

	EMPLOYEE('E', "Employee"),
	CUSTOMER('C', "Customer"),
	ORDER('O', "Order"),
	PRODUCT('P', "Product");
	
	private char letter;
	private String className;
	
	private ReferenceType(char letter, String className) {
		this.letter = letter;
		this.className = className;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public String getClassName() {
		return className;
	}
}