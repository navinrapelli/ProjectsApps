<%@ page errorPage="errorpage.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
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
<body>
<%@include file="header.jsp" %>
<h1>Hellow Word</h1>
<%= new java.util.Date() %>

<br>
<%

  String navin="hellow world";
 
  out.println(navin);

%>



<c:forEach var="j" begin="1" end="3">
Item <c:out value="${j}"/><p>  
<c:if test="${j==2}">
  <c:out value="Hi there"></c:out>
</c:if>
</c:forEach>

<hr>

<!-- For each use case -->
<c:forEach var="us" items="${nav}">
     <h1> <c:out value="${us}"></c:out> </h1>
</c:forEach>



<hr>

<!-- Set use case -->
<c:set var="na" value="navin" scope="application"></c:set>
<c:set var="sh" value="shital" scope="application"></c:set>

<hr>
<!-- choose,when,otherwise each use case -->
<!-- choose ,when ,otherwise this 3 tags are used as java switch -->
<c:choose> 
  
  <c:when test="${nav == na}">
     <h3> hi Manager Navin</h3>
  </c:when>
  <c:when test="${nav== sh}">
      <h3>Hi junior manager Shital</h3>
  </c:when>
  <c:otherwise>
   <h3>Deafualt  case </h3>
      <h1>Hi sir</h1>
 </c:otherwise> 
</c:choose>
<hr>


<!-- for tokens i used to irrated over string -->
<c:forTokens items="Navin-Pavan-Shital" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens> 

 <hr>
<c:catch var ="catchtheException">  
   <% int x = 2/0;%>  
</c:catch>  
  
<c:if test = "${catchtheException != null}">  
   <p>The type of exception is : ${catchtheException} <br />  
   There is an exception: ${catchtheException.message}</p>  
</c:if>  

</body>
</html>