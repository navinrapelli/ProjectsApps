$(document).ready(function(){
	console.log("in")


jQuery.validator.addMethod("pwcheck", function(value,element) {
   return this.optional(element) || /^[A-Za-z0-9\d=!\-@._*]*$/.test(value)
       && /[a-z]/.test(value) 
       && /[A-Z]/.test(value) 
       && /\d/.test(value) 
});









	
	
	jQuery('#frmm').validate({
	rules:{
		username:{required:true},
		password:{required:true,
		pwcheck:true},
		
		
	},
	messages:{
		
			username:{required:"must enter the username"},
		password:{required:"must enter the password",
		          				pwcheck:"Must Contain one upper  case and lower case letter and one digit and one special character"
},

		
		
		
		
	},submitHandler:function(form){
		
		form.submit();
	}
	
	
	
	
	
	
	
})	;
	
	
	
	
	
	
	
});




