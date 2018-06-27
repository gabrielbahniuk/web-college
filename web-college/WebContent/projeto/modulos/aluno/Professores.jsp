<%@page import="edu.asselvi.bean.Turma"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.sessao.ControlaSessao"%>
<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@page import="edu.asselvi.controller.DisciplinaController"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.bean.Professor"%>
<%@page import="edu.asselvi.dao.ProfessorDAO"%>
<%@ page import="java.sql.*" %>
<%@ page import="edu.asselvi.bd.conexao.*" %>
<%@include file="../../controlaSessao.jsp"%>

<h3> Lista de Professores</h3>
<table class="table table-striped">
<thead>
	<tr>
	<th>Nome</th>
	<th>Disciplina</th>
	</tr>
</thead>
<%
	for (Professor p : DisciplinaController.consultaProfessores(controlaSessao.getCodigo())) {
%>
			<tr>
				<td><%=p.getNome() %>
				<td><%=p.getDisciplinas()%></td>
			</tr>		
	<%
	}
	%>
</table>




