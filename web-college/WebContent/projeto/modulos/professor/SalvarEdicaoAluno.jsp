<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.bean.Professor"%>
<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salvar Edição</title>
</head>
<body>
<%@include file="../../controlaSessao.jsp"%>
<form>
	<%
		String nota1 = request.getParameter("edtNovaNota1");
		String nota2 = request.getParameter("edtNovaNota2");
		String frequencia = request.getParameter("edtNovaFrequencia");
		String idAluno = request.getParameter("idAluno");
		String idDisciplina = request.getParameter("idDisciplina");
	%>
	
		<%
			ProfessorController.alterarDadosAluno(idAluno, idDisciplina, nota1, nota2, frequencia);
		%>
		
	<script type="text/javascript">
		window.alert("Editado com sucesso!");
		window.close();
	</script>
</form>
</body>
</html>