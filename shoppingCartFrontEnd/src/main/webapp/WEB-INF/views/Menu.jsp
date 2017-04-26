<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse">
<div class="container-fluid">
<ul class ="nav navbar-nav">


<c:forEach var="category" items="categorylist">
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}
</a>
</ul>
</c:forEach>
</div>
</body>
</html>