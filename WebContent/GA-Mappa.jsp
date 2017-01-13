<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,gestioneUtente.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");
	
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
			height:89% !important;
			top:0px !important; 
			left:0px !important; 
			position: fixed !important;
       }
    </style>
</head>
<body>
  <div class="topbar animated fadeInLeftBig"></div>
 	
	<%
		if (utente != null) {
	%>
	<%@ include file="-menuLogged.html"%>

	<%
		} else {
	%>

	<%@ include file="-menu.html"%>

	<%
		}
	%>


  <!-- works -->

  <div id="works"  class=" clearfix grid">
    <div class="container col-lg-8 col-md-offset-2">
      	<!-- LOADING GIF -->
                	<div id="hidepage" style="position: absolute; 
					left:0px; top:0px; background-color: #FFFFF; height: 100%; width: 100%; visibility:hidden"> 
						<table width="100%" height="100%"><tr><td align="center" valign="middle"> 
						<table width="100%" align="center"><tr><td align="center" class="row1"> 
						<p><img src="images/loading.png"></p>
						</td></tr></table> 
						</td></tr></table>
					</div>
        <!-- END LOADING GIF -->
      	<div id="map"></div>
      	<script>getXmlHttpRequestObject2()</script>			<!-- Verifica compatibilità del browser -->
      	<script>alterContent2()</script>
      	<iframe
  			width="600"
  			height="450"
  			frameborder="0" style="border:0"    
  			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAd1SnqQOoCKVRD8zVyiNYEttyPnxQSMnw&callback=initMap" onload="costruzioneMappa();" allowfullscreen>
			</iframe>
    </div>
   </div>
   
      <input type="text" id="user" value="${user.email}" style="visibility:hidden;"></input>
   <!--Contact Starts-->
	<div id="contact" class="spacer">


	</div>
<!--Contact Ends-->

	<!-- works -->
	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>
</body>
</html>