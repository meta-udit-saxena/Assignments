  
window.onload = function() {
            document.getElementById("userName").addEventListener("keyup",checkNameIsValid);
            document.getElementById("userEmail").addEventListener("blur",checkEmailIsValid);
            document.getElementById("city").addEventListener("change",checkCityIsValid);
            document.getElementById("userOrganization").addEventListener("keyup",checkOrganizationNameisValid);
            document.getElementById("userContact").addEventListener("keyup",checkContactIsValid);
            document.getElementById("message").addEventListener("keyup",checktextAreaIsValid);
            document.getElementById("form").addEventListener("submit",checkValid);
}

function changePage(link){
    window.location.href=link;
}

function checkNameIsValid(){
    var name=document.getElementById("userName").value;
    var reg=new RegExp("^[a-zA-Z]+$");
    var result=reg.test(name);
    var span = document.getElementById("nameErrorMsg");
    var flag=false;
    if(name=="")
    {
        span.innerHTML="Please Enter some value!";
    }
    else if(result==false){
        span.innerHTML="Enter only alphabets no numeric allow!";
    }
    else if(name.length>20){
        span.innerHTML="only 20 characters allow!";
    }
    else{
        span.innerHTML="";
        flag=true;
    }
     return flag;
    
}
    function checkEmailIsValid(){
        var email=document.getElementById("userEmail").value;
        var reg=new RegExp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,3}$");
        var result=reg.test(email);
        var span = document.getElementById("emailErrorMsg");
       var flag=false;
    if(email=="")
    {
        span.innerHTML="Please Enter some value!";
    }
    else if(result==false){
        span.innerHTML="Please enter email in given format : abc@gmail.comm";
    }
    else{
        span.innerHTML="";
        flag=true;
    }
     return flag;
    }
    function checkCityIsValid(){
        var city=document.getElementById("city");
        var selectedCity=city.options[city.selectedIndex].value;
        var cityName=document.getElementById("selectedOption");
        cityName.style.display="inline";
        cityName.innerHTML="Udit";
            }

    function checkOrganizationNameisValid(){
        var organization=document.getElementById("userOrganization").value;
        var reg=new RegExp("^[a-zA-Z]+$");
        var result=reg.test(organization);
        var span=document.getElementById("organizationErrorMsg");
        var flag=false;
        if(organization==""){
            span.innerHTML="Please Enter some value!";
        }else if(result==false){
            span.innerHTML="Enter only alphabets no numeric allow!";
        }else{
            span.innerHTML="";
            flag=true;
        }
        return flag;
        }

    function checkContactIsValid(){
        var contact=document.getElementById("userContact").value;
        var reg=new RegExp("^[0-9]{6,13}$");
        var result=reg.test(contact);
        var span=document.getElementById("contactErrorMsg");
        var flag=false;
        if(contact==""){
             span.innerHTML="Please Enter some value!";
         }
        else if(result==false){
            span.innerHTML="Enter only numeric value range between 6-13";
        }else{
            span.innerHTML="";
            flag=true;
        }
        return flag;
        }

    function checktextAreaIsValid(){
        var message=document.getElementById("message").value;
        var span=document.getElementById("messageErrorMsg");
        var flag=false;
        if(message==""){
             span.innerHTML="Please Enter some value!";
         }
        else if(message.length>250){
            span.innerHTML="Maximum limit is 250 characters";
        }else{
            span.innerHTML="";
            flag=true;
        }
        return flag;
        
    }
    function checkValid(event){
        if(checkContactIsValid()===flase||checkEmailIsValid()===flase||checkNameIsValid()===flase||
            checkOrganizationNameisValid()===flase||checktextAreaIsValid()===flase){
            event.preventDefault();
            checkEmailIsValid();
            checkNameIsValid();
            checkOrganizationNameisValid();
            checktextAreaIsValid(); 
            checkContactIsValid();
            
            return false;
        }
       
      


    }
