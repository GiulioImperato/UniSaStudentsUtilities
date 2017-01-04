$(document).ready(function(){   
 	$('#submit').click(function(){             //appena viene cliccato il pulsante "carica"
		$('#insertform').on('submit',uploadFile);
	});
});

function uploadFile(event) {            //viene preso il file dalla form
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('insertform');
	var data = new FormData(form);
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



