 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<body  >
<div ><h1 class="text-center mt-4 bg-primary">Login</h1></div>
<form  id="frmm"  action="<%=request. getContextPath( )%>/dologin  "  method="post">
<div class="container mt-4 mb-4 p-3 d-flex justify-content-center  "  style="height:400px;">
    <div class= "card w-75 mt-4 p-3 bg-Light" >
  <div class=" mb-3">
    <label for="exampleInputEmail1" class="form-label">Username</label>
    <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
<input type="submit" class="btn btn-primary "  value="Log In" />
<br>
     <a href="regform" class="badge badge-primary"  >Add New User</a>
  </div>
  </div>
</form>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script type="text/javascript" src="validatelog.js"></script>
</body>
</html>