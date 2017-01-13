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
  


    <%@ include file="-menu.html"%>






<!-- works -->

<!-- works -->

<!--Recupero dati Starts-->

<div class="container contactform center" style="margin-top:20px;">
<h2 class="text-center  wowload fadeInUp">Non ricordi più i dati per accedere a Student Utilities? </h2>
<br>
  <div class="row wowload fadeInLeftBig">
   <div class="col-sm-6 col-sm-offset-3 col-xs-12">
  <form id="resetPassword" action="ConfermaReset" method="post" role="form">
 
      <div class="form-group">
       <input type="text" name="resetemail" id="resetemail" tabindex="1" class="form-control" placeholder="Immetti la tua email" value="" style="height: 50px">
                </div>
        <div class="form-group">
                  <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn-info" value="Recupera password" style="height: 50px">
                </div>
     
   </form>
    </div>
  </div>

</div>

<br> 
<!--Recupero dati Ends-->




<%@ include file="-footer.html" %> 

<%@ include file="-DOWNimport.html" %>
<script src="js/validation.js"></script>


</body>
</html>
