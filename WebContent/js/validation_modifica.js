$("#password_modifica,#confirmpassword_modifica").keyup(function(){
	var s = $("#password_modifica").val().toLowerCase();
	var s1 = $("#confirmpassword_modifica").val().toLowerCase();

	if(s===s1)
	{
		if(s!="" && s1!="" )
			{
				$("#update").attr("disabled",false);
			}
	}
	else
		{
			$("#update").attr("disabled",true);
		}
	
});