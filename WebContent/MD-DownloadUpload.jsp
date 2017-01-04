<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");

	String home = (String) request.getAttribute("home");
	String dip = (String) request.getAttribute("dip");
	String degree = (String) request.getAttribute("degree");
	String corso = (String) request.getAttribute("corso");
	String materiale = (String) request.getAttribute("materiale");

	if (utente == null) {
		// SIMULA LA SESSIONE
		//utente = new Utente("a","a","a","a",true,true);

	} else {

	}
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Student Utilities</title>

<%@ include file="-UPimport.html"%>

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

	<div id="works" class=" clearfix grid">
		<div class="container col-lg-8 col-md-offset-2">

			<hr>


			<!-- NavPath-->

			<ol class="breadcrumb">
				<li><a id="department"
					href="GestoreRicerca?typeClicked=department&folderClicked=<%=dip%>"><%=dip%></a></li>
				<li><a id="degree"
					href="GestoreRicerca?typeClicked=degree&folderClicked=<%=degree%>"><%=degree%></a></li>
				<li><a id="corso"
					href="GestoreRicerca?typeClicked=corso&folderClicked=<%=corso%>"><%=corso%></a></li>
				<li><a id="materiale"
					href="GestoreRicerca?typeClicked=materiale&folderClicked=<%=materiale%>"><%=materiale%></a></li>

			</ol>

			<!-- /NavPath -->

			<!-- TabellaLibri -->
			<table class="table table-hover">
				<thead class="th-center">
					<tr>
						<th>Titolo</th>
						<th>Proprietario</th>
						<th>Like</th>
						<th>Dislike</th>
						<th>Data upload</th>
						<th>Dimensione</th>
						<th>Download</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="risorsa" items="${requestScope.resourceArray}">
						<tr>
							<td>${risorsa.nome}</td>
							<td>${risorsa.proprietario}</td>



							<%
								if (utente != null) {
							%>

							<td><a id="likefeed" name="${risorsa.idRisorsa}"
								onclick=jasonLike(this);>${risorsa.like}<span id="upFeed"
									class="glyphicon glyphicon-thumbs-up"></span>
							</a></td>
							<td><a id="dislikefeed" name="${risorsa.idRisorsa}"
								onclick=jasonDislike(this);>${risorsa.dislike}<span
									id="downFeed" class="glyphicon glyphicon-thumbs-down"></span>
							</a></td>

							<%
								} else {
							%>
							<td><a id="likefeed" name="${risorsa.idRisorsa}">${risorsa.like}
									<span id="upFeed" class="glyphicon glyphicon-thumbs-up"></span>
							</a></td>
							<td><a id="dislikefeed" name="${risorsa.idRisorsa}">${risorsa.dislike}
									<span id="downFeed" class="glyphicon glyphicon-thumbs-down"></span>
							</a></td>

							<%
								}
							%>




							<td>${risorsa.dataUpload}</td>
							<td>${risorsa.dimensione}</td>
							<td><a href="GestoreDownload?idRisorsa=${risorsa.idRisorsa}&dip=<%=dip%>&degree=<%=degree%>&corso=<%=corso%>&materiale=<%=materiale%>"><span
									class="glyphicon glyphicon-save"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- /TabellaLibri -->
			<form id="uploadForm" action="GestoreUpload" method="post"
				enctype="multipart/form-data">
				<label class="btn btn-file btn-success" style="margin-bottom: 10px">
					<input type="hidden"
					value="res/uni/<%=dip%>/<%=degree%>/<%=corso%>/<%=materiale%>/"
					id="path" name="path">
					<input type="hidden" name="user" id="user" value="${user.email}"> <span
					class="glyphicon glyphicon-open"></span>
				<c:choose>
						<c:when test="${empty user}">
						Devi essere loggato
							<input type="file" disabled="disabled" name="uploadable"
								id="uploadable" style="display: none;">
						</c:when>
				<c:otherwise>
						Upload file
							<input type="file" name="uploadable" id="uploadable"
						style="display: none;">
				</c:otherwise>
				</c:choose>
				</label> 
				<input type="hidden"
					value="GestoreRicerca?typeClicked=materiale&folderClicked=<%=materiale%>"
					id="visualizedPage" name="visualizedPage">

			</form>

		</div>
	</div>
	<!-- works -->

	<script type="text/javascript">
	
	var clicklike =false;
	var clickdislike = false;
	var up   =document.getElementById("upFeed");	
	var down =document.getElementById("downFeed");
	
	
function jasonLike(obj){
	
	//alert("in likejason ");	
	
	if(clicklike == true){
		alert("Hai gia lasciato un Like");
	}
	
	if(clicklike ==false){
		
		clickdislike = false;
		clicklike =true;
	
	var off =document.getElementById("likefeed");
	   	      
	var on =document.getElementById("dislikefeed");
	 
	// $(off).css({"background":"red"});
    // $(on).css({"background":"green"});
		
	  $.ajax({
		  type:'GET',
		 url:'GestoreFeedback?numlike='+$(obj).text()+'&numdislike='+$(on).text()+'&cliccato=like'+'&idRis='+$(obj).attr("name"),
				
		headedrs:{
			Accept: "application/json; charset=utf-8",
    "Content-type": "application/json; charset=utf-8",
		},
		
		success:function(result){			
			var risultato = $.parseJSON(result);
						
	var a =document.getElementById("likefeed");
	a.innerHTML = risultato[0];
	//a.text( up);
	a.appendChild(up); 
	
	var b =document.getElementById("dislikefeed");
	b.innerHTML = risultato[1];
	//b.text( down);
	b.appendChild(down);
			
			
			alert("Feedback inserito con successo !")
			
			  
				},
		error : function (richiesta,stato,errori) {
			
		//	$(off).css({"background":"none"});
		//  $(on).css({"background":"none"});
			     clicklike =false;
			     clickdislike = false;
			        alert("C'è stato un problema con il server. Impossibile registrare il feedback");
			    }	  
	  });
	  
	}
};


function jasonDislike(obj){
	
	//alert("in dislike jason ");
	
	if(clickdislike == true){
		alert("Hai gia lasciato un Dislike");
	}
	
	if(clickdislike ==false){
		
		clicklike = false;
		clickdislike =true;

	var off =document.getElementById("dislikefeed");
    
    var on =document.getElementById("likefeed");

    // $(off).css({"background":"red"});
     //$(on).css({"background":"green"});
	
	
	  $.ajax({
		  type:'GET',
		 url:'GestoreFeedback?numdislike='+$(obj).text()+'&numlike='+$(on).text()+'&cliccato=dislike'+'&idRis='+$(obj).attr("name"),
				
		headedrs:{
			Accept: "application/json; charset=utf-8",
    "Content-type": "application/json; charset=utf-8",
		},
		
		success:function(result){
			
			var risultato = $.parseJSON(result);
						
			var a =document.getElementById("likefeed");
			a.innerHTML = risultato[0];
			//a.text( up);
			a.appendChild(up); 
			
			var b =document.getElementById("dislikefeed");
			b.innerHTML = risultato[1];
			//b.text( down);
			b.appendChild(down);
			
			alert("feedback inserito con successo !")
						
			  
				},
		error : function (richiesta,stato,errori) {
			
			//$(off).css({"background":"none"});
			//$(on).css({"background":"none"});
			     clicklike =false;
			     clickdislike = false;
			     alert("C'è stato un problema con il server. Impossibile registrare il feedback");
				    }	
				
	  });
	  
	}
};


</script>



	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>




</body>
<script>

	$('#uploadable').change(function() {
		  $('#uploadForm').submit();
	});

</script>
</html>

