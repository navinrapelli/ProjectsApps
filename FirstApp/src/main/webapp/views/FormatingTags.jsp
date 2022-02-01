<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %> 
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
   <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page import="java.util.Date,java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formating Tags</title>
</head>
<body>
<h1>Formating Tags</h1>
<hr>

<!-- Parse Number which string representation of number  -->


<c:set var="Amount" value="786.970" />  
  
    <fmt:parseNumber var="j" type="number" value="${Amount}" />  
    <p><i>Amount is:</i>  <c:out value="${j}" /></p>  
  
    <fmt:parseNumber var="j" integerOnly="true"  type="number" value="${Amount}" />  
    <p><i>Amount is:</i>  <c:out value="${j}" /></p>  
    
    
    <hr>

<!-- formatNumber -->
    
    <c:set var="Amount" value="${usernumber}" />  
    <p><c:out value="${Amount }"></c:out></p>
<p> Formatted Number-1 currency:  
<fmt:formatNumber value="${Amount}" type="currency" /></p>  
<p>Formatted Number-2:  
<fmt:formatNumber type="number" groupingUsed="true" value="${Amount}" /></p>  
<p>Formatted Number-3:  
<fmt:formatNumber type="number" maxIntegerDigits="3" value="${Amount}" /></p>  
<p>Formatted Number-4:  
<fmt:formatNumber type="number" maxFractionDigits="6" value="${Amount}" /></p>  
<p>Formatted Number-5:  
<fmt:formatNumber type="percent" maxIntegerDigits="4" value="${Amount}" /></p>  
<p>Formatted Number-6:  
<fmt:formatNumber type="number" pattern="###.###$" value="${Amount}" /></p>  

<hr>
<!-- parseDate used to formate date -->
<c:set var="date" value="12-08-2016" />  
  
<fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />  
<p><c:out value="${parsedDate}" /></p>  

<hr>
<!-- Formate Date -->
<c:set var="today" value="<%= new java.util.Date() %>"></c:set>
<br>type="time"=> <fmt:formatDate type="time" value="${today }"/>
<br>type="date"=> <fmt:formatDate type="date" value="${today }"/>
<br>type="both"=> <fmt:formatDate type="both" value="${today }"/>
</body>
</html>