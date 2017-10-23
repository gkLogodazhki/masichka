function refreshSecurityCode(){
	$.get("http://localhost:8080/masichka/SecurityCode"
			,function(data){
		console.log(data);
		$('#code-generator').html(data);
	});
};
