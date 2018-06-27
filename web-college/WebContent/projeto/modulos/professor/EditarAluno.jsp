<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.util.Constantes"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../bootstrap/css/bootstrap.css">
<script src="../../bootstrap/js/jquery.js"></script>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../scripts/senhas.js"></script>
<script src="../../scripts/ajax.js"></script>
<script src="../../scripts/print.js"></script>
<script src="../../scripts/instrucao.js"></script>
<script src="../../scripts/funcoes.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Aluno</title>
</head>

<body>

<%@include file="../../controlaSessao.jsp"%>
<%

String idAluno = request.getParameter("idAluno");
String idDisciplina = request.getParameter("idDisciplina");

	String nome = "";
	float nota1 = 0;
	float nota2 = 0;
	float frequencia = 0;
	String nomeDisciplina = "";
	
	int cod = 	controlaSessao.getCodigo();
		Aluno aluno = AlunoController.consulta(Integer.parseInt(idAluno), Integer.parseInt(idDisciplina));
		
		if (aluno instanceof Aluno) {
			
			nome = aluno.getNome();
			nota1 = aluno.getNota1();
			nota2 = aluno.getNota2();
			frequencia = aluno.getFrequencia();
			nomeDisciplina = aluno.getNomeDisciplina();
		}
	
%>
<div class="main-center">

<form class="form-horizontal" style="margin: 0 auto" action="SalvarEdicaoAluno.jsp" method="GET">
			<h3 class="text-center">Editar Aluno</h3>
				<div class="form-group">
			<label for="edtNovaDisciplina">Disciplina</label>
			<input disabled="disabled" type="text" name=edtNovaDisciplina id="edtNovaDisciplina" value="<%=nomeDisciplina%>" size="40" maxlength="45" />
	</div>
			
				<div class="form-group">
			<label for="edtNovaUsuario">Aluno</label>
			<input disabled="disabled" type="text" name="edtNovaUsuario" id="edtNovaUsuario" value="<%=nome%>" size="40" maxlength="45" />
		</div>
			
				<div class="form-group">
			<label for="edtNovaNota1">Nota 1</label>
			<br />
			<input type="number" min="1"  max="10" step="0.1" value="<%=nota1%>" name="edtNovaNota1" id="edtNovaNota1" size="40"  />
			</div>
			
				<div class="form-group">
			<label for="edtNovaNota2">Nota 2</label>
			<br />
			<input type="number" min="1" max="10" step="0.1" value="<%=nota2%>" name="edtNovaNota2" id="edtNovaNota2" size="70"  />
			</div>

			<div class="form-group">
			<label for="edtNovaFrequencia">Frequência</label>
			<br />
			<input type="number" min="1"  max="100" step="1" value="<%=frequencia%>" name="edtNovaFrequencia" id="edtNovaFrequencia" size="40" />
			</div>
			
				<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Salvar"/>
				</div>
		<input type="hidden" name="idAluno" id="idAluno" value="<%=idAluno %>"/>
		<input type="hidden" name="idDisciplina" id="idDisciplina" value="<%=idDisciplina %>"/>
		
</form>
</div>
</body>
</html>