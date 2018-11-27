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
<h3><a href="login.jsp">Voltar Login</a></h3>
<br><br><br>
<center><h1>Conta criada com sucesso! Obrigado</h1>  <h1> pela preferência! </h1></center><br>
<center><h4>Cliente CPF :</h4> ${cliente}</center><br>
<center><h4>Número de Conta :</h4> ${numero}</center><br>
<center><h4>Agência :</h4> ${agencia}</center><br>      


 <br>
 
</body>
</html>