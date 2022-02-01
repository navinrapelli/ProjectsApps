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
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
<body> 
<h1 class="card-header bg-info text-center">Hi,${usersession}</h1>
<div class="container mt-4 mb-4 p-3 d-flex justify-content-center ">
 <div class="card w-75 p-3 bg-info "  >

<img  alt=" " src="image/${profile.UID}" height="100" width="100">
<br>
 <h3><strong>UserName:  </strong>   ${profile.username}</h3>
 <br>
<h3> <strong>Email:   </strong> ${profile.email}</h3>
<br>
<h3><strong>Password:   </strong>${profile.pass}</h3>
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

  
   <a href="/editemp/${profile.UID}/third" class="badge badge-primary" name="page" >Edit</a>
  
   
</div>
</div>


<br>
<button type="button" class="badge badge-primary" name="back" onclick="history.back()">Back</button>
 <br>
 
    <a href="/main" class="badge badge-prima" >Main</a>
   
    <a href="/userr" class="badge badge-prima" >Reg</a>
   

</body>
</html>