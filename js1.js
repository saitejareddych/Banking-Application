
    function Validate() {
        var password = document.getElementById("newPassword").value;
        var confirmPassword = document.getElementById("confirmNewPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }	
    function IsEmpty(){ 

    	if(document.form.question.value == "")
    	{
    	alert("empty");
    	}
    	    return;
    	}
