<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
<center>
Welcome to shopping cart</center>
${message }
<a herf="LoginPage">Login</a>
<a herf="RegistrationPage">Register</a>
<c:if test="${isUserClickedLogin =='true'}">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>
<c:if test="${isUserClickedRegister=='true'}">
<jsp:include page="Registration.jsp"></jsp:include>
</c:if>


</body>
</html>