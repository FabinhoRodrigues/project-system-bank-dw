<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
	
	
	
  <% Cliente cliente = (Cliente)session.getAttribute("clienteAutenticado"); %>
  
<center><h3><%out.print("BANCO DW"); %></h3></center>  
<center><h4><% out.print("Seja bem vindo "+ cliente.getNome() + "!");  %></h4></center><br>
	
	<div class="row">
	<%@page import="br.com.sistema.model.Cliente" %>
	
		<div class="col-md-4 offset-md-4">
			<center>
				
				
				<button type="button" class="btn btn-primary btn-lg btn-block"
				onclick="location.href='/trabalho_dw/encerraConta.jsp'">Encerrar Conta</button>
				<button type="button" class="btn btn-primary btn-lg btn-block"
				onclick="location.href=' ExtratoServlet' ">Extrato</button>
				

			</center>
			<br><center>
				<h4>ACESSO ATM</h4>
			</center><br>
			<button type="button" class="btn btn-primary btn-lg btn-block"
			onclick="abreSaque()" >Saque</button>
			
			<button type="button" class="btn btn-primary btn-lg btn-block"
			onclick="abreDeposito()" >Deposito</button>
			
			<button type="button" class="btn btn-primary btn-lg btn-block"
			onclick="abreTransferencia()" >Transferência</button>
		</div>
	</div>

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script>
function abreSaque(){
	window.open('saque.jsp','teste','scrollbars=yes, menubar=yes, status=yes, resizable=no, width=480px, height=420px, left=500px, top=200px');
}
function abreDeposito(){
	window.open('deposito.jsp','teste','scrollbars=yes, menubar=yes, status=yes, resizable=no, width=480px, height=420px, left=500px, top=200px');
}
function abreTransferencia(){
	window.open('transferencia.jsp','teste','scrollbars=yes, menubar=yes, status=yes, resizable=no, width=490px, height=460px, left=500px, top=200px');
}
</script>
</body>
</html>