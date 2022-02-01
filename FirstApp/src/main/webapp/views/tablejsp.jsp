<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Table Demo</h1>
<hr>
<form   name="form1">
<h2>Enter no: <input name="test" type="text" ></h2>
<input type="submit" value="submit" onclick="showtable(event)" >
</form>

<span id="datatable">


</span>

<script >

function showtable(e){
	
	e.preventDefault();
	
	//alert("clicked");
	var v=document.form1.test.value;
	var url="userr?test="+v;
	
	request=new XMLHttpRequest();
	
	try{
		
		request.open("GET",url,false);
		request.send();
		
		var val=request.responseText;
		document.getElementById('datatable').innerHTML=val;
	}catch(e)
	{
		
		alert("Unable to connect to server")
		
	}
	
}

</script>
</body>
</html>