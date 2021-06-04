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
		for (j = 0; j < data["result"].length; j++) {
			for (i = 0; i < data["result"][j]["listCities"].length; i++) {
				stringHTMLAddresses += "<li><p><a href='javascript:showSelectedCity("
					+ data["result"][j]["listCities"][i]["id"]
					+ ", &quot;"
					+ data["result"][j]["listCities"][i]["name"]
					+ "&quot;, &quot;"
					+ data["result"][j]["listCities"][i]["countryEnum"]
					+ "&quot;, &quot;"
					+ data["result"][j]["number"]
					+ "&quot;)'>"
					+ data["result"][j]["listCities"][i]["name"]
					+ "</a></p></li>";
			}
		}

		stringHTMLAddresses += "</ul>";
		showListCities.innerHTML = stringHTMLAddresses;

		document.getElementById("postalCodeIdField").value = data["result"][0]["id"];
	}
}

function showSelectedCity(id, name, countryEnum, postalCode) {
	var showSelectedCity = document.getElementById("showSelectedCity");
	showSelectedCity.innerHTML = "<p>" + name + ", " + countryEnum + "</p>";

	document.getElementById("cityIdField").value = id;
	document.getElementById("cityNameField").value = name;
	document.getElementById("countryField").value = countryEnum;
	document.getElementById("postalCodeID").value = postalCode;
	document.getElementById("showListCities").innerHTML = "";
}