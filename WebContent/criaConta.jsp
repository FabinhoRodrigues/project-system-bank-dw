<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cria Conta</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
body {
	background-color: #F2F2F2;
}
</style>
</head>
<body>



	<form class="form-horizontal" method="post" action="CriaClienteServlet">
		<fieldset>
			<div class="panel panel-primary">
				<br>
				<br>
				<center>
					<h4>CADASTRO DE CRIAÇÃO DE CONTAS</h4>
				</center>
				<br>
				<br>

				<div class="panel-body">
					<div class="form-group">

						<div class="col-md-11 control-label">
							<p class="help-block">
								<h11>*</h11>
								Campo Obrigatório
							</p>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="Nome">Nome <h11>*</h11></label>
						<div class="col-md-8">
							<input id="nome" name="nome" placeholder=""
								class="form-control input-md" required="" type="text">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="Nome">CPF <h11>*</h11></label>
						<div class="col-md-2">
							<input id="cpf" name="cpf" placeholder="Apenas números"
								class="form-control input-md" required="" type="text"
								maxlength="11" pattern="[0-9]+$">
						</div>

						<!-- Prepended text-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="email">Email
								<h11>*</h11>
							</label>
							<div class="col-md-5">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope"></i></span> <input
										id="email" name="email" class="form-control"
										placeholder="email@email.com" required="" type="text"
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="Nome">Endereço
								<h11>*</h11>
							</label>
							<div class="col-md-8">
								<input id="endereco" name="endereco" placeholder=""
									class="form-control input-md" required="" type="text">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="Nome">Senha <h11>*</h11></label>
							<div class="col-md-6">
								<input id="senha" name="senha" placeholder=""
									class="form-control input-md" required="" type="text">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="Nome">Confirmar
								Senha <h11>*</h11>
							</label>
							<div class="col-md-6">
								<input id="cSenha" name="cSenha" placeholder=""
									class="form-control input-md" required="" type="text">
							</div>
						</div>

						<button type="submit" class="btn btn-default btn-login">ENVIAR</button>
						
						<button type="button" class="btn btn-default btn-login"  
				onclick="location.href='/trabalho_dw/login.jsp'">VOLTAR</button>
						
					</div>
				</div>
		</fieldset>
	</form>
</body>
</html>