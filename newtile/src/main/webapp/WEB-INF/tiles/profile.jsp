<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
              
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
<body> 
<h1 class="card-header mt-4 bg-primary text-center">Hi,${usersession}</h1>
<div class="container mt-4 mb-4 p-3 d-flex justify-content-center ">
 <div class="card w-75 p-3 mb-4 bg-primary "  >
 
  <c:set var="Amount" value="${profile.UID}"  scope="application" />  
       
    <fmt:parseNumber var="id" integerOnly="true" type="number" value="${Amount}" />

<img src="<%=request. getContextPath( )%>/image/${id}" class="card img-fluid" style="width:150px"   alt=" " >

<br>
 <h3><strong>UserName:  </strong>   ${profile.username}</h3>
 <br>
<h3> <strong>Email:   </strong> ${profile.email}</h3>
<br>
<h3><strong>Mobile Number:   </strong>${profile.monumber}</h3>
<br>
<h3><strong>Hobbies:   </strong>${profile.hobbies}</h3>
<br>
<h3><strong>State:   </strong>${profile.state}</h3>
<br>
<h3><strong>City:   </strong>${profile.city}</h3>
<br>
<h3><strong>Lanuages:   </strong>${profile.languages}</h3>

  
   <a href="<%=request. getContextPath( )%>/editemp/${profile.UID}" class="badge badge-success" name="page" >Edit</a>
  
   
</div>

</div>




 
  

   

<script type="text/javascript"   src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>