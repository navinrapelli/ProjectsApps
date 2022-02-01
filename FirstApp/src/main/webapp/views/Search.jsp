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
<title>Serach List</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<h1 class="bg-info">Search List</h1>
<table id="example" class=" display table-warning table-striped" style="width":100%>
<thead>
  <tr>
    <th>UID</th>
      <th>Username</th>
        <th>Email</th>
          <th>Gender</th>
            <th>Monumber</th>
              <th>Hobbies</th>
               <th>State</th>
              <th>City</th>
              <th>Languages</th>
              <th>Edit</th>
              <th>Delete</th>
              <th>image</th>
        
              
  
  
  </tr>

</thead>
<tbody>

 <c:forEach var="userr" items="${resultt}" >   
   <tr class="table-danger" >  
     <td ><a style="color:black" href="pro/${userr.UID}"  > ${userr.UID}</a></td>
      <td><a style="color:black" href="pro/${userr.UID}"  > ${userr.username}</a></td>
      <td> <a style="color:black" href="pro/${userr.UID}"  > ${userr.email}</a></td>
      <td> <a style="color:black" href="pro/${userr.UID}"  > ${userr.gender}</a></td>
      <td><a style="color:black" href="pro/${userr.UID}"  > ${userr.monumber}</a></td>
       <td><a style="color:black" href="pro/${userr.UID}"  > ${userr.hobbies}</a></td>
        <td> <a style="color:black" href="pro/${userr.UID}"  > ${userr.state}</a></td>
        <td> <a style="color:black" href="pro/${userr.UID}"  > ${userr.city}</a></td>
        <td> <a style="color:black" href="pro/${userr.UID}"  > ${userr.languages}</a></td>
     
             <c:set var="page" value="second" scope="application"></c:set>
         <td><a href="editemp/${userr.UID}/${page}" class="badge badge-primary"  >Edit</a></td> 
   <td><a href="deleteemp/${userr.UID}/${page}" class="badge badge-primary"  onclick="return confirm('Are you sure you want to delete this item?');" >Delete</a></td>
          <td><img src="image/${userr.UID}" class="card img-fluid" style="width:150px"   alt=" " ></td>
   </tr> 
    
    

   </c:forEach>  
   
</tbody>
<tfoot>
   <tr>
    <th>UID</th>
      <th>Username</th>
        <th>Email</th>
          <th>Gender</th>
            <th>Monumber</th>
              <th>Hobbies</th>
               <th>State</th>
              <th>City</th>
              <th>Languages</th>
                      <th>Edit</th>
              <th>Delete</th>
              <th>image</th>
              
             
              
  
  
  </tr>



</tfoot>



</table>

<script type="text/javascript"   src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script type="text/javascript"    src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<script src="Serachhh.js"></script>
</body>
</html>