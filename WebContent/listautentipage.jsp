<%@ page language="java"  contentType="text/html; charset=UTF-8"  
import="java.util.*,gestioneUtente.*,storageLayer.*"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 

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

<sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://mysql3.gear.host:3306/redteam"
        user="oromis95" password="P@ssw0rd"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM utente;
    </sql:query>

<!-- works -->
<br>
<div class="container">
 <h2 class="text-center  wowload fadeInUp"> Lista utenti</h2>
 
 <!-- I valori della tabella sono da cambiare poichÃ¨ saranno genererati dinamicamente in base alle query -->       
 <c:choose>
 <c:when test="${user.isPrivilegioAdmin()}">
  <table class="table table-hover" >   
  <thead class="th-center">
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Disabilita</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${listUsers.rows}" var="dataItem">
        <tr>
            <td>${dataItem.nome}</td>
            <td>${dataItem.cognome}</td>
            <td>${dataItem.email}</td>
            <td><input checked data-toggle="toggle" data-onstyle="success" data-offstyle="danger" type="checkbox"></td>
        </tr>
        </c:forEach>
       
    </tbody>
  </table>
  </c:when>
  </c:choose>
</div>

<!-- works -->











<%@ include file="-footer.html" %> 

<%@ include file="-DOWNimport.html" %>
</body>
</html>
