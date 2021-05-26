package fr.bufalo.acme.constant;

/**
 * @Created 26/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
public enum ErrorConstant {

	INVALID_CONNECTION ("Identifier or password invalid"),
	INVALID_HASHING ("Error in the hashing configuration"),
	INEXISTING_DATE ("- The birthdate is not an existing date<br>"),
	INVALID_CHARACTER_IN_ADDRESS ("- The address writen contains invalid characters<br>"),
	INVALID_EMAIL ("- The email writen is not valid<br>"),
	INVALID_CHARACTER_IN_FIRSTNAME ("- The firstname writen contains invalid characters<br>"),
	INVALID_CHARACTER_IN_LASTNAME ("- The lastname writen contains invalid characters<br>"),
	EMPTY_NAMES ("- Firstname and lastname must be filled<br>"),
	INVALID_PHONE_NUMBER ("- The phone number is not valid<br>"),
	INVALID_BIRTHDATE ("- The birthdate is not valid<br>"),
	BIRTHDATE_IN_FUTURE ("- The birthdate cannot be in the future<br>"),
	BIRTHDATE_TOO_FAR_IN_PAST ("- The birthdate cannot be more than 130 years in the past<br>");
	
	private String errorMessage;
	
	ErrorConstant (String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
