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

  <div id="works"  class=" clearfix grid">
    <div class="container col-lg-8 col-md-offset-2">
    <h2 style="text-align: left;">I miei file</h2> 

      <hr> 

      <!-- TabellaLibri -->
      <table class="table table-hover">
        <thead class="th-center">
        <tr>
          <th>Titolo</th>
          <th>Like</th>
          <th>Dislike</th>
          <th>Data upload</th>
          <th>Dimensione</th>
          <th>Tipo</th>
          <th>Download</th>
          <th>Elimina</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Programmazione C</td>
            <td><span class="glyphicon glyphicon-thumbs-up"></span></td>
            <td><span class="glyphicon glyphicon-thumbs-down"></span></td>
            <td>30/12/2016</td>
            <td>20Mb</td>
            <td>Pdf</td>
            <td><a href="#"><span class="glyphicon glyphicon-save"></span></a></td>
            <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
          </tr>
          <tr>
            <td>Programmazione C</td>
            <td><span class="glyphicon glyphicon-thumbs-up"></span></td>
            <td><span class="glyphicon glyphicon-thumbs-down"></span></td>
            <td>30/12/2016</td>
            <td>20Mb</td>
            <td>Pdf</td>
            <td><a href="#"><span class="glyphicon glyphicon-save"></span></a></td>
            <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
          </tr>
          <tr>
            <td>Programmazione C</td>
            <td><span class="glyphicon glyphicon-thumbs-up"></span></td>
            <td><span class="glyphicon glyphicon-thumbs-down"></span></td>
            <td>30/12/2016</td>
            <td>20Mb</td>
            <td>Pdf</td>
            <td><a href="#"><span class="glyphicon glyphicon-save"></span></a></td>
            <td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
          </tr>
        </tbody>
      </table>
      <!-- /TabellaLibri -->
      <label class="btn btn-file btn-danger" style="margin-bottom: 10px"><span class="glyphicon glyphicon-trash"></span>
        Elimina tutto<input type="file" style="display: none;">
      </label>
    </div>
  </div>
<!-- works -->












<%@ include file="-footer.html" %> 

<%@ include file="-DOWNimport.html" %>

</body>
</html>