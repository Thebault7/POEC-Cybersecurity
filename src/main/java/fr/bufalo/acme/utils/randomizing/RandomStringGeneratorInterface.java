package fr.bufalo.acme.utils.randomizing;

import fr.bufalo.acme.exception.NegativeValueException;

/**
 * @date Created 11/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
public interface RandomStringGeneratorInterface {

	public String randomStringGenerator(int nbOfCharacters) throws NegativeValueException;
}
