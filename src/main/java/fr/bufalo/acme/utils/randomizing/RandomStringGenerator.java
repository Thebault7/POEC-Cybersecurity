package fr.bufalo.acme.utils.randomizing;

import java.util.Random;

import fr.bufalo.acme.exception.NegativeValueException;

/**
 * @date Created 11/05/2021
 * @author Frederic Thebault
 * @version 1.0
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
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder(nbOfCharacters);
	    
	    // A random number between 0 and 0.99999.... is generated, then converted between 97 and 122,
	    // converted into a letter, then added to a string using a StringBuilder
	    for (int i = 0; i < nbOfCharacters; i++) {
	        int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
	        sb.append((char) randomLimitedInt);
	    }
	    return sb.toString();
	}
}
