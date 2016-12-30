<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
   Utente utente = (Utente)session.getAttribute("utente");
        if(utente==null){
        	// SIMULA LA SESSIONE
        	utente = new Utente("a","a","a","a",true,true);
     
     }
     else{
    	
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



<style type="text/css">
.allBox {
	display:flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: flex-start;
    align-content: stretch;
    align-items: stretch;
    
	
	padding: 10px 10px;
	min-height: 500px;
}

.immagineBox {

	/*background: red;*/
	padding: 10px 10px;
	
		flex-grow: 1;
    flex-shrink: 0;
    flex-basis: 100px; 	
}

.testoBox {

    text-align:center;
	/*background: yellow;*/
	padding: 5px 5px;
	
	flex-grow: 1;
    flex-shrink: 0;
    flex-basis: 100px; 
}

.linkBox a h4{

padding: 5px 5px;
font-weight: bold;
}


@media all and (max-width: 1200px) { /* screen size until 1200px */
    body {
        font-size: 1.5em; /* 1.5x default size */
    }
}
@media all and (max-width: 1000px) { /* screen size until 1000px */
    body {
        font-size: 1.2em; /* 1.2x default size */
        }
    }
@media all and (max-width: 500px) { /* screen size until 500px */
    body {
        font-size: 0.8em; /* 0.8x default size */
        }
    }
    

</style>


</head>

<body>
	<div class="topbar animated fadeInLeftBig"></div>



	<%if(utente != null)  { %>
	<%@ include file="-menuLogged.html"%>

	<% }  else  {%>

	<%@ include file="-menu.html"%>

	<% }%>








	<div class="allBox" >

		<div class="immagineBox">
			<img src="images/studente-stress.jpg" class="img-thumbnail img-responsive" />
		</div>

		<div class="testoBox">

			 <p>
			<h2 >Connessione scaduta o</h2>
			
			 <br> 
			
			<h2  > Tentativo d' accedere ad una pagina inesitente</h2>
			</p>
			
			<center>
			<div class="linkBox">
				<h4><a href="index.jsp">TORNA ALLA HOME PAGE</a></h4>
			</div>
			</center>
			
		</div>


	</div>



	<%@ include file="-footer.html"%>

	<%@ include file="-DOWNimport.html"%>




</body>
</html>
