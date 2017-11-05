function initMap(){
	var options = {
			zoom:15,
			center:{lat:42.664141,lng:23.287983}	
	};
	var map = new google.maps.Map(document.getElementById('map'),options);
	
	var marker = new google.maps.Marker({
		position:{lat:42.664141,lng:23.287983},
		map:map,
		//icon:'http://i.imgur.com/xNLs83T.png'
	});
	
	var infoWindow = new google.maps.InfoWindow({
		content:'<h1>Enemy team double kill</h1>'
	});
	
	marker.addListener('click', function(){
		infoWindow.open(map,marker);
	});
	
};