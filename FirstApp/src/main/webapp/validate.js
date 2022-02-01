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
	url: 'http://localhost:8082/city/'+cityidd,        
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
}
	
	
	},submitHandler:function(form){
		
		form.submit();
	}
	
});













function validatee(){
		
		let f=false;
 // Username validation
		let name=$(".username").val();
		if(name==""||name==undefined){
			
			$(".form-name-msg")
			   .html("Name is required")
			   .addClass("text-danger");
			f=false;
		}else if(name.length<3 ||name.length>8)
		{
			$(".form-name-msg")
			   .html("length must be greater than 2 letters and less than 8  letters")
			   .addClass("text-danger");
			   f=false;
		}
		else{
			$(".form-name-msg")
			   .html("ok")
			   .removeClass('text-danger').addClass("text-success");
			f=true;
			}
			
// Email validation
		
		let email=$(".email").val();
		let exp=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(email==""||email==undefined)
		{
			$(".form-email-msg")
			   .html("Email is required")
			   .addClass("text-danger");
			   f=false;
	     }else if(exp.test(email)==false)
	     {
		 $(".form-email-msg")
			   .html("Invalid Email,Email must be in correct format(example@gmail.com)")
			   .addClass("text-danger");
			   f=false;
	    }else{
		
		$(".form-email-msg")
			   .html("ok")
			   .removeClass('text-danger').addClass("text-success");
			f=true;	
     	}
    
 // Password validation
 
    let pass =$(".pass").val();
    let exp1=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
    	if(pass==""||pass==undefined)
		{
			$(".form-pass-msg")
			   .html("Password is required")
			   .addClass("text-danger");
			   f=false;
	     }else if(exp1.test(pass)==false)
	     {
		$(".form-pass-msg")
			   .html("Password is invalid, Password must contain 1 Uppercase letter,1 Lowercase Letter, 1 specail character,1 digit ,length must to be 6 to 20 characters")
			   .addClass("text-danger");
			   f=false;
	}else{
		
		$(".form-pass-msg")
			   .html("ok")
			   .removeClass('text-danger').addClass("text-success");
			f=true;
	}
	 	// Number  validation
		  let num =$(".num").val();
		  let exp2=/^[0-9]+$/
		  if(num==""||num==undefined)
		{
			$(".form-num-msg")
			   .html("Number is required")
			   .addClass("text-danger");
			   f=false;
	     }else if(exp2.test(num)==false)
	     {
		    	$(".form-num-msg")
			   .html("Phone Number is invalid,it must be of 10 digit....")
			   .addClass("text-danger");
			   f=false;
	     }else if(num.length==10){
	        
			f=true;
		
	      }else
	      {
		$(".form-num-msg")
			   .html("Phone Number is invalid,it must be of 10 digit....")
			   .addClass("text-danger");
			   f=false;
	}

// Hobbies  validation
        let hobbies=$(".hobbies").val();
		if(hobbies==""||hobbies==undefined){
			
			$(".form-hobbies-msg")
			   .html("Hobbies are required")
			   .addClass("text-danger");
			f=false;
		}else if(hobbies.length<3 ||hobbies.length>20)
		{
			$(".form-hobbies-msg")
			   .html("length must be greater than 2 letters and less than 20  letters")
			   .addClass("text-danger");
			   f=false;
		}
		else{
			$(".form-hobbies-msg")
			   .html("ok")
			   .removeClass('text-danger').addClass("text-success");
			f=true;
			}	
			
// City  validation			
let city=$(".city").val();
	 if(city=="Mumbai"||city=="Pune"||city=="Hydrabad"||city=="Banglore"||city=="Delhi")
	{
			$(".form-city-msg")
			   .html("ok")
			   .removeClass('text-danger').addClass("text-success");
			
		f=true;
		
		
	}else
	{
		$(".form-city-msg")
			   .html("Must Select Ur City")
			   .addClass("text-danger");
			f=false;
	}
	
// Gender  validation
    
    if($('input[type=radio][name=Gender]:checked').length==0)
       {
	$(".form-gender-msg")
			   .html("Must Select Your Gender")
			   .addClass("text-danger");
			f=false;
	
   }else{
	f=true;
	
    }
// Gender  validation
  if($('input[type=checkbox][name=Languages]:checked').length==0)
       {
	$(".form-lang-msg")
			   .html("Must Select Your Programming Laungagues")
			   .addClass("text-danger");
			f=false;
	
   }else{
	f=true;
	
    }
		return f;
		
	}  
	
	

	
	