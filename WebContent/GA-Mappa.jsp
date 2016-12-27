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
       #map {
       		width:100% !important; 
			height:100% !important;
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
    		<script>initMap()</script>
    </div>
   </div>

	<!-- works -->

	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>
	
</body>
</html>