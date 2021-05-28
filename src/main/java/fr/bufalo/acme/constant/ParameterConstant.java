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
	EDIT_CUSTOMER ("editCustomer"),
	LIST_CUSTOMERS ("listCustomers"),
	ADD_CUSTOMER ("addCustomer"),
	MODIFY_CUSTOMER ("modifyCustomer"),
	SEARCH_CUSTOMER ("searchCustomer"),
	CHECK_ADD_CUSTOMER ("checkAddCustomer");

	private String parameterName;
	
	ParameterConstant (String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getParameterName() {
		return parameterName;
	}
}
