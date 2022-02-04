<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                  
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<base href="/" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container bg-primary bg-opacity-25 mt-4 mb-4"">

<h1>hi,${usersession}</h1>


<h1 class="card-header bg-bg-primary text-center " id="nav">Update User</h1>
<form  id="frmupdate"  action="<%=request. getContextPath( )%>/save/${up.UID}" method="POST" enctype="multipart/form-data">
User Name:<input type="text" class="form-control name" name="Username"  value="<c:out value='${up.username}'></c:out>"/>
 <small class="form-text text-danger m1-2 form-name1-msg"></small><br><br>
Email ID: <input type="email" class="form-control email" name="Email" value="<c:out value='${up.email}'></c:out>" />
 <small class="form-text text-danger form-email-msg m1-2"></small><br><br>
Password: <input type="password" class="form-control pass" name="Pass" value="<c:out value='${up.pass}'></c:out>"/>
<small class="form-text text-denger m1-2 form-pass-msg"></small><br><br>
Mobile Number: <input type="number" class="form-control num" name="Monumber" value="<c:out value='${up.monumber}'></c:out>"/>
  <small class="form-text text-denger m1-2 form-num-msg"></small><br><br>
State: <select name="State" id="state"  class="form-control form-control-lg state">
            <option selected=""value="Default">(Please select a UR state)</option>
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
Role:<select name="Role" id="role" class="form-control  form-control-lg role">
                 <option selected="" value="Default">(Please select a UR role)</option> 
                 <option value="ROLE_ADMIN">Admin</option>
                 <option value="ROLE_USER">User</option>
        </select>
        <br>
        <small class="form-text form-city-msg text-denger m1-2"></small><br>
        <br>
Select Programming Laungaues:
<br>
<input type="checkbox" name="Languages" value="Java"/>Java<br>
                  <input type="checkbox" name="Languages" value="C++"/> C++<br>
                  <input type="checkbox" name="Languages" value="JavaScript"/>Java Script<br>
                  <small class="form-text text-denger form-lang-msg  m1-2"></small>
                  <br>
Hobbies:<textarea rows="2" cols="2" class="form-control hobbies" name="Hobbies"  >${up.hobbies}</textarea>
<small class="form-text text-denger form-hobbies-msg  m1-2"></small><br><br>
Gender:<input type="radio" name="Gender" value="male"/>Male
<input type="radio" name="Gender" value="female" />Female<br>
<small class="form-text text-denger form-gender-msg  m1-2"></small><br>
<br>
User image<input type="file" class="form-control img" name="image"/>
         <small class="form-text text-danger m1-2 form-name-msg"></small><br>


<input type="submit" class="btn btn-success om"  value="update" />

</form>
<br> 

<button type="button" class="badge badge-primary" name="back" onclick="history.back()">Back</button>
</div>


<script type="text/javascript"   src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script type="text/javascript"  src="validateupdate.js"></script>
<script  src="<%=request. getContextPath( )%>/validate.js"></script>
<script>var ctx = "${pageContext.request.contextPath}"</script>


</body>
</html>