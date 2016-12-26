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
			<!-- SearchBar -->
			<div class="input-group stylish-input-group">
				<input type="text" class="form-control" placeholder="Search">
				<span class="input-group-addon">
					<button type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<!-- /SearchBar -->
			<hr>

			<div class="col-lg-12">
				<!-- NavPath-->

				<ol class="breadcrumb">
					<li><a href="#">MY TOPICS</a></li>
					<li><a href="#">WORLD</a></li>
					<li><a href="#">LOCAL</a></li>
					<li><a href="#">US</a></li>
				</ol>
				
				<!-- TabellaLibri -->
				<table class="table table-hover">
				<thead class="th-center">
					<tr>
						<th>Titolo</th>
						<th>Autore</th>
						<th>Corso</th>
						<th>Condizione</th>
						<th>Proprietario</th>
						<th>Prezzo</th>
					</tr>
				</thead>
				</table>
			</div>
		</div>
	</div>
	<!-- works -->

	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>
	
</body>
</html>