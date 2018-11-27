<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="keyboard.css">
<title>ATM-BANCO DW</title>
<style>
body {
		background-color: #F2F2F2;
	 }
</style>
<script type="text/javascript">
function id( el ){
        return document.getElementById( el );
}
function val( destino, valor ){
        destino.value += valor;
}
var focus = false;
window.onload = function(){
       
       
        var botoes = id('teclado').getElementsByTagName('input');
        for( var i=0; i<botoes.length; i++ ){
                botoes[i].onclick = function(){
                        if( !focus ){ alert('coloque o foco em algum input');exit(); }

                        val( id( focus ), this.value );
                        id( focus ).focus();
                }
        }
       
        var inputs = id('area').getElementsByTagName('input');
        for( var i=0; i<inputs.length; i++ ){
                inputs[i].onfocus = function(){
                        focus = this.id;
                }
        }
        id('entrada_1').focus();
}
</script>
<style type="text/css">
* { margin: 0; padding: 0; border: 0; }
input { background: #fff; border: 1px solid #ccc; padding: 2px;}
#teclado { width: 400px; }
#teclado fieldset { width: 300px; text-align: center; float: left; margin: 2px; }
#teclado #numbers { float: right; width: 80px; }
fieldset { margin: 5px; }

</style>
</head>

<body>
<div>
 <jsp:include page="menu.jsp" /> 
</div>
<br><h5><b>Depósito</b></h5><br>



<form action="DepositoServlet" method="post">
                <div class="container" id="area">
                	
                	<div class="row">
                	 <div class="col">Número de Conta: *</div>
                	 <div class="col"><input type="text" name="conta" id="conta" /></div>
                	 </div>
                	 
                	 <div class="row">
                	   <div class="col">Valor: *</div>
                	   <div class="col"><input type="text" name="valor" id="valor" /></div>
                	 </div>
                	 <div class="row">
                	     <div class="col"> Data: * </div>
					       <div class="col">
							<%@ page import="java.util.Calendar" %>
							<%@ page import="java.text.SimpleDateFormat" %>
								<% 
								Calendar c = Calendar.getInstance();
								SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
								String data = s.format(c.getTime());
								out.print(data);
								session.setAttribute("data", data);
					             %>
					        </div>
                	 </div>
                </div>
                <fieldset id="teclado">
                        <fieldset id="numbers">
                                <input type="button" name="7" value="7" />
                                <input type="button" name="8" value="8" />
                                <input type="button" name="9" value="9" />
                               
                                <input type="button" name="4" value="4" />
                                <input type="button" name="5" value="5" />
                                <input type="button" name="6" value="6" />
                               
                                <input type="button" name="1" value="1" />
                                <input type="button" name="2" value="2" />
                                <input type="button" name="3" value="3" />
                               
                                <input type="button" name="0" value="0" />
                        </fieldset>
                        <fieldset>
                                <input type="button" name="q" value="q" />
                                <input type="button" name="w" value="w" />
                                <input type="button" name="e" value="e" />
                                <input type="button" name="r" value="r" />
                                <input type="button" name="t" value="t" />
                                <input type="button" name="y" value="y" />
                                <input type="button" name="u" value="u" />
                                <input type="button" name="i" value="i" />
                                <input type="button" name="o" value="o" />
                                <input type="button" name="p" value="p" />
                        </fieldset>
                        <fieldset>
                                <input type="button" name="a" value="a" />
                                <input type="button" name="s" value="s" />
                                <input type="button" name="d" value="d" />
                                <input type="button" name="f" value="f" />
                                <input type="button" name="g" value="g" />
                                <input type="button" name="h" value="h" />
                                <input type="button" name="j" value="j" />
                                <input type="button" name="k" value="k" />
                                <input type="button" name="l" value="l" />
                                <input type="button" name="ç" value="ç" />
                        </fieldset>
                        <fieldset>                      
                                <input type="button" name="z" value="z" />
                                <input type="button" name="x" value="x" />
                                <input type="button" name="c" value="c" />
                                <input type="button" name="v" value="v" />                      
                                <input type="button" name="b" value="b" />
                                <input type="button" name="n" value="n" />
                                <input type="button" name="m" value="m" />
                        </fieldset>
                </fieldset>
                <button type="submit" class="btn btn-default btn-login">ENVIAR</button>
        </form>
<script type="text/javascript">
function getDataAtual(){
	   data = new Date();
	   document.getElementById('data').value = data.getDay()+'/'+data.getMonth()+'/'+data.getFullYear();
	}
</script>

</body>
</html>


