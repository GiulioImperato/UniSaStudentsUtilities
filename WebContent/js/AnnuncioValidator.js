function hideLoadingPage(){            //NASCONDE LA LOADING GIF 
	if (document.getElementById) { 
		document.getElementById('hidepage').style.visibility = 'hidden'; 
	} 
}

$(document).ready(function(){
	$('#checkAnnuncio').click(function(){
		var titolo = $('#titolo').val();
		var autore = $('#autore').val();
		var editore = $('#editore').val();
		var anno = $('#anno').val();
		var condizione = document.insertform.condiz;
		var cond = condizione.value;
		var prezzo = $('#prezzo').val();
		var cor = document.insertform.corso;
		var corso = cor.value;
		var descrizione = $('#textarea-libro').val();

		var pathFile = document.getElementById('image').src;

		if(checkTitle(titolo)){
			if(checkAutore(autore)){
				if(checkEditore(editore)){
					if(checkAnno(anno)){
						if(checkCondizione(condizione)){
							if(checkPrezzo(prezzo)){
								if(checkCorso(cor)){
									if(checkDescrizione(descrizione)){
										if(checkPath(pathFile)){
											if (document.getElementById) {      //rende visibile la loading gif
												document.getElementById('hidepage').style.visibility = 'visible'; 
											} 
											$.ajax({
												type:'POST',
												data: {
													"titolo-libro":titolo,
													"autore-libro":autore,
													"editore-libro":editore,
													"anno-libro":anno,
													"condizioni":cond,
													"prezzo-libro":prezzo,
													"corso-libro":corso,
													"descrizione":descrizione,
													"path":pathFile,
													azione:"inserisciAnnuncio"	
												},
												url:'GestoreLibriServlet',
												success: function(){
													alert('INSERIMENTO EFFETTUATO');
													location.href='/usu/GV-MieiAnnunci.jsp';
												}
											});
										}
									}
								}
							}
						}
					}
				}
			}
		}
	});
});

function checkTitle(titolo){
	var letters = /^[A-Za-z0-9]+$/;
	if(titolo==""){
		alert('Il campo titolo è vuoto'+pathFile);
		alert('dsadsa0'+pathFile);
		return false;
	}
	if(titolo.match(letters)){
		return true;
	}else{
		alert('Titolo non valido');
		return false;
	}
}

function checkAutore(autore){
	var letters = /^[A-Za-z]+$/;
	if(autore==""){
		alert('Il campo autore non può essere vuoto');
		return false;
	}
	if(autore.match(letters)){
		return true;
	}else{
		alert('Autore non valido');
		return false;
	}
}

function checkEditore(editore){
	var letters = /^[A-Za-z]+$/;
	if(editore==""){
		alert('Il campo editore non può essere vuoto');
		return false;
	}
	if(editore.match(letters)){
		return true;
	}else{
		alert('Editore non valido');
		return false;
	}
}

function checkAnno(anno){
	var numb = /^[0-9]+$/;
	if(anno==""){
		alert('Il campo Anno è vuoto o non valido');
		return false;
	}
	var current_year=new Date().getFullYear();
	if(anno>current_year || anno<1930){
		alert("L'anno deve essere nel range del 1930 all'anno "+current_year);
		return false;
	}else{
		return true;
	}
}

function checkCondizione(condizione){
	if(condizione.value=='selected'){
		alert('Scegliere la condizione');
		return false;
	}
	else{
		return true;
	}
}

function checkPrezzo(prezzo){
	var regex = /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/;
	if(prezzo==""){
		alert('Il campo prezzo è vuoto o non valido');
		return false;
	}
	if(prezzo.match(regex)){
		return true;
	}else{
		alert('Prezzo non valido');
		return false;
	}
}

function checkCorso(cor){
	if(cor.value=='selected'){
		alert('Scegliere il corso');
		return false;
	}
	else{
		return true;
	}
}

function checkDescrizione(descrizione){
	if(descrizione==""){
		alert('Il campo descrizione è vuoto');
		return false;
	}
	else
		return true;
}

function checkPath(pathfile){
	if(pathFile==""){
		alert('Inserire una foto');
		return false;
	}
	else 
		return true;
}