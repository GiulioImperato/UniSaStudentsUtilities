$('#ajax-register-form').bootstrapValidator({
//        live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nome: {
                validators: {
                    notEmpty: {
                        message: 'Inserisci nome'
                    }
                }
            },
			cognome: {
                validators: {
                    notEmpty: {
                        message: 'Inserisci cognome'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Inserisci l\'email'
                    },
                    emailAddress: {
                        message: 'Email non valida'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'Inserisci la password'
                    }
                }
            },
			confirmpassword:{
				validators:{
					notEmpty:{
						message:'Inserisci conferma password'
					},
					identical:{
						field: 'password',
						message:'La password è diversa'
					}
				}
			}
        }
    });