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
<title>Main User List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class=" bg-light">
<h1></h1>
<h1 class="card-header bg-primary text-center">Users List</h1>  
<table class="table" border="2" width="70%" cellpadding="2">  
<th>Username</th><th>Email</th><th>Gender</th><th>Mobile Number</th><th>Hobbies</th></th><th>State</th><th>City</th></th><th>Programming Languages</th></th><th>Edit</th></th><th>Delete</th><th>Image</th>
   <c:forEach var="user" items="${result}" >   
   <tr>  
     
      <td  >${user.username}</td>
      <td>${user.email}</td>
      <td>${user.gender}</td>
      <td>${user.monumber}</td>
       <td>${user.hobbies}</td>
       <td>${user.state}</td>
        <td>${user.city}</td>
        <td>${user.languages}</td>
        <c:set var="Amount" value="${user.UID}" />  
        <c:set var="page" value="first" scope="application"></c:set>
    <fmt:parseNumber var="id" integerOnly="true" type="number" value="${Amount}" />  
   <td><a href="editemp/${id}/${page}" class="badge badge-primary" name="page" >Edit</a></td> 
   <td><a href="deleteemp/${id}/${page}" class="badge badge-primary " onclick="return confirm('Are you sure you want to delete this item?');"   >Delete</a></td>  
          <td><img src="image/${id}" class="card img-fluid" style="width:150px"   alt=" " ></td>
   </tr> 
    
    
    <c:set var="useruid" value="${user.UID}" scope="application"></c:set>
<c:set var="username"  value="${user.username}" scope="application" ></c:set>

    
<c:set var="useremail" value="${user.email}" scope="application" ></c:set>
    
<c:set var="usercity" value="${user.city}" scope="application" ></c:set>
    
<c:set var="usernumber" value="${user.monumber}" scope="application" ></c:set>

   </c:forEach>  
   

   
 </table>  
   <br/>  
  
   <a href="regform" class="badge badge-primary"   >Add New User</a>  
   
     
   <a href="login" class="badge badge-primary"   >Log In</a>

   <br>
   <br>
   </div>

   

<script type="text/javascript"   src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>