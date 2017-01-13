function disabilitaAccount(data) {
	$.ajax({                     //chiamata alla servlet 
		url :  'AdminListaUtenti',
		type : 'POST',
		data : {data:data},
		cache : false,
		dataType : 'text',
		success : function(result) {
			console.log("disabilitaAccountYes");
		},
		error : function(result) {
			alert('ERRORS:');
		}
	});
}
