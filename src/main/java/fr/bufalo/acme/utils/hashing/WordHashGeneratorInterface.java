package fr.bufalo.acme.utils.hashing;

import java.security.NoSuchAlgorithmException;

public interface WordHashGeneratorInterface {

	public String generateHash(String wordToBeHashed, String hashLogarithm) throws NoSuchAlgorithmException;
}
