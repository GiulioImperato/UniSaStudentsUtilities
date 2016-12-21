var map;
function initMap() {
	var locations = [
	                 ['F1',40.77462, 14.78981],
	                 ['F2',40.77455, 14.78987]
	                 ];

	map = new google.maps.Map(document.getElementById('map'), {
		zoom: 20,
		center: new google.maps.LatLng(40.77469, 14.78922),
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	
	var contentString = '10:00-12:00';
	
	var infowindow = new google.maps.InfoWindow({});

	var marker, i, j;
	var icon_green = {
			url :'images/green-circle-hi.png',
			scaledSize: new google.maps.Size(30, 30)
	};

	for (i = 0; i < locations.length; i++) {  
		marker = new google.maps.Marker({
			position: new google.maps.LatLng(locations[i][1], locations[i][2]),
			map: map,
			icon: {
				url: "images/redbutton-hi.png",
				scaledSize: new google.maps.Size(30, 30)
			}
		});
		google.maps.event.addListener(marker, 'click', (function(marker, i) {
			return function() {
				infowindow.setContent(locations[i][0]+" "+contentString);
				marker.setIcon(icon_green);
				infowindow.open(map, marker);
			}
		})(marker, i));	
	}
}