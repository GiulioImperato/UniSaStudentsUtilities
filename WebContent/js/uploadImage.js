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
			$("#image").attr("src",result);
			var src = document.getElementById('image').src;
			alert('NEW SRC'+src);
		},
		error : function(result) {
			alert('ERRORS:');
		}
	});
}



