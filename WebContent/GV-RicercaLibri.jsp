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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
			<!-- SearchBar Titolo-->
			<div class="input-group stylish-input-group">
				<input type="text" class="form-control" placeholder="Cerca per Titolo">
				<span class="input-group-addon">
					<button type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<!-- /SearchBar Titolo -->
			<br>
			<!-- SearchBar Autore-->
			<div class="input-group stylish-input-group">
				<input type="text" class="form-control" placeholder="Cerca per Autore">
				<span class="input-group-addon">
					<button type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<!-- /SearchBar Autore -->
			<hr>
			
			<!-- TabellaLibri -->
			<table class="table table-hover">
				<thead class="th-center">
					<tr>
						<th>Titolo</th>
						<th>Autore</th>
						<th>Corso</th>
						<th>Proprietario</th>
						<th>Condizione Libro</th>
						<th>Prezzo</th>
						<th>Acquista Libro</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="annuncio" items="${requestScope.annuncioArray}">
						<tr>
							<td>${annuncio.titolo}</td>
							<td>${annuncio.autore}</td>
							<td>${annuncio.corso}</td>
							<td>${annuncio.proprietario}</td>
							<td>${annuncio.condizione}</td>
							<td>${annuncio.prezzo}</td>
							<%
								if (utente != null) {
							%>

							<td><a id="acquista" name="${annuncio.idRisorsa}"
								onclick=jasonLike(this);>${annuncio.acquista}<span id="acquistaicon"
									class="glyphicon glyphicon-envelope"></span>
							</a></td>
							
							<%
								} else {
							%>
							<td><a id="acquista" name="${risorsa.acquista}">${risorsa.acquista}
							<span id="acquistaicon" class="gglyphicon glyphicon-envelope"></span>
							</a></td>
							<%
								}
							%>
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- /TabellaLibri -->
			
		</div>
	</div>
	<!-- works -->

	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>

</body>
</html>