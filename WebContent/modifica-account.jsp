<%@ page language="java"  contentType="text/html; charset=UTF-8"  
import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Student Utilities</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700' rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="assets/animate/animate.css" />
<link rel="stylesheet" href="assets/animate/set.css" />
<link href="http://cdn.phpoll.com/css/animate.css" rel="stylesheet">

<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">

<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">


<link rel="stylesheet" href="assets/style.css">

</head>

<body>
<div class="topbar animated fadeInLeftBig"></div>
<!--NAVBAR-->
<c:choose>
  <c:when test="${empty user}">
    <%@ include file="-menu.html"%>
  </c:when>
  <c:otherwise>
    <%@ include file="-menuLogged.html"%>
  </c:otherwise>
</c:choose>

<!--FINENAV-->







<!-- works -->
<div id="works"  class=" clearfix grid">
  <div class="container col-lg-8 col-md-offset-2">
  <h2 style="text-align: left;">Impostazioni account</h2>
  <hr>
  <form id="modifica_account" action="ModificaAccount" method="post">
    <table class="table table-striped">
     <tr>
      <th colspan="2"><span class="glyphicon glyphicon-cog"></span> <b>Impostazioni account</b></th>
    </tr>
    <tbody>
      
      <tr>
        <td>Nome</td>
        <td><input type="text" id="nome" name="nome" class="form-control" value="${user.nome}" readonly></td>
      </tr>
      
      <tr>
        <td>Cognome</td>
        <td><input type="text" id="cognome" name="cognome" class="form-control" value="${user.cognome }" readonly></td>
      </tr>
      
      <tr>
        <td>Email</td>
        <td><input type="text" id="email" name="email" class="form-control" value="${user.email }" readonly></td>
      </tr>
      
      <tr>
        <td>Password</td>
        <td><input type="password" id="password" name="password" class="form-control" value="${user.password }" placeholder="Password"></td>
      </tr>
      <tr>
      	<td>Conferma Password</td>
      	<td><input type="password" id="confirmpassword" name="confirmpassword" class="form-control" placeholder="Conferma password"></td>
      </tr>
      
    </tbody>
  </table>
  <div class="form-group pull-right">
    <input type="submit" id="update" name="action" class="btn btn-success" value="Update">
    <input type="submit" id="elimina" name="action" class="btn btn-danger" value="Elimina">
  </div>
  </form>
</div>

</div>
<!-- works -->



<!--Contact Starts-->
<div id="contact" class="spacer">


</div>
<!--Contact Ends-->



<!-- Footer Starts -->
<div class="footer text-center spacer">
<p class="wowload flipInX"><a href="#"><i class="fa fa-facebook fa-2x"></i></a> <a href="#"><i class="fa fa-instagram fa-2x"></i></a> <a href="#"><i class="fa fa-twitter fa-2x"></i></a> <a href="#"><i class="fa fa-flickr fa-2x"></i></a> </p>
Copyright 2014 Cyrus Creative Studio. All rights reserved.
</div>
<!-- # Footer Ends -->
<a id="back-to-top" href="#" class="gototop "><span class="glyphicon glyphicon-chevron-up"></span></a>





<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
<!-- The container for the modal slides -->
<div class="slides"></div>
<!-- Controls for the borderless lightbox -->
<h3 class="title">Title</h3>
<a class="prev">â¹</a>
<a class="next">âº</a>
<a class="close">Ã</a>
<!-- The modal dialog, which will be used to wrap the lightbox content -->
</div>



<!-- jquery -->
<script src="assets/jquery.js"></script>

<!-- wow script -->
<script src="assets/wow/wow.min.js"></script>


<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript" ></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>
<script src="assets/respond/respond.js"></script>

<!-- gallery -->
<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>

<!-- custom script -->
<script src="assets/script.js"></script>

</body>
</html>
