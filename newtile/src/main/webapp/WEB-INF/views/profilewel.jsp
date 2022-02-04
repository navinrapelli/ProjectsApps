<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

	<div ><tiles:insertAttribute name="headerpro" /></div>
	
		
	<div ><tiles:insertAttribute name="body" />
	
	
	</div>

    <div class="bg-primary mt-4"><tiles:insertAttribute name="footer" /></div>
</body>
</html>