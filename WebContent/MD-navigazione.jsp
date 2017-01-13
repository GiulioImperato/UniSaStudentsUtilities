<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	
  String successivo= (String)request.getAttribute("tiposuccessivo"); 

  String home = (String)request.getAttribute("home");  
  String dip = (String)request.getAttribute("dip"); 
  String degree = (String)request.getAttribute("degree"); 
  String corso = (String)request.getAttribute("corso"); 
  String materiale = (String)request.getAttribute("materiale"); 


   Utente utente = (Utente)session.getAttribute("user");
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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

<%@ include file="-UPimport.html"%>


<script type="text/javascript">

/*
	function bredCrumbs(a){
	var b =a.getAttribute("id");
	var c = b.split("+");
	
	var d =document.getElementById(c[0]);
	d.innerHTML=c[1];
	$(d).css({"background":"red"});
	document.getElementById(c[0]).setAttribute("href","GestoreRicerca?typeClicked="+c[0]+"&folderClicked="+c[1]);
	
}*/
	
	$(document).ready(function() {  
		
		var dip = document.getElementById("department")
		var a = dip.childNodes[0].textContent;		
		if(a==""){
			$(dip).hide();
			
		}
		else{
			$(dip).show();
			
		}
		
		
		var degree = document.getElementById("degree");
		var b = degree.childNodes[0].textContent;		
		if(b==""){
			$(degree).hide();
		}
		else{
			$(degree).show();
		}
		
		
		var corso = document.getElementById("corso");
		var c = corso.childNodes[0].textContent;
		if(c==""){
			$(corso).hide();
		}
		else{
			$(corso).show();
		}
		
		var materiale = document.getElementById("materiale");
		var d =materiale.childNodes[0].textContent;
		if(d==""){
			$(materiale).hide();
		}
		else{
			$(materiale).show();
		}
		
		      });  
	
	
</script>

</head>

<body>
	<div class="topbar animated fadeInLeftBig"></div>


	<%if(utente != null)  { %>
	<%@ include file="-menuLogged.html"%>

	<% }  else  {%>

	<%@ include file="-menu.html"%>

	<% }%>



	<!-- works -->

	<!-- NavPath-->

	<div id="works" class=" clearfix grid">
		<div class="container col-lg-8 col-md-offset-2" style="min-height: 300px;">
			<h2 style="text-align: left;"><%=successivo.toUpperCase()%></h2>

			<!--  <a href="MD-DownloadUpload.jsp"><h2 style="text-align: left;">tabella materiale(esempio prova)</h2></a> onclick= bredCrumbs(this);  -->

			<hr>



		

			<ol class="breadcrumb">
				<li id="department"><a 
					href="GestoreRicerca?typeClicked=department&folderClicked=<%=dip %>"><%=dip %></a></li>
				<li id="degree"><a 
					href="GestoreRicerca?typeClicked=degree&folderClicked=<%=degree %>"><%=degree %></a></li>
				<li id="corso"><a 
					href="GestoreRicerca?typeClicked=corso&folderClicked=<%=corso %>"><%=corso %></a></li>
				<li id="materiale"><a 
					href="GestoreRicerca?typeClicked=materiale&folderClicked=<%=materiale %>"><%=materiale %></a></li>
			</ol>
			


			<!-- ListaCorsi -->
			<ul class="list-unstyled">

				<c:forEach var="item" items="${requestScope.folderArray}">
					<a id="<%=successivo%>+${item.nome}"
						href="GestoreRicerca?typeClicked=<%=successivo%>&folderClicked=${item.nome}"><li
						class="well">${item.nome}</li></a>
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
