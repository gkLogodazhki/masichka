function checkConfirmPassword(){
	var password = $('#user_password').val();
	var confirmPassword = $('#confirmPassword');
	if(password.length  >= 6 || confirmPassword.val() >= 6){
		var flag = password === confirmPassword.val();
		if(flag){
			$(confirmPassword).css('border','2px solid green')
			$(confirmPassword).css('box-shadow','3px solid green')
			
		}
		else{
			$(confirmPassword).css('border','2px solid red')
			$(confirmPassword).css('box-shadow','3px solid red')
			
		}
			
	}
};