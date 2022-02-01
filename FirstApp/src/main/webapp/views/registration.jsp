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
<style >

.error {
  color: #F00;

}
.c{

  border:2px red ridge;
}
</style>
<title>Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container bg-info">
<h1 class="card-header bg-bg-primary text-center ">ADD USER</h1>
<form  id="frm"  action="add" method="POST" enctype="multipart/form-data">
User Name<input type="text" class="form-control username" name="Username"/>
         <small class="form-text text-danger m1-2 form-name-msg"></small><br>
Email ID <input type="email" class="form-control email" name="Email"/><br>
         <small class="form-text text-danger form-email-msg m1-2"></small><br>
Password <input type="password"class="form-control pass" name="Pass"/><br>
         <small class="form-text text-denger m1-2 form-pass-msg"></small><br>
Mobile Number <input type="number" class="form-control num" name="Monumber"/><br>
         <small class="form-text text-denger m1-2 form-num-msg"></small><br>
State:  <select name="State" id="state"     class="form-control  form-control-lg city">
                 <option selected="" value="Default">(Please select a UR State)</option>
        
        
          <c:forEach items="${statess}" var="state">
                 <option value="${state.stateid}">${state.statename}</option>
          </c:forEach>     
               
        </select>
        <br>
        <small class="form-text form-city-msg text-denger m1-2"></small><br>
        <br>
City:<select name="City" id="city" class="form-control  form-control-lg city">
                 <option selected="" value="Default">(Please select a UR City)</option> 
     
        </select>
        <br>
        <small class="form-text form-city-msg text-denger m1-2"></small><br>
        <br>
Select Programming Laungaues
<br>
<br>
<input type="checkbox"  name="Languages" value="Java"/>Java<br>
                  <input type="checkbox" name="Languages" value="C++"/> C++<br>
                  <input type="checkbox" name="Languages" value="JavaScript"/>Java Script<br>
                  <label for="Languages" class="error" style="display:none;"></label>
<small class="form-text text-denger form-lang-msg " id="om" m1-2"></small><br>
<br>

<br>
Hobbies:<textarea class="form-control hobbies" rows="2" cols="2" name="Hobbies"></textarea>
<small class="form-text text-denger form-hobbies-msg  m1-2"></small><br>
<br>
Gender:<input type="radio" name="Gender" value="male" />Male
<input type="radio" name="Gender" value="female" />Female
<br>
<label for="Gender" class="error" style="display:none;"></label>
<small class="form-text text-denger form-gender-msg  m1-2" id="ome"></small><br>
<br>
User image<input type="file" class="form-control img" name="image"/>
         <small class="form-text text-danger m1-2 form-name-msg"></small><br>
<input type="submit" class="btn btn-success "  value="ADD user" />
<br>
<br>
<a href="/main" class="badge badge-primary"  >Back</a>
</form>

</div>

<% 



	
	String namee=request.getParameter("Username");
	 
  Cookie c=new Cookie("logname",namee);
	
  out.print(namee);
	response.addCookie(c);


%>


<script type="text/javascript"   src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script src="validate.js"></script>
</body>

</html>