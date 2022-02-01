<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style >

.error {
  color: #F00;

}
.c{

  border:2px red ridge;
}
</style>
</head>
<body class="bg-info">
<h1 class="card-header bg-info text-center">Log in</h1>
<br>
<form  id="frmm"  action="profile">
<div class="container mt-4 mb-4 p-3 d-flex justify-content-center ">
    <div class= "card w-75 p-3 bg-Light" >
  <div class=" mb-3">
    <label for="exampleInputEmail1" class="form-label">Username</label>
    <input type="text" name="Usernamee" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" " value="<c:out value='${previousname}'></c:out>">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="Pass" class="form-control" id="exampleInputPassword1">
  </div>
<input type="submit" class="btn btn-primary "  value="Log In" />
<br>



<c:set var="res" value="${resulttt}" scope="application"></c:set>
<h1> <c:out value="${res}"></c:out>  </h1>


    




  <br>
     <a href="regform" class="badge badge-primary"  >Add New User</a>
     
     
  </div>
  </div>
</form>


 

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script src="loginvalidate.js"></script>
</body>
</html>