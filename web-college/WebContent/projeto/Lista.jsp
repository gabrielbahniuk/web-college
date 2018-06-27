<%@page import="edu.asselvi.bd.BDException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.bean.Professor"%>
<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<table class="table table-striped">
<tr>
	<th colspan=3 class="text-center"> Alunos</th>
</tr>
<tr>
 	<th>ID</th>
 	<th>Login</th>
 	<th>Senha</th>
</tr>
<%
try {
	for (Aluno a : AlunoController.consultaTodos()) {
%>
	<tr>
		<td><%=a.getCodigo() %> </td>
		<td><%=a.getLogin() %></td>
		<td><%=a.getSenha() %> </td>
	</tr>
<%
	}
	
%>
<tr>
	<th colspan="3" class="text-center"> Professores </th>
</tr>

<tr>
 	<th>ID</th>
 	<th>Login</th>
 	<th>Senha</th>
</tr>

<%
	for (Professor p : ProfessorController.consultaTodos()) {
%>
	<tr>
		<td><%=p.getCodigo() %> </td>
		<td><%=p.getLogin() %></td>
		<td><%=p.getSenha() %> </td>
	</tr>
<%
	}
%>
</table>

<%
} catch (BDException e) {
	%><h1>Não há dados para mostrar.</h1><%
}
%>
