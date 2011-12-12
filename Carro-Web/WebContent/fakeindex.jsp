<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String user = session.getAttribute("user").toString(); 
    Boolean admin = (Boolean)session.getAttribute("admin");
   %>

<!DOCTYPE html >
<html>
<head>
<meta  http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Programacion Orientada a Objetos</title>
</head>
<body>
<jsp:include page="./index.jsp" >
 <jsp:param name="user" value= "<%= user %>" />
 <jsp:param name="admin" value= "<%= admin %>" />
</jsp:include>
</body>
</html>