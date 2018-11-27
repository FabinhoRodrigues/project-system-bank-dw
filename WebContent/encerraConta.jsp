<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Encerra Conta</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
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

<br><br><center><h4>ENCERRAMENTO DE CONTAS </h4></center><br><br>

<center><form name="formLogin" action="EncerraContaServlet" method="post" >
	<div class="row" >
		
			<div class="col-md-4 offset-md-4">

			<%@ page import="br.com.sistema.model.Cliente" %>
             <% Cliente cliente = (Cliente)session.getAttribute("clienteAutenticado"); %>

			<h5><% out.print("Cliente: " +  cliente.getNome()); %></h5><br>
			<h5><% out.print("Digite sua senha para confirmação de fechamento de conta"); %></h5><br>

				<div class="form-group">
					<label for="pwd"><b>Senha </b></label> <input type="password"
						class="form-control" name="senha" id="senha">
				</div>
				
				<div class="form-group">
					<label for="pwd"><b>Confirma Senha </b></label> <input type="password"
						class="form-control" name="cSenha" id="cSenha">
				</div>
				
				<button type="submit" class="btn btn-default btn-login">Enviar
				</button>
				

			</div>
		
	</div>
</form></center>





<script>
src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		
</script>		
</body>
</html>