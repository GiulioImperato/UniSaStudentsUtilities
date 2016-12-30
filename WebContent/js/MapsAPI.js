
//Gets the browser specific XmlHttpRequest Object
function getXmlHttpRequestObject2() {

	if (window.XMLHttpRequest) {
		return new XMLHttpRequest(); //To support the browsers IE7+, Firefox, Chrome, Opera, Safari
	} 
	else if(window.ActiveXObject) {
		return new ActiveXObject("Microsoft.XMLHTTP"); // For the browsers IE6, IE5
	} 
	else {
		alert("Error due to old verion of browser upgrade your browser");
	}
}

//Store the browser specific XmlHttpRequest Object in a variable
var rcvReq2 = getXmlHttpRequestObject2();

//Gets the current messages from the server
function alterContent2() {
	if (rcvReq2.readyState == 4 || rcvReq2.readyState == 0) {			//Se l'operazione è stata caricata oppure l'oggetto esiste ma ancora non è stato richiamato

//		The servlet url is GestoreAuleServlet as configured in the XML file
		rcvReq2.open("GET", "gestoreAule?azione=visualizzaMappa", true);
		rcvReq2.onreadystatechange = handleAlterContent2; 
		rcvReq2.send("null");
	} 
}

//Function for handling the return of servlet data

var map;
function handleAlterContent2() {
	if (rcvReq2.readyState == 4) {

		var responseTextVar = rcvReq2.responseText;				//Stringa ricevuta dalla servlet
		console.log(responseTextVar);

//		-------------------------------------------------------// Ajax code end

//		-------------------------------------------------------// Google map code


		map = new google.maps.Map(document.getElementById('map'), {
			zoom: 19,
			center: new google.maps.LatLng(40.77469, 14.78922),
			mapTypeId: google.maps.MapTypeId.ROADMAP
		});

		

		var contentString = '10:00-12:00';

		var infowindow = new google.maps.InfoWindow({});

		var nome = responseTextVar.split(' ');
		nome.splice(0,31);				//Divisione dell'array, prendendo solo il nome delle aule
		console.log(nome);
		var a = nome;
		console.log(a);
		
		var marker, i, j;
		var icon_green = {
				url :'images/green-circle-hi.png',
				scaledSize: new google.maps.Size(30, 30)
		};

		var lat = new Array();
		var lng = new Array();

//		Script load coordinates and name of the Aule on the map
		for (i = 0; i<=30; i++) {
			var aule = a[i];
			item=responseTextVar.split(' ');
			item = item[i].split(',');
			lat[i] =item[0];
			lng[i] = item[1];
			marker = new google.maps.Marker({
				position: new google.maps.LatLng(lat[i], lng[i]),
				map: map,
				title : aule,
				icon: {
					url: "images/redbutton-hi.png",
					scaledSize: new google.maps.Size(30, 30)
				}
			});
			google.maps.event.addListener(marker, 'click', (function(marker, i) {
				return function() {
					infowindow.setContent(this.title+" "+contentString);
					marker.setIcon(icon_green);
					infowindow.open(map, this);
				}
			})(marker, i));	
		}
	}
}
//Load function
google.maps.event.addDomListener(window, 'load', handleAlterContent2);

