<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body> 
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
  <div class="container-fluid">
       <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <h4> <a class="nav-link "  href="<%=request. getContextPath( )%>/profileadmin/${usersessionid}">Profile</a></h4>   
        </li>
        <li class="nav-item">
        <h4><a class="nav-link" href="<%=request. getContextPath( )%>/main">List</a></h4>   
        </li>
         <li class="nav-item">
          <h4><a class="nav-link" href="<%=request. getContextPath( )%>/logout">Logout</a></h4>      
        </li>
        
   
      
      </ul>
     
    </div>
    
  </div>
</nav>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>