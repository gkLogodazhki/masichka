function refreshSecurityCode(){
	$.get("http://localhost:8080/masichka/SecurityCode"
			,function(data){
		$('#code-generator').html(data);
	});
};

function isCorrectSecurityCode(){
	var $input = $("[name='userSecutityCode']").val();
	if($input.length === 8){
		var $security = $('#code-generator').html();
		$.get("http://localhost:8080/masichka/CheckSecurityCode?securityCode="
				+ $security + "&input=" + $input ,function(data){
			$('#security-code-message').css("display","inline-block");
			if(data){
				$('#security-code-message').addClass('glyphicon glyphicon-ok');
			}
			else{
				$('#security-code-message').addClass('glyphicon glyphicon-remove');
			}
		});
	}else{
		$('#security-code-message').css("display","none");
		$('#security-code-message').removeClass();
	}
	
}
