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
	STAT_PAGE ("statPage");

	private String parameterName;
	
	ParameterConstant (String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getParameterName() {
		return parameterName;
	}
}
