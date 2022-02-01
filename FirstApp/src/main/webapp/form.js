$(document).ready(function () {
	$('#personal').click(function(){
	
	
	console.log("personal click");
	
	perosnalInfo(event);
});


	$('#address').click(function(){
	
	
	console.log("Address click");
	
	adressInfo(event);
});


	$('#occupation').click(function(){
	
	
	console.log("Occupation click");
	
	
	
	ocuupationInfo(event);
});






});






function perosnalInfo(e)
{   
    e.preventDefault();
	
	
      	let  username= $('#username').val();
      	
      	let  email= $('#email').val();
      	
      	let  pass= $('#pass').val();
      	
      	let  numm= $('#num').val();
	var num=parseInt(numm);
	
	console.log("Personl"+ typeof num);
	$.ajax({
	
	type:'post',
	url: '/form/personal?username='+username+'&email='+email+'&pass='+pass+'&num='+num,        
	success:function(data){
	
	
   console.log(data);
      
	    $('#username').val(data[0]).attr("disabled",true);
	
	$('#email').val(data[1]).attr("disabled",true);

   $('#pass').val(data[2]).attr("disabled",true);
   $('#num').val(data[3]).attr("disabled",true);
	    $('#ss').text(data);
   
	},
	error:function(){
		
		console.log(error);
	}
	
});
	
	
}


function adressInfo(e)
{
	  e.preventDefault();
	
	console.log("adress");
	
	
	      	let  street= $('#street').val();
      	
      	let  state= $('#state').val();
      	
      	let  city= $('#city').val();
      	
      	let  pincode= $('#pincode').val();
	
	
	console.log("Adress");
	$.ajax({
	
	type:'post',
	url: '/form/adress?street='+street+'&state='+state+'&city='+city+'&pincode='+pincode,        
	success:function(data){
	
	
   console.log(data);
      
	    $('#street').val(data[0]).attr("disabled",true);
	
	$('#state').val(data[1]).attr("disabled",true);

   $('#city').val(data[2]).attr("disabled",true);
   $('#pincode').val(data[3]).attr("disabled",true);
	    $('#ss1').text(data);
   
	},
	error:function(){
		
		console.log(error);
	}
	
});
	
	
	
}


function ocuupationInfo(e)
{
	
	console.log("Ocuupation");
	 e.preventDefault();
	
	console.log("adress");
	
	
	      	let  comname= $('#comname').val();
      	
      	let  role= $('#role').val();
      	
      	let  loc= $('#loc').val();
      	
	
	
	console.log("Adress");
	$.ajax({
	
	type:'post',
	url: '/form/occupation?comname='+comname+'&role='+role+'&loc='+loc,        
	success:function(data){
	
	
   console.log(data);
      
	    $('#comname').val(data[0]).attr("disabled",true);
	
	$('#role').val(data[1]).attr("disabled",true);

   $('#loc').val(data[2]).attr("disabled",true);

	    $('#ss2').text(data);
   
	},
	error:function(){
		
		console.log(error);
	}
	
});
}


jQuery.validator.addMethod("exactlength", function(value, element, param) {
 return  value.length == param;
 
 console.log("in valida method");
}, $.validator.format("Please enter exactly {0} characters."));



jQuery.validator.addMethod("pwcheck", function(value,element) {
   return this.optional(element) || /^[A-Za-z0-9\d=!\-@._*]*$/.test(value)
       && /[a-z]/.test(value) 
       && /[A-Z]/.test(value) 
       && /\d/.test(value) 
});





jQuery('#frm1').validate({
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
	exactlength:10,
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
	
	
	}
	
});









