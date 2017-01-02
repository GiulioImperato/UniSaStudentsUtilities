/*$(document).ready(function(){
	$('#search').click(function(){
		var titolo = $('#searchbar').val();
		alert('Tit'+titolo);
		if(titolo!=""){

			//document.getElementById('tableresult').style.visibility = 'visible';

			$.ajax({            //chiamata ajax alla servlet
				type:'POST',
				data: {
					"titolo":titolo,
					azione:"ricercaAnnunci"	
				},
				url:'GestoreLibriServlet',
				success: function(){
					alert('success');
					$('#tableresult').attr('style','visibility:visible');

				}
			});
		}
	});
});*/