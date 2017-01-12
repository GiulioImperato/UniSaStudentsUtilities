$(document).ready(function(){   
 	$('#file').change(function(){             //appena viene cliccato il pulsante "scegli_foto"
 		uploadFile();
	});
});

function uploadFile() {
	var form = document.getElementById('insertform');
	var data = new FormData(form);    	     //viene preso il file dalla form
	postFilesData(data); 
}

function postFilesData(data) {
	$.ajax({                     //chiamata alla servlet 
		url :  'UploadImage',
		type : 'POST',
		data : data,
		cache : false,
		dataType : 'text',
		processData : false,
		contentType : false,
		success : function(result) {
			$("#pr").attr("value",result);         //viene salvato il src dell'immagine
			$("#image").attr("src",result);        //viene mostrata l'immagine
		},
		error : function(result) {
			alert('ERRORS:');
		}
	});
}



