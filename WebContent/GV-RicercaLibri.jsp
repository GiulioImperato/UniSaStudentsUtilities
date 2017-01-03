<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,gestioneUtente.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("user");
	String visible = (String) request.getAttribute("vis");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>

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
			<form id="searchform"
				action="GestoreLibriServlet?azione=ricercaAnnunci" method="post">
				<div class="input-group stylish-input-group">
					<input id="searchbar" name="titolo" type="text"
						class="form-control" placeholder="Cerca per Titolo"> <span
						class="input-group-addon"> </span>
				</div>
				<!-- /SearchBar Titolo -->

				<br>
				<!-- SearchBar Autore-->
				<div class="input-group stylish-input-group">
					<input name="autore" type="text" class="form-control"
						placeholder="Cerca per Autore"> <span
						class="input-group-addon"> </span>
				</div>
				<!-- /SearchBar Autore -->
				<br> <label class="btn btn-file btn-success"><span
					class="glyphicon glyphicon-search"></span> CERCA<input id="submit"
					name="submit" type="submit" style="display: none;"> </label>
			</form>
			
			<%if(request.getAttribute("noresult")!=null){ %>
				<h3>NESSUNA CORRISPONDENZA TROVATA</h3>
			<%} %>
			
			<!-- TabellaLibri -->
			<%
				if (visible != null) {
			%>
			<table style="visibility: visible" id="tableresult"
				class="table table-hover">
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
					<c:forEach var="annuncio" items="${requestScope.listaAnnunci}">
						<tr>
							<td>${annuncio.titolo}</td>
							<td>${annuncio.autore}</td>
							<td>${annuncio.corso}</td>
							<td>${annuncio.proprietario}</td>
							<td>${annuncio.condizioneLibro}</td>
							<td>€${annuncio.prezzo}</td>
							<%
								if (utente != null) {
							%>
							
							<td>
								<li class="dropdown"><a
									href="#" class="dropdown-toggle" data-toggle="dropdown"> <span
										id="acquistaicon" class="glyphicon glyphicon-envelope"></span>
								</a>
									<ul class="dropdown-menu dropdown-lr animated slideInRight"
										role="menu">
										<div class="col-lg-12">
											<div class="text-center">
												<h4>
													<b>Invia messaggio</b>
												</h4>
											</div>
											<form id="formmessage" action="GestoreLibriServlet?azione=inviamessaggio&user=<%=utente.getEmail()%>&dest=${annuncio.proprietario}" method="post">						
 											<label for="password">La tua password unisa</label> 
												<input
													type="password" name="passwordSender" id="password" 
													tabindex="1" class="form-control" placeholder="Password"
													autocomplete="off">
																									
												<label for="subject">Re:</label> 
												<input type="text" id="subject"
													class="form-control" tabindex="2" name="subject">
												<label for="content">Testo</label> 
												<textarea id="content" class="form-control" tabindex="3" maxlength="3000" rows="7" name="content"></textarea>
											<div>
												<input type="submit" name="Send"
													id="messagesubmit" tabindex="4" 
													class="form-control btn-success" value="Invia a ${annuncio.proprietario}"> 
											</div>
											</form>
										</div>
									</ul></li>
							</td>

							<%
								} else {
							%>
							<td>Login/Registrati</td>
							<%
								}
							%>


						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%
				}
			%>
			<!-- /TabellaLibri -->

		</div>
	</div>


	<!--Contact Starts-->
	<%
		if (visible == null) {
	%>
	<div id="contact" class="spacer"></div>
	<%
		}
	%>
	<!--Contact Ends-->
	<!-- works -->

	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>

</body>
</html>