<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.controller.ProfessorController"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../scripts/funcoes.js"></script>
<link rel="stylesheet" type="text/css" href="../../bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisa</title>
</head>
<body>
<%@include file="../../controlaSessao.jsp"%>
<%
//response.setIntHeader("Refresh", 3);
%>
<%
String idTurma = request.getParameter("opcao");
String idProfessor = request.getParameter("professor");
%>
	
<table class="table table-striped">
<thead>
	<tr>
	<th>Nome</th>
	<th>Disciplina</th>
	<th>Nota1</th>
	<th>Nota2</th>
	<th>Frequência</th>
	<th>Turma</th>
	<th>Editar</th>
	</tr>
</thead>
<%											          
	for (Aluno a : ProfessorController.consultaAlunoDisciplinaTurma(Integer.parseInt(idTurma), Integer.parseInt(idProfessor))) {
%>
	<tr>
				<td><%=a.getNome()%>
				<td><%=a.getNomeDisciplina()%>
				<td><%=a.getNota1()%></td>
				<td><%=a.getNota2()%></td>
				<td><%=a.getFrequencia()%></td>
				<td><%=a.getDescTurma() %></td>
				<td><a href="javascript:abrir('EditarAluno.jsp?idAluno=<%=a.getCodigo()%>&idDisciplina=<%=a.getIdDisciplina()%>', '500', '530')"><img src="../../img/edit.png" height="25px" width="25px"/></a></td>
			</tr>		
<%
	}
%>

</table>

</body>
</html>