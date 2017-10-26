  $(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            first_name: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Моля въведете първо име'
                    }
                }
            },
             last_name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Моля въведете фамилия'
                    }
                }
            },
			 user_password: {
                validators: {
                     stringLength: {
                        min: 8,
                        message: 'Минимум 8 символа'
                    },
                    notEmpty: {
                        message: 'Моля въведете парола '
                    }
                }
            },
			confirm_password: {
                validators: {
                     stringLength: {
                        min: 8,
                        message: 'Минимум 8 символа'
                    },
                    notEmpty: {
                        message: 'Моля потвърдете паролата'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Моля въведете Email'
                    },
                    emailAddress: {
                        message: 'Моля въведете валиден Email'
                    }
                }
            },
            
            contact_no: {
                validators: {
                  stringLength: {
                        min: 15, 
                        max: 15,
                  },
                    notEmpty: {
                        message: 'Моля въведете номер (+359)*********'
                     }
                },
                }
            }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});

