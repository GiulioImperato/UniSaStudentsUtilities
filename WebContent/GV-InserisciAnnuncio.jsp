<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,gestioneUtente.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");
	//String email = utente.getEmail();
	if (utente == null) {
		// SIMULA LA SESSIONE
		//utente = new Utente("a","a","a","a",true,true);

	} else {

	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
  <script type="text/javascript" src="js/AnnuncioValidator.js"></script>
  <script type="text/javascript" src="js/uploadImage.js"></script>
  <script type="text/javascript" src="js/jquery.form.js"></script>
  
  <title>Student Utilities</title>

  <%@ include file="-UPimport.html"%>


</head>

<body onload="hideLoadingPage()">
			
  <div class="topbar animated fadeInLeftBig"></div>
 	
	<%@ include file="-menuLogged.html"%>

         

  <!-- works -->

  <div id="works"  class=" clearfix grid">
    <div class="container col-lg-8 col-md-offset-2">
           
      <h2 style="text-align: left;">Inserisci annuncio</h2> 
      <!-- TabellaLibri -->
      
      <form id="insertform" name="insertform" action="UploadImage" method="post" enctype="multipart/form-data">
      
      <table class="table">
        <tbody>
          <tr>
            <td>
            <img id="image" src="" width="199" height="283"> <br><br>
               <label class="btn btn-file btn-success"><span class="glyphicon glyphicon-open"></span>
                Scegli foto...<input id="file" name="file" type="file" style="display: none;">
              </label><br><br>
               <label class="btn btn-file btn-success"><span class="glyphicon glyphicon-open"></span>
               Carica<input id="submit" name="submit" type="submit"  style="display: none;">
               </label>
            </td>
            <td>
              <ul class="list-unstyled stylish-insert-ad">
               	<li><input id="titolo" type="text" name="titolo-libro" class="form-control" placeholder="Titolo" tabindex="1" ></li>
                <li><input id="autore" type="text" name="autore-libro" class="form-control" placeholder="Autore" tabindex="2" ></li>                
                <li><input id="editore" type="text" name="editore-libro" class="form-control" placeholder="Editore" tabindex="3" ></li>
                <li><input id="anno" type="number" min="00.00" name="anno-libro" class="form-control" placeholder="Anno: aaaa" tabindex="4" ></li>
                
                <!-- LOADING GIF -->
                	<div id="hidepage" style="position: absolute; 
					left:0px; top:0px; background-color: #FFFFF; height: 100%; width: 100%; visibility:hidden"> 
						<table width="100%" height="100%"><tr><td align="center" valign="middle"> 
						<table width="100%" align="center"><tr><td align="center" class="row1"> 
						<p><img src="images/loading.gif"></p>
						</td></tr></table> 
						</td></tr></table>
					</div>
             	<!-- END LOADING GIF -->	
                
                <li>
                  <select class="form-control" name="condiz" id="condizioni" tabindex="5" >
                    <option value="selected" selected>--- Selezionare condizione ---</option>
                    <option value="Nuovo">Nuovo</option>
                    <option value="Usato">Usato</option>
                    <option value="Fotocopie">Fotocopie</option>
                  </select>
                </li>
                <li><input id="prezzo" type="number" min="00.00" step="00.01" name="prezzo-libro" class="form-control" placeholder="Prezzo: 00,00" tabindex="6" ></li>
                <li>
                  <select class="form-control" name="corso" id="select-corso" tabindex="6" >
                    <option value="selected" selected>--- Selezionare corso di laurea ---</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                  </select>
                </li>
                <li>
                  <textarea id="textarea-libro" class="form-control" placeholder="Descrizione" tabindex="6" rows="7" ></textarea>
                </li>
              </ul>
            </td>
          </tr>
        </tbody>
      </table>    
      <div class="form-group pull-right" style="margin-top: -29px">
        <input id="checkAnnuncio" type="button" name="inserisci-annuncio" value="inserisci annuncio" class="btn btn-success">
      </div>
      </form>

      <!-- /TabellaLibri -->
    </div>
  </div>
  			
  <!-- works -->
				
	<%@ include file="-footer.html"%>
	
	<%@ include file="-DOWNimport.html"%>
	
</body>
</html>
