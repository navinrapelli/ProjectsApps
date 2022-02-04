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

