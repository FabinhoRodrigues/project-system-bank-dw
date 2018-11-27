
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Extrato</title>
<style>
body {
		background-color: #F2F2F2;
	 }
</style>
</head>
<body>


<div>
 <jsp:include page="menu.jsp" /> 
</div>
<br>
<br>
<h5>Cliente </h5>
<div class="card">
  <div class="card-body">${nome}</div>
</div><br>

<h5>CPF </h5>
<div class="card">
  <div class="card-body">${cpf}</div>
</div><br>

<h5>Agência </h5>
<div class="card">
  <div class="card-body">${agencia}</div>
</div><br>

<h5>Conta </h5>
<div class="card">
  <div class="card-body">${conta}</div>
</div><br>

<h5>Saldo </h5>
<div class="card">
  <div class="card-body">${saldo}</div>
</div><br>

<%@ page import="br.com.sistema.model.Extrato" %>
<%@ page import="java.util.List" %>
<%
List<Extrato> lista = (List<Extrato>)session.getAttribute("lista");
%>


<h5>Movimentações</h5><br>

<table class="table">
	<thead>
		<tr>
			<th scope="col">Transação</th>
			<th scope="col">Data</th>
			<th scope="col">Conta Origem</th>
			<th scope="col">Conta Destino</th>
			<th scope="col">Valor</th>
		</tr>
	</thead>
	
	<tbody>
		<% for(Extrato l : lista ){ %>
			<tr>
				<td><% out.print(l.getTransacao()); %></td>
				<td><% out.print(l.getDataExtrato()); %></td>
				<td><% out.print(l.getContaOrigem()); %></td>
				<td><% out.print(l.getContaDestino()); %></td>
				<td><% out.print(l.getValor()); %></td>
			</tr>
		<% } %>
	</tbody>
</table>
  

</body>
</html>