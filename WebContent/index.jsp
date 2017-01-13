<%@ page language="java"  contentType="text/html; charset=UTF-8"  
import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>

     


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>Student Utilities</title>

  <%@ include file="-UPimport.html" %> 
  
</head>

<body>
  <div class="topbar animated fadeInLeftBig"></div>
  

<c:choose>
  <c:when test="${empty user}">
    <%@ include file="-menu.html"%>
  </c:when>
  <c:otherwise>
    <%@ include file="-menuLogged.html"%>
  </c:otherwise>
</c:choose>





<!-- works -->
<div id="works"  class=" clearfix grid" style="margin-top:20px">
    <figure class="effect-oscar  wowload fadeIn">
        <img src="images/portfolio/1.jpg" alt="img01"/>
        <figcaption>
            <h2>Aule libere</h2>
            <p>Trova un aula libera per studiare e confrontarti con i tuoi colleghi.<br>
            <a href="GA-Mappa.jsp">Consulta le aule libere</a></p>
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/2.jpg" alt="img01"/>
        <figcaption>
            <h2>Appunti</h2>
            <p>Consulta la nostra collezione di appunti e materiale didattico, a tua disposizione in modo completamente gratuito.<br>
            <a href="GestoreRicerca?typeClicked=home&&folderClicked=uni">Accedi al materiale didattico</a></p>
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/3.jpg" alt="img01"/>
        <figcaption>
            <h2>Libri</h2>
            <p>Acquista un libro usato consultando i nostri annunci, risparmierai tempo e denaro.<br>
            <a href="GV-RicercaLibri.jsp">Accedi agli annunci dei libri</a></p>
        </figcaption>
    </figure>
</div>
<!-- works -->





<%@ include file="-footer.html" %> 

<%@ include file="-DOWNimport.html" %>




</body>
</html>
