<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.css">



</head>
<body>
<div class="container mt-4 mb-4 p-3 d-flex justify-content-center ">

 
<form id="userimg" method="post" class="card w-75 p-3 "  enctype="multipart/form-data"  > 
<div align="left">
   
 <input type="file" id="file" name="file" class="dropify" data-default-file=""  >


</div>
<div align="right"> 
  
  <button type="button" id="save" class="btn btn-success " onclick="addPhoto()" >Upload</button>
</div>
 
 
 
 </form>

</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/js/dropify.min.js"></script>
<script src="drop.js"></script>
</body>


</html>










