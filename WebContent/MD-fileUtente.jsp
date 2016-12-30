<%@page import="gestioneMaterialeDidattico.Risorsa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,gestioneUtente.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");
    ArrayList<Risorsa> risorse ;
    
    risorse=(ArrayList<Risorsa>)request.getAttribute("listaRisorseUtente");


	if (utente == null) {
		// SIMULA LA SESSIONE
		utente = new Utente("a","a","a","a",true,true);

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

  <div id="works"  class=" clearfix grid">
    <div class="container col-lg-8 col-md-offset-2">
    <h2 style="text-align: left;">I miei file</h2> 

      <hr> 
      
     <%  if(risorse==null) {  %>
     
     <div> 
     
     <p> Non Hai Publcato Nessuna Risorsa</p>
     
     </div>
     
     <% }else if(risorse.size()==0){ %>
     
     <div> 
     
     <p> Non Hai Publcato Nessuna Risorsa</p>
     
     </div>
      
      <%} else { %>
      
     

      <!-- TabellaRisorse -->
      <table class="table table-hover">
        <thead class="th-center">
        <tr>
          <th>Titolo</th>
          <th>Like</th>
          <th>Dislike</th>
          <th>Data Upload</th>
          <th>Dimensione</th>
          <th>Path Caricamento</th>
          <th>Elimina</th>
          </tr>
        </thead>

        <tbody>
        
        <%for(int i=0 ;i<risorse.size();i++) {%>
        
          <tr>
            <td><%=risorse.get(i).getNome()%></td>
            <td><%=risorse.get(i).getLike()%></td>
            <td><%=risorse.get(i).getDislike()%></td>
           <td><%=risorse.get(i).getDataUpload()%></td>
            <td><%=risorse.get(i).getDimensione()%></td>
            <td><%=risorse.get(i).getDimensione()%></td>
            <td><%=risorse.get(i).getPathCaricamento()%></td>
           <!-- <td><a href="#"><span class="glyphicon glyphicon-save"></span></a></td> --> 
            <td><a href="GestoreEliminaRisorsa?action=one&idRis=<%=risorse.get(i).getIdRisorsa()%>"><span class="glyphicon glyphicon-trash"></span></a></td>
          </tr>
          <%} %>
          
        </tbody>
      </table>
      <!-- /TabellaRisorse -->
      
       <%} %>
      
      <a href="GestoreEliminaRisorsa?action=all&idRis=all" class="btn btn-file btn-success" style="margin-bottom: 10px"><span class="glyphicon glyphicon-trash"></span>
        Elimina tutto<input type="file" style="display: none;">
      </a>
    </div>
  </div>
<!-- works -->
	
	
	
	
	
	
	
	
	

	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>

</body>
</html>