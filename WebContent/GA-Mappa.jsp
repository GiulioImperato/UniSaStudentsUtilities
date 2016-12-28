<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,gestioneUtente.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null) {
		// SIMULA LA SESSIONE
		//utente = new Utente("a","a","a","a",true,true);

	} else {

	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>Student Utilities</title>

  <%@ include file="-UPimport.html"%>
  
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAd1SnqQOoCKVRD8zVyiNYEttyPnxQSMnw&callback=initMap" 
          type="text/javascript"></script>
  <script src="js/MapsAPI.js" type="text/javascript"></script>
  <style>
  		body{
  			overflow-x:hidden;
  			overflow-y:hidden;
  		}
       #map {
       		width:100% !important; 
<<<<<<< HEAD
			height:89% !important;
=======
			height:100% !important;
>>>>>>> refs/remotes/origin/Pasquale
			top:0px !important; 
			left:0px !important; 
			position: fixed !important;
       }
    </style>
</head>
<body>
  <div class="topbar animated fadeInLeftBig"></div>
 	
	<%@ include file="-menuLogged.html"%>


  <!-- works -->

  <div id="works"  class=" clearfix grid">
    <div class="container col-lg-8 col-md-offset-2">
      	<div id="map"></div>
      	<iframe
  			width="600"
  			height="450"
  			frameborder="0" style="border:0"
  			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAd1SnqQOoCKVRD8zVyiNYEttyPnxQSMnw&callback=initMap" onload="initMap();" allowfullscreen>
			</iframe>
    </div>
   </div>
   
   <!--Contact Starts-->
	<div id="contact" class="spacer">


	</div>
<!--Contact Ends-->

	<!-- works -->
	<%@ include file="-footer.html"%>

<<<<<<< HEAD
	<%@ include file="-DOWNimport.html"%>
=======
	
>>>>>>> refs/remotes/origin/Pasquale
</body>
</html>