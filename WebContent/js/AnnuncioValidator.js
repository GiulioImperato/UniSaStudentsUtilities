/*
	$(document).ready(function(){
	$('#insertform').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			titolo : {
				validators : {
					notEmpty : {
						message : 'Inserisci il titolo'
					},
					regexp : {
						regexp : '^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$',
						message : 'Titolo non valido'
					}
				}
			},
			autore : {
				validators :{
					notEmpty : {
						message : 'Inserisci autore'
					},
					regexp : {
						regexp : /^[A-Za-z _]+$/,
						message : 'Autore non valido'
					}
				}
			},
			editore : {
				validators :{
					notEmpty : {
						message : 'Inserisci editore'
					},
					regexp : {
						regexp : /^[A-Za-z _]+$/,
						message : 'Editore non valido'
					}
				}
			},
			anno : {
				validators : {
					notEmpty : {
						message : 'Inserire anno'
					},
					between : {
						min : 1920,
						max : new Date().getFullYear(),
						message : "L'anno deve essere tra il 1920 e il "+new Date().getFullYear()
					}
				}
			},
			corso : {
				validators : {
					notEmpty: {
						message: 'Selezionare un corso'
					}
				}
			},
			prezzo : {
				validators : {				
					notEmpty : {
						message: 'Inserire il prezzo'
					},
					regexp : {
						regexp : /^[1-9]\d*(((,\d{3}){1})?(\.\d{0,2})?)$/,
						message : 'Prezzo non valido'
					}
				}
			},
			textarea : {
				validators : {
					notEmpty : {
						message : 'Inserire descrizione'
					}
				}
			}
		}
	});
	 */




function hideLoadingPage(){            //NASCONDE LA LOADING GIF 
	if (document.getElementById) { 
		document.getElementById('hidepage').style.visibility = 'hidden'; 
	} 
}

$(document).ready(function(){
	$('#checkAnnuncio').click(function(){    //appena viene cliccato il pulsante "inserisci annuncio
		var titolo = $('#titolo').val();	 //vengono presi i parametri dalla form
		var autore = $('#autore').val();
		var editore = $('#editore').val();
		var anno = $('#anno').val();
		var condizione = document.insertform.condiz;
		var cond = condizione.value;
		var prezzo = $('#prezzo').val();
		var cor = document.insertform.corso;
		var corso = cor.value;
		var descrizione = $('#textarea-libro').val();
		
		var email = document.getElementById('user').value;
		
		var path2 = document.getElementById('pr').value;
		
		//PATHFILE:http://localhost:8080/usu/res/imagesAnnuncio/...
		var pathFile = document.getElementById('image').src;

		if(checkTitle(titolo)){
			if(checkAutore(autore)){
				if(checkEditore(editore)){
					if(checkAnno(anno)){
						if(checkCondizione(condizione)){
							if(checkPrezzo(prezzo)){
								if(checkCorso(cor)){
									if(checkDescrizione(descrizione)){
										if (document.getElementById) {      //rende visibile la loading gif
											document.getElementById('hidepage').style.visibility = 'visible'; 
										} 
										$.ajax({            //chiamata ajax alla servlet
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
												"path":path2,
												"email":email,
												azione:"inserisciAnnuncio"	
											},
											url:'GestoreLibriServlet',
											success: function(){
												alert('INSERIMENTO EFFETTUATO');
												location.href='GestoreLibriServlet?azione=visualizzaMieiAnnunci';
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
	});
});

function checkTitle(titolo){
	var lett="^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$"
	var numb = /^[0-9]+$/;
	if(titolo==""){
		alert('Il campo titolo è vuoto');
		return false;
	}
	if(titolo.match(numb)){
		alert('Il titolo deve contere anche caratteri');
		return false;
	}
	if(titolo.match(lett)){
		return true;
	}else{
		alert('Titolo non valido');
		return false;
	}
}

function checkAutore(autore){
	var letters = /^[A-Za-z _]+$/;
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
	var letters = /^[A-Za-z _]+$/;
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
