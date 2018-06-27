<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.bd.conexao.*"%>

<%@ include file="Header.jsp" %>
<body>
<h1 class="text-center">Instalar Banco de Dados</h1>
<div class="main-login main-center">
	<form method="GET" action="ProcessaBD.jsp">
		<div class="form-group">
		<label for="bd" class="cols-sm-2 control-label white-letter">Nome BD</label>
			<div class="input-group">	
				<input readonly="readonly" type="text" name="bd" id="bd" value="ads25_gabrielbahniuk" />
			</div>
		</div>
	<div class="form-group">
		<label for="ip" class="cols-sm-2 control-label white-letter">Endereço IP</label>
			<div class="input-group">	
				<input type="text" name="host" id="host" value="localhost" />
			</div>
		</div>
	<div class="form-group">
		<label for="user" class="cols-sm-2 control-label white-letter">Usuário BD</label>
		<div class="input-group">	
			<input required="required" type="text" name="user" id="user" placeholder="Informe o usuário do BD..."  />
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="cols-sm-2 control-label white-letter">Senha BD</label>
		<div class="input-group">	
			<input type="text" name="pass" id="pass" placeholder="Informe a senha do BD..."  />
		</div>
	</div>
<input class="btn btn-lg btn-block login-button background-light-blue white-letter" type="submit" value="Criar BD"/>
</form>
</div>


</body>