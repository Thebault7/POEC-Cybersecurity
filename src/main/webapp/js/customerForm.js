/**
 * Created 23 Mai 2021
 * Author Frederic Thebault
 * Version 1.0
 */

function checkBirthdate() {
	var day = document.getElementById("selectedDay").options[document
		.getElementById("selectedDay").selectedIndex].text;
	var month = document.getElementById("selectedMonth").options[document
		.getElementById("selectedMonth").selectedIndex].text;
	var year = document.getElementById("selectedYear").options[document
		.getElementById("selectedYear").selectedIndex].text;
	if (month == "January") {
		month = "01";
	}
	if (month == "February") {
		month = "02";
	}
	if (month == "March") {
		month = "03";
	}
	if (month == "April") {
		month = "04";
	}
	if (month == "May") {
		month = "05";
	}
	if (month == "June") {
		month = "06";
	}
	if (month == "July") {
		month = "07";
	}
	if (month == "August") {
		month = "08";
	}
	if (month == "September") {
		month = "09";
	}
	if (month == "October") {
		month = "10";
	}
	if (month == "November") {
		month = "11";
	}
	if (month == "December") {
		month = "12";
	}
	if (day.length == 1) {
		day = "0" + day;
	}
	
	var formAddCustomer = document.getElementById("formAddCustomer");
	formAddCustomer.action = "checkAddCustomer?birthdateValue=" + year + "-" + month + "-" + day;
}