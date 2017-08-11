function removeDuplicates() {
	var str = document.getElementById("input").value.trim();
	var previousPosition = 0;
	var currentPosition = 0;
	var currentLength = 0;
	var result = str;
	//if input string is empty
	if (str.length == 0) {
		result = "Empty:Insert an element";
	} else {
		while (currentPosition < str.length) {
			if (str.charAt(previousPosition) == str.charAt(currentPosition)) {
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
			document.getElementById("input").value = "";
	}
	//Display result to user
	document.getElementById("input").focus();
	document.getElementById("result").innerHTML = result;
	
}

window.onload = function(){
	document.getElementById("remove").addEventListener("click",removeDuplicates);
}