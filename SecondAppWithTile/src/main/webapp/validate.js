
jQuery.validator.addMethod("exactlength", function(value, element, param) {
 return  value.length == param;
}, $.validator.format("Please enter exactly {0} characters."));

jQuery.validator.addMethod("pwcheck", function(value,element) {
   return this.optional(element) || /^[A-Za-z0-9\d=!\-@._*]*$/.test(value)
       && /[a-z]/.test(value) 
       && /[A-Z]/.test(value) 
       && /\d/.test(value) 
});
 $.validator.addMethod("statecheck", function(value, element, arg){
  return arg !== value;
 }, "Please select your State");
 
 
 $.validator.addMethod("filessel", function(value, element, params) {
    var fileCount = element.files.length;
    if(fileCount <= 0){
        return false;
    }
    else{
        return true;
    }
},  'Select the file');

 
jQuery('#frm').validate({
	rules:{
		Username:{required:true,
		  minlength:2
		
		},
	    Email:{
      required: true,
      email: true
    },
    Pass:{
	required:true,
	minlength:5,
	pwcheck:true
},
  Monumber:{
	  	required:true,
	exactlength:10
},
   State:{
	required:true,
	statecheck:"Default"
},Languages:{
            required: true,
            minlength: 1
          },
    Hobbies:{
	
	required:true,
	minlength:5
},
Gender:{
	required:true
},image:{
	 accept: "jpg|jpeg|png|ico|bmp",
	required:true,
	filessel:true
},

  
     
	},messages:{
		
		Username: {
      required: "Please Enter the Name",
      minlength: jQuery.validator.format("At least {0} characters required!")
     
    },
		Email:"Email must be in example@.com format"
	,
	Pass:{
		required: "Please Enter the Password",
      minlength: jQuery.validator.format("At least {0} characters required!"),
		pwcheck:"Must Contain one upper  case and lower case letter and one digit and one special character"
	},
	Languages:{
            required:"please select ur programming language"
          },
             Hobbies:{
	
	required:"please must write your hobbies",
	
},
Gender:{
	required:"must select gender"
},

image:{
	required:"must select the img",
	 accept: "must select"
	
}
	
	
	},submitHandler:function(form){
		
		alert("sucessfully added the user")
		form.submit();
	}
	
});

$(document).ready(function () {
	$('#state').change(function(){


	console.log("changeing");
	getCity();
	$('#city').empty();
	
});


function getCity()
      	{
	
	
      	let  cityidd= $('#state').val();
      	console.log(cityidd);

$.ajax({
	
	type:'get',
	    headers: {
        'Content-Type':'application/json'
    },
	url: ctx+'/city/'+cityidd,        
	success:function(data){
	
	
   console.log(data);
   
       data.forEach(element=>{
	 $('#city').append('<option value="'+element.cityname+'">'+element.cityname+'</option>')
	    
	
	
});
   


	},
	error:function(){
		
		console.log(error);
	}
	
	
	
	
	
	
	
	
	
	
});




};
	


});