
window.onload = function(){
	document.getElementById('home').addEventListener("click",function(event){
		location.href = "home.html";
	});
	document.getElementById('contactus').addEventListener("click",function(event){
		location.href = "contactus.html";
		});
	document.getElementById("name").addEventListener("keyup",validateName);
    document.getElementById("email").addEventListener("keyup",validateEmail);
    document.getElementById("organization").addEventListener("keyup",validateOrganization);
	document.getElementById("contactnumber").addEventListener("keyup",validatePhoneNumber);
	document.getElementById("selectCity").addEventListener("change",cityOption);
    document.getElementById("message").addEventListener("keyup",validateTextArea);
	document.getElementById("myForm").addEventListener("submit",validateForm);
};

function validateName(){
	var x;
	document.getElementById("name").maxLength="20";
	var span=document.getElementById("name-warning");
	var flag=false;
	if ((x=document.forms['myForm']['name'].value )== ""){
		span.innerHTML="Empty : Write Something";
	}
	else if( !x.match( /^[a-zA-z]+$/)){
		span.innerHTML="Only Characters Allowed";	
	}
	else{
	span.innerHTML="";
	flag= true;
	}
	
	return flag;
}

function validateEmail(){
	var x;
	var span=document.getElementById("email-warning");
	var flag=false;	
	 if( (x=document.forms['myForm']['email'].value )== ""){
	 span.innerHTML="Empty : Write Something";
	}
	else if(!x.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		span.innerHTML="Enter Valid Email Address";
		}
	else{
	span.innerHTML="";
	flag= true;
	}
	
	return flag;
}

function validateOrganization(){
	var x;
	var span=document.getElementById("organization-warning");
	var flag=false;	
	if ((x=document.forms['myForm']['organization'].value )== ""){
		 span.innerHTML="Empty : Write Something";
	}
	else if( !x.match( /^[a-zA-z]+$/) ){
	span.innerHTML="Only Characters Allowed";
	}
	else{
	span.innerHTML="";
	flag= true;
	}
	
	return flag;
}

function validatePhoneNumber(){
	var x;
	var span=document.getElementById("phone-warning");
	var flag=false;	
	 if( (x=document.forms['myForm']['contactnumber'].value )== "" ){
	 	 span.innerHTML="Empty : Write Something";
	}
	else if( !x.match(/^[0-9]{6,12}$/) ){
		span.innerHTML="Only Number Allowed";
	}
	else{
		span.innerHTML="";
	flag= true;
	}	
	
	return flag;
}

function validateTextArea(){
	var msg = document.getElementById("message");
	msg.maxLength="250";
	var span=document.getElementById("text-warning");
	var flag=false;	
	 if(msg.value== ""){
	 	 span.innerHTML="Empty : Write Something";
	}
	else{
		span.innerHTML="";
	flag= true;
	}	
	
	return flag;
}

function cityOption(){
	var element = document.getElementById("selectCity");
	var selected =document.getElementById("selectedcity");
	selected.style.visibility="visible";
	var selectedValue =element.options[element.selectedIndex].value;
	if(selectedValue == "default"){
		element.style.border="2px solid red";
		selected.value="No option choosed";
	}
	else{
		element.style.removeProperty('border');
		selected.value="Selected :"+selectedValue;
	}
}

function validateForm(){
	if(validateName()===false ||validateEmail()===false || validateOrganization()===false
		|| validateTextArea()===false || validatePhoneNumber()===false){
		event.preventDefault();
		validateName();
		validateEmail();
		validateOrganization();
		validatePhoneNumber();
		validateTextArea();
		cityOption();
		
		return false;
	}
}





