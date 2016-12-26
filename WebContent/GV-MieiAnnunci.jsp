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

	<%@ include file="-menuLogged.html"%>



	<!-- works -->
	<!-- SearchBar -->
	<div id="works" class=" clearfix grid">
		<div class="container col-lg-8 col-md-offset-2">
			<h2 style="text-align: left;">I miei annunci</h2>
			<hr>
			<!-- TabellaLibri -->
			<table class="table table-hover">
				<tbody>
					<tr>
						<td><img src=""></td>
						<td>
							<ul id="dettagli-libro" class="list-unstyled li-left">
								<li>Titolo libro</li>
								<li>Prezzo</li>
								<li>Data annuncio</li>
							</ul>
						</td>
						<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
						<td><span class="glyphicon glyphicon-trash"></span></td>
					</tr>
					<tr>
						<td><img src=""></td>
						<td>
							<ul id="dettagli-libro" class="list-unstyled li-left">
								<li>Titolo libro</li>
								<li>Prezzo</li>
								<li>Data annuncio</li>
							</ul>
						</td>
						<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
						<td><span class="glyphicon glyphicon-trash"></span></td>
					</tr>
					<tr>
						<td><img src=""></td>
						<td>
							<ul id="dettagli-libro" class="list-unstyled li-left">
								<li>Titolo libro</li>
								<li>Prezzo</li>
								<li>Data annuncio</li>
							</ul>
						</td>
						<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
						<td><span class="glyphicon glyphicon-trash"></span></td>
					</tr>

				</tbody>
			</table>
			<a href="GV-InserisciAnnuncio.jsp"> <input type="button"
				class="btn btn-success" name="inserisci-annuncio"
				value="Inserisci annuncio" style="margin-bottom: 10px;">
			</a>

			<!-- /TabellaLibri -->
			<!-- <input type="file" name="file" accept="/image/*" value="Scegli"> -->
		</div>
	</div>
	<!-- works -->

	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>

</body>
</html>