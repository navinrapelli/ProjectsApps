jQuery.validator.addMethod("pwcheck", function(value,element) {
   return this.optional(element) || /^[A-Za-z0-9\d=!\-@._*]*$/.test(value)
       && /[a-z]/.test(value) 
       && /[A-Z]/.test(value) 
       && /\d/.test(value) 
});


jQuery('#frmm').validate({
	rules:{
		Username:{required:true,
		  minlength:2
		
		},
    Pass:{
	required:true,
	minlength:5,
	pwcheck:true}
}, messages:{
		
		Username: {
      required: "Please Enter the Username",
      minlength: jQuery.validator.format("At least {0} characters required!")
     
    },

	Pass:{
		required: "Please Enter the Password",
      minlength: jQuery.validator.format("At least {0} characters required!"),
		pwcheck:"Must Contain one upper  case and lower case letter and one digit and one special character"
	

}

},submitHandler:function(form){
		
		form.submit();
	},


});