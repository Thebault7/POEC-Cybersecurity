package fr.bufalo.acme.utils.hashing;

import java.security.NoSuchAlgorithmException;

/**
 * @date Created 11/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
public interface WordHashGeneratorInterface {

	public String generateHash(String wordToBeHashed, String hashLogarithm) throws NoSuchAlgorithmException;
}
