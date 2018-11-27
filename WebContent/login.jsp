<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
	body{
	background-color:#F2F2F2;
	}
	</style>
</head>
<body>

	<center>
		<img src="http://www.vauberti.com/wp-content/uploads/2018/01/img_bancos.png">
	</center>


<center><form name="formLogin" action="Autenticar" method="post" >
	<div class="row" >
		
			<div class="col-md-4 offset-md-4">


				<label for="login"><b>LOGIN</b></label>
				 <input type="login" class="form-control" name="login" id="login">

				<div class="form-group">
					<label for="senha"><b>SENHA</b></label> <input type="password"
						class="form-control" name="senha" id="senha">
				</div>
				<div class="checkbox">
					<label><input type="checkbox"><b>Lembre-se</b></label>
				</div>
				<button type="submit" class="btn btn-default btn-login">Entrar
				</button>
				
				<button type="button" class="btn btn-default btn-login"  
				onclick="location.href='/trabalho_dw/criaConta.jsp'">Criar Conta</button>
				
				
				
			</div>
		
	</div>
</form></center>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>