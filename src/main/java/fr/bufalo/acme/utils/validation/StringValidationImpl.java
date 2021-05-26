package fr.bufalo.acme.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public class StringValidationImpl implements StringValidationInterface {
	
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private static final String REFERENCE = "^[a-zA-Z0-9-]{1,12}$";
	private static final String PASSWORD = "^[a-zA-Z0-9,?;.:/!]{8,}$";
	private static final String PHONE_NUMBER = "^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$";
	private static final String NAME = "^[a-zA-Zאגהיטךכןמפצשûüח]+(([',. -][a-zA-Zאגהיטךכןמפצשûüח ])?[a-zA-Zאגהיטךכןמפצשûüח]*)*$";
	private static final String ADDRESS = "^[0-9]{0,3}(([,. ]?){1}[a-zA-Zאגהיטךכןמפצשûüח'-]+)*$";
	private static final String POSTAL_CODE = "^[0-9]{5,7}$";
	private static final String DATE = "^[1-2]{1}[0-9]{3}[-\\/][0-1]{1}[0-9]{1}[-\\/][0-3]{1}[0-9]{1}$";
	
	/**
	 * Method the checks if a given string is valid according to a regex.
	 * The selected regex is different depending upon the type of validation.
	 * 
	 * For reference, it corresponds to 1 to 12 alphanumerical characters.
	 * 
	 * For passwords, it corresponds to at least 8 alphanumerical or punctiation characters.
	 * 
	 * @param string to be validated
	 * @param type of validation
	 * @return true if the string satifies the regex, false otherwise
	 */
	@Override
	public boolean validationString(String string, ValidationType type) {
		String regexString = "";
		switch (type) {
		case EMAIL:
			regexString = EMAIL_REGEX;
			break;
		case REFERENCE:
			regexString = REFERENCE;
			break;
		case PASSWORD:
			regexString = PASSWORD;
			break;
		case PHONE_NUMBER:
			regexString = PHONE_NUMBER;
			break;
		case NAME:
			regexString = NAME;
			break;
		case ADDRESS:
			regexString = ADDRESS;
			break;
		case POSTAL_CODE:
			regexString = POSTAL_CODE;
			break;
		case DATE:
			regexString = DATE;
			break;
		default:
			return false;
		}
		
		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher(string);
		
		if (matcher.find()) {
			return true;
		}
		return false;
	}
}
