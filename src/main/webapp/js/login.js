// it hides the placeholder value when an input file is not empty

function verifyIfEmpty(id) {
			let inputZone = document.getElementById(id + "-input");
			let textZone = document.getElementById(id + "-text");
			if (!(inputZone.value.length == 0)) {
				textZone.style.display = "none";
			} else {
				textZone.style.display = "block";
			}
		};

verifyIfEmpty("email");