function initMap(){
	var options = {
			zoom:12,
			center:{lat:42.69751,lng:23.32415}	
	};
	var map = new google.maps.Map(document.getElementById('map'),options);
	
	var marker = new google.maps.Marker({
		position:{lat:42.6, lng:23.03333},
		map:map,
		icon:'http://i.imgur.com/xNLs83T.png'
	});
	
	var infoWindow = new google.maps.InfoWindow({
		content:'<h1>Enemy team double kill</h1>'
	});
	
	marker.addListener('click', function(){
		infoWindow.open(map,marker);
	});
	
};