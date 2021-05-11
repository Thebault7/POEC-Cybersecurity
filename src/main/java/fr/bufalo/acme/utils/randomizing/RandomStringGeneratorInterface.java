package fr.bufalo.acme.utils.randomizing;

import fr.bufalo.acme.exception.NegativeValueException;

public interface RandomStringGeneratorInterface {

	public String randomStringGenerator(int nbOfCharacters) throws NegativeValueException;
}
