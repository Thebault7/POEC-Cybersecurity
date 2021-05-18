package fr.bufalo.acme.utils.validation;

/**
 * Interface regrouping methods used to check if strings given by a user
 * are valid and do not contain unwanted characters.
 * 
 * @date Created 17/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public interface StringValidationInterface {

	public boolean validationString(String string, ValidationType type);
}
