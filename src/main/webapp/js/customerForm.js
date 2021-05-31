/**
 * Created 23 Mai 2021
 * Author Frederic Thebault
 * Version 1.0
 */


//--------------------------------Global variables-----------------------------------------
var postalCodeId = 0;
var cityId = 0;
var cityName = "";
var countryEnumValue = "";

//--------------------------------Show postal code if there is one-----------------------------------------
//document.getElementById("postalCodeID").value = 
var test = '${postalCode}';
console.log(test);

//--------------------------------Starting listener-----------------------------------------
addListenerPostalCode();

function addListenerPostalCode() {
	var postalCodeID = document.getElementById("postalCodeID");
	postalCodeID.addEventListener("input", function() {
		var numberEntered = postalCodeID.value;
		if (numberEntered.length > 2) {
			loadPostalCodes(numberEntered);
		}
	});
}

//--------------------------------Send JSON request-----------------------------------------
function loadPostalCodes(numberEntered) {
	var url = "http://localhost:8080/searchPostalCodes/"
		+ numberEntered;
	var cityRequest = new XMLHttpRequest();
	cityRequest.open('GET', url);
	cityRequest.onload = function() {
		if (cityRequest.status >= 200 && cityRequest.status < 400) {
			var cityData = JSON.parse(cityRequest.responseText);
			renderHTML(cityData);
		} else {
			document.getElementById("showListCities").innerHTML = "<p><strong>No city found</strong></p>";
		};
	};
	cityRequest.onerror = function() {
		alert("Error, server doesn't answer back");
	};
	cityRequest.send(numberEntered);
}

//--------------------------------Show result from JSON request-----------------------------------------
function renderHTML(data) {
	var showListCities = document.getElementById("showListCities");
	if (data["result"] === null) {
		showListCities.innerHTML = "<p><strong>" + data["message"]
			+ "</strong></p>";
	}
	if (data["result"] !== null) {
		var stringHTMLAddresses = "<ul>";
		for (i = 0; i < data["result"][0]["listCities"].length; i++) {
			stringHTMLAddresses += "<li><p><a href='javascript:showSelectedCity("
				+ data["result"][0]["listCities"][i]["id"]
				+ ", &quot;"
				+ data["result"][0]["listCities"][i]["name"]
				+ "&quot;, &quot;"
				+ data["result"][0]["listCities"][i]["countryEnum"]
				+ "&quot;)'>"
				+ data["result"][0]["listCities"][i]["name"]
				+ "</a></p></li>";
		}
		stringHTMLAddresses += "</ul>";
		showListCities.innerHTML = stringHTMLAddresses;

		document.getElementById("postalCodeIdField").value = data["result"][0]["id"];
	}
}

function showSelectedCity(id, name, countryEnum) {
	var showSelectedCity = document.getElementById("showSelectedCity");
	showSelectedCity.innerHTML = "<p>" + name + ", " + countryEnum + "</p>";

	document.getElementById("cityIdField").value = id;
	document.getElementById("cityNameField").value = name;
	document.getElementById("countryField").value = countryEnum;
}

//--------------------------------Generate birthdate-----------------------------------------
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

	if (month != "--Select--") {
		document.getElementById("birthdateInputField").value = year + "-" + month + "-" + day;
	}
}