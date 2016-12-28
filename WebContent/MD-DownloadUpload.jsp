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
					href="GestoreRicerca?typeClicked=department&folderClicked=<%=dip %>"><%=dip %></a></li>
				<li><a id="degree"
					href="GestoreRicerca?typeClicked=degree&folderClicked=<%=degree %>"><%=degree %></a></li>
				<li><a id="corso"
					href="GestoreRicerca?typeClicked=corso&folderClicked=<%=corso %>"><%=corso %></a></li>
				<li><a id="materiale"
					href="GestoreRicerca?typeClicked=materiale&folderClicked=<%=materiale %>"><%=materiale %></a></li>

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
							<td><a href="#">${risorsa.like} <span
									class="glyphicon glyphicon-thumbs-up"></span></a></td>
							<td><a href="#">${risorsa.dislike} <span
									class="glyphicon glyphicon-thumbs-down"></span></a></td>
							<td>${risorsa.dataUpload}</td>
							<td>${risorsa.dimensione}</td>
							<td><a href="GestoreDownload?idRisorsa=${risorsa.idRisorsa}"><span
									class="glyphicon glyphicon-save"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- /TabellaLibri -->
			<form id="uploadForm" action="GestoreUpload" method="post"
				enctype="multipart/form-data">
				<label class="btn btn-file btn-success" style="margin-bottom: 10px"><span
					class="glyphicon glyphicon-open"></span> Upload file<input
					type="file" name="uploadable" id="uploadable"
					style="display: none;"> </label>
			</form>

		</div>
	</div>
	<!-- works -->




	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>




</body>
<script>
	$('#uploadable').change(function() {
		$('#uploadForm').submit();
	});
</script>
</html>

