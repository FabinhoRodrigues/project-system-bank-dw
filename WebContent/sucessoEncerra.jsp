<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Solicitação de Conta</title>
<style>
body {
		background-color: #F2F2F2;
	 }
</style>
</head>
<body>

<br><br><br>
<center><h1>Conta encerrada com sucesso! </h1></center><br>

<%
session.setMaxInactiveInterval(2);
%>
 <center><h4><a href="login.jsp">Home</a></h4></center>
</body>
</html>