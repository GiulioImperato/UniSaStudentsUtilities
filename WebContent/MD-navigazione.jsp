<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	
   Utente utente = (Utente)session.getAttribute("utente");
        if(utente==null){
        	// SIMULA LA SESSIONE
        	//utente = new Utente("a","a","a","a",true,true);
     
     }
     else{
    	 
     }	
			
        
			
    	 %>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Student Utilities</title>


<%@ include file="-UPimport.html"%>
</head>

<body>
	<div class="topbar animated fadeInLeftBig"></div>


	<%if(utente != null)  { %>
	<%@ include file="-menuLogged.html"%>

	<% }  else  {%>

	<%@ include file="-menu.html"%>

	<% }%>



	<!-- works -->
	<div id="works" class=" clearfix grid">
		<div class="container col-lg-8 col-md-offset-2">
			<h2 style="text-align: left;">Corsi di laurea</h2>
			<a href="MD-DownloadUpload.jsp"><h2 style="text-align: left;">tabella materiale(esempio prova)</h2></a>
			<hr>
			<!-- ListaCorsi -->
			<ul class="list-unstyled">
				<c:forEach var="item"  items="${requestScope.folderArray}">
					<a href="GestoreRicerca?folderClicked=${item.nome}"><li class="well">${item.nome}</li></a>
				</c:forEach>
				<c:remove var="item" />
			</ul>
			<!-- /ListaCorsi -->
		</div>
	</div>
	<!-- works -->





	<%@ include file="-footer.html"%>
	<%@ include file="-DOWNimport.html"%>


</body>
</html>
