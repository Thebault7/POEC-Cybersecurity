package fr.bufalo.acme.constant;

/**
 * @Created 26/05/2021
 * @author Frederic Thebault
 * @version 1.0
 */
public enum ParameterConstant {

	LOGIN ("login"),
	CHECK_LOGIN ("checkLogin"),
	EMPLOYEE ("Employee"),
	ERROR_MESSAGE ("errorMessage"),
	SESSION_EMPLOYEE ("sessionEmployee"),
	STAT_PAGE ("statPage"),
	MANAGE_CUSTOMERS ("manageCustomers"),
	CUSTOMER ("customer"),
	VIEW_CUSTOMER ("viewCustomer"),
	LIST_CUSTOMERS ("listCustomers"),
	ADD_CUSTOMER ("addCustomer"),
	MODIFY_CUSTOMER ("modifyCustomer"),
	SEARCH_CUSTOMER ("searchCustomer"),
	CHECK_ADD_CUSTOMER ("checkAddCustomer"),
	CITY_NAME ("cityName"),
	POSTAL_CODE ("postalCode"),
	LIST_EMPLOYEE ("listEmployee"),
	NOT_MENTIONED ("Non renseigné"),
	PIE_CHART_STRING ("pieChartString"),
	// regex below :
	EMAIL_REGEX ("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$"),
	REFERENCE_REGEX ("^[a-zA-Z0-9-]{1,12}$"),
	PASSWORD_REGEX ("^[a-zA-Z0-9,?;.:/!]{8,}$"),
	PHONE_NUMBER_REGEX ("^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$"),
	NAME_REGEX ("^[a-zA-Zàâäéèêëïîôöùûüç]+(([',. -][a-zA-Zàâäéèêëïîôöùûüç ])?[a-zA-Zàâäéèêëïîôöùûüç]*)*$"),
	ADDRESS_REGEX ("^[0-9]{0,3}(([,. ]?){1}[a-zA-Z0-9àâäéèêëïîôöùûüç'-]+)*$"),
	POSTAL_CODE_REGEX ("^[0-9]{5,7}$"),
	DATE_REGEX ("^[1-2]{1}[0-9]{3}[-\\/][0-1]{1}[0-9]{1}[-\\/][0-3]{1}[0-9]{1}$");

	private String parameterName;

	ParameterConstant (String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterName() {
		return parameterName;
	}
}
