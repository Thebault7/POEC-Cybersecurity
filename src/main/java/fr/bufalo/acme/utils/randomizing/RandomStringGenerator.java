package fr.bufalo.acme.utils.randomizing;

import java.nio.charset.Charset;
import java.util.Random;

import fr.bufalo.acme.exception.NegativeValueException;

/**
 * Created 11/05/2021
 * 
 * @author Frederic Thebault
 *
 */
public class RandomStringGenerator implements RandomStringGeneratorInterface {

	/**
	 * A method that generates a random string, including non-alphanumeric characters.
	 * @param nbOfCharacters  Gives the length of the generated random string.
	 * @return a random string of characters encoded in UTF-8
	 * @throws NegativeValueException 
	 * 
	 */
	@Override
	public String randomStringGenerator(int nbOfCharacters) throws NegativeValueException {
		if (nbOfCharacters <= 0) {
			throw new NegativeValueException();
		}
		
		// Generates an array, fills it with characters, then return it as a string
		byte[] charTab = new byte[nbOfCharacters];
		new Random().nextBytes(charTab);
		return new String(charTab, Charset.forName("UTF-8"));
	}
}
