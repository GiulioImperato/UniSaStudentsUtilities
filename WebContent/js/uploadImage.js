/*function uploadImage(){
	var sampleFile = document.getElementById("file").files[0];
	var formdata = new FormData();
	formdata.append("file", sampleFile);

	var xhr = new XMLHttpRequest();
	xhr.open("POST","UploadImage", true);
	xhr.send(formdata);
	//$("#image").attr("src","res/imagesAnnunci/img8620544915257090012.jpg");

}*/
$(document).ready(function(){
	$('#submit').click(function(){
		$('#insertform').on('submit',uploadFile);
	});
});

function uploadFile(event) {
	event.stopPropagation();
	event.preventDefault();
	var form = document.getElementById('insertform');
	var data = new FormData(form);
	postFilesData(data);
}

function postFilesData(data) {
    $.ajax({
        url :  'UploadImage',
        type : 'POST',
        data : data,
        cache : false,
        dataType : 'text',
        processData : false,
        contentType : false,
        success : function(result) {
            alert("Result "+result);
            $("#image").attr("src","res/imagesAnnunci/img3543645274340791414.jpeg");
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert('ERRORS: ' + textStatus);
        }
    });
}

/*$(document).ready(function(){	
	$('#loadFile').click(function(){
        $("form#insertform").attr('enctype', "multipart/form-data");
        $("form#insertform").attr("file", $('#file').val());
        $('inserform').submit(); //upload button 

		$.ajax({
			type:'POST',
			url:'UploadImage',
            async: false,
            dataType:"text",
			success: function(){
				alert('INSERIMENTO EFFETTUATO');
			}
		})
	});
});*/