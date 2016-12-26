<%@ page language="java"  contentType="text/html; charset=UTF-8"  
import="java.util.*,gestioneUtente.*,storageLayer.*"%>

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
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>Student Utilities</title>

  <%@ include file="-UPimport.html" %> 
  
</head>

<body>
  <div class="topbar animated fadeInLeftBig"></div>
  
  

	<%if(utente != null)  { %>
	<%@ include file="-menuLogged.html"%>

	<% }  else  {%>

	<%@ include file="-menu.html"%>

	<% }%>







<!-- works -->
<div id="works"  class=" clearfix grid" style="margin-top:20px">
    <figure class="effect-oscar  wowload fadeIn">
        <img src="images/portfolio/1.jpg" alt="img01"/>
        <figcaption>
            <h2>Aule libere <br><br></h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/1.jpg" title="1" data-gallery>View more</a></p>
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/2.jpg" alt="img01"/>
        <figcaption>
            <h2>Materiale didattico</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/2.jpg" title="1" data-gallery>View more</a></p>
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images/portfolio/3.jpg" alt="img01"/>
        <figcaption>
            <h2>Vendita libri</h2>
            <p>Lily likes to play with crayons and pencils<br>
            <a href="images/portfolio/3.jpg" title="1" data-gallery>View more</a></p>
        </figcaption>
    </figure>
</div>
<!-- works -->





<%@ include file="-footer.html" %> 

<%@ include file="-DOWNimport.html" %>




</body>
</html>
