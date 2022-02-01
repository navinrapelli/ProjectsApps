<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL example</h1>


<c:set var="i" value="23" scope="application" ></c:set> <!-- set tag is used to define the vlues -->

 <h2><c:out value="${i}"></c:out></h2>      <!-- out tag : is used to print output
 -->
      <!-- out tag : is used to print output
 -->
  <!--  tag is used to remove the varibale value -->
 
 
 
<!-- if tag used to test when he true he will run -->
<c:if test="${i==23 }">

<h1>yes i is 23 and condition is true</h1>
<p>this parvagraph how are you</p>
</c:if> 

<c:forEach var="j"  begin="1" end="10" >
  
  <h1>value of j is <c:out value="${j}"></c:out> </h1>
  
</c:forEach>



 <!-- used to redirect to particular page -->
   <c:url var="myurl" value="wel">
  <c:param name="q" value="learn code with navin"></c:param>
</c:url>  
 <h2><c:out value="${myurl}"></c:out></h2> 
 
 <c:redirect url="${myurl}"></c:redirect>    
 
 
 

  <c:import  var="data" url="wel"></c:import> <c:out value="${data }"></c:out>     

</body>
</html>