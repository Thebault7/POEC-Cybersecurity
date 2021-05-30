package fr.bufalo.acme.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.bufalo.acme.constant.ParameterConstant;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
public class StringValidationImpl implements StringValidationInterface {
	
	private static final String EMAIL_REGEX = ParameterConstant.EMAIL_REGEX.getParameterName();
	private static final String REFERENCE_REGEX = ParameterConstant.REFERENCE_REGEX.getParameterName();
	private static final String PASSWORD_REGEX = ParameterConstant.PASSWORD_REGEX.getParameterName();
	private static final String PHONE_NUMBER_REGEX = ParameterConstant.PHONE_NUMBER_REGEX.getParameterName();
	private static final String NAME_REGEX = ParameterConstant.NAME_REGEX.getParameterName();
	private static final String ADDRESS_REGEX = ParameterConstant.ADDRESS_REGEX.getParameterName();
	private static final String POSTAL_CODE_REGEX = ParameterConstant.POSTAL_CODE_REGEX.getParameterName();
	private static final String DATE_REGEX = ParameterConstant.DATE_REGEX.getParameterName();
	
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
			regexString = REFERENCE_REGEX;
			break;
		case PASSWORD:
			regexString = PASSWORD_REGEX;
			break;
		case PHONE_NUMBER:
			regexString = PHONE_NUMBER_REGEX;
			break;
		case NAME:
			regexString = NAME_REGEX;
			break;
		case ADDRESS:
			regexString = ADDRESS_REGEX;
			break;
		case POSTAL_CODE:
			regexString = POSTAL_CODE_REGEX;
			break;
		case DATE:
			regexString = DATE_REGEX;
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
