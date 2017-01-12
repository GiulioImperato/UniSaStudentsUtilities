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

<!-- works -->

<!--Recupero dati Starts-->
<a name="forgotpassword"><br>

<div class="container contactform center">
<h2 class="text-center  wowload fadeInUp">Non ricordi più i dati per accedere a Student Utilities? </h2>
<br>
  <div class="row wowload fadeInLeftBig">
  <form action="ConfermaReset" method="post">
      <div class="col-sm-6 col-sm-offset-3 col-xs-12">
        <input type="text" id="reset-email" name="reset-email" placeholder="Immetti la tua email">
        <input type="submit" class="btn btn-primary" value="Recupera password">
      </div>
   </form>
  </div>

</div>
</div>
<br> </a>
<!--Recupero dati Ends-->




<%@ include file="-footer.html" %> 

<%@ include file="-DOWNimport.html" %>



</body>
</html>
