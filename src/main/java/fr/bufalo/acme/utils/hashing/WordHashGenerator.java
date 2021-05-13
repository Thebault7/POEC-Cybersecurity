package fr.bufalo.acme.utils.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @date Created 11/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public class WordHashGenerator implements WordHashGeneratorInterface {

	/**
	 * A method that hashes a string using a specified hashing logarithm, collects the characters
	 * inside an array and finally the new string with a StringBuilder.
	 * 
	 * @param wordToBeHashed is the string that needs to be hashed.
	 * @param hashLogarithm  is the name of the logarithm.
	 * @return the digest of the original string.
	 * @throws NoSuchAlgorithmException when hashLogarithm does not correspond to any hashing logarithm.
	 */
	@Override
	public String generateHash(String wordToBeHashed, String hashLogarithm) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(hashLogarithm);
		byte[] hashedTab = md.digest(wordToBeHashed.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hashedTab.length; i++) {
			sb.append(Integer.toString((hashedTab[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
