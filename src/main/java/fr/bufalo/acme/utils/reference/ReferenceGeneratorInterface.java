package fr.bufalo.acme.utils.reference;

/**
 * Interface used to generate a reference numbers
 * 
 * @date Created 25/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public interface ReferenceGeneratorInterface {

	/**
	 * @param type specifies for which java bean the reference is being
	 * 		generated
	 * @return the generated reference
	 */
	public String generateReference(ReferenceType type);
}
