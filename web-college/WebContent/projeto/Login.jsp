<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.bd.conexao.Conexao"%>
<%@ include file="Header.jsp" %>
<body>

<%
	int erro = -1;
	try {
		erro = Integer.parseInt(request.getParameter("E"));
	} catch (Exception e) {
		erro = -1;
	}
	
	String mensagem = null;
	switch (erro) {
		case Constantes.LOGIN_INVALIDO :
			mensagem = "Login Inválido!";
			break;
		case Constantes.SESSAO_EXPIRADA :
			mensagem = "Sessão Expirada!";
			break;
		case Constantes.SESSAO_INVALIDA :
			mensagem = "Sessão Inválida!";
			break;
	}
	
	if (mensagem instanceof String) {
		%>
		<script type="text/javascript">
			var e = <%=mensagem%>;
			window.alert("Atenção: " + e);
		</script>
		<%
	}
%>
<div class="container">
<div class="main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="letter-sky-blue">Portal Universitário</h1>
	               		<hr class="hr-grey-dashed-line" />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" name="frmLogin" id="frmLogin" action="ProcessaLogin.jsp"
					 method="get" onsubmit="return validaSenha(this);">						
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label white-letter">Usuário</label>
							<div class="cols-sm-10">
								<div class="input-group">																	
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									<input type="text" required="required" class="form-control" name="edtUsuario" id="edtUsuario"  placeholder="Digite seu usuário..."
									 />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label white-letter">Senha</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="edtSenha" id="edtSenha"  placeholder="Digite sua senha..."/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="tipoUsuario" class="cols-sm-2 control-label white-letter">Tipo Usuário</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
									<select class="form-control" name="selTipoUsuario" id="selTipoUsuario">
										<option value="Aluno" selected>Aluno</option>
										<option value="Professor">Professor </option>							
									</select>
									<!-- <input type="password" class="form-control" name="password" id="password"  placeholder="Digite sua senha..."/> -->
								</div>
							</div>
						</div>
					
						<div class="form-group">
							<label for="selTempoSessao" class="cols-sm-2 control-label white-letter">Tempo Sessão</label>
								<div class="cols-sm-10">
									<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>	
											<select name="selTempoSessao" class="form-control">
												<option value="180000">3 minutos</option>
												<option value="300000">5 minutos</option>
												<option value="900000">15 minutos</option>
											</select>
									</div>
								</div>
						</div>	
					
										
						<div class="form-group ">
							<input type="submit" value="Acessar" class="btn btn-lg btn-block login-button background-light-blue white-letter">
						</div>
							<input type="button" value="Lista Usuários" onclick="javascript:abrir('Lista.jsp', '640', '880');"
							class="btn background-light-blue white-letter">
					</form>
				</div>
				</div>
		</div> <!-- end div container -->
</body>
</html>