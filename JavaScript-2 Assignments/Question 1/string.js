function removeDuplicates() {
	var inputBox = document.getElementById("input");
	var str = inputBox.value.trim();
	var previousPosition = 0;
	var currentPosition = 0;
	var currentLength = 0;
	var result = str;
	var originalString = str;
	//if input string is empty

	if (str.length != 0) {
		while (currentPosition < str.length) {
			if (str.charAt(previousPosition) === str.charAt(currentPosition)) {
				//On finding same character
				currentPosition++;
				currentLength++;
			} else if (currentLength > 1) {
				str = str.slice(0, previousPosition) + str.slice(currentPosition);
				result += "->" + str;
				previousPosition = 0;
				currentPosition = 0;
				currentLength = 0;
			} else {
				//If same characters are not found
				previousPosition = currentPosition;
				currentLength = 0;
			}
		}
		if (currentLength > 1) {
			str = str.slice(0, previousPosition) + str.slice(currentPosition, str.length);
			result += "->" + str;
		}
		if (str.length == 0) {
			result += " EMPTY";
		}
		if (str == result) {
			result = "No Duplicates Elements";
		}
		inputBox.value = "";
		inputBox.placeholder = originalString;
	} else {
		result = "Empty:Insert an element";
	}
	//Display result to user
	inputBox.focus();
	document.getElementById("result").innerHTML = result;
}

window.onload = function () {
	document.getElementById("remove").addEventListener("click", removeDuplicates);
}