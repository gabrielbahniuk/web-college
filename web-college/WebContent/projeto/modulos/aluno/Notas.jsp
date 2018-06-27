<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.controller.DisciplinaController"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.bean.Disciplina"%>
<%@ page import="java.sql.*" %>
<%@ page import="edu.asselvi.bd.conexao.*" %>

<%@include file="../../controlaSessao.jsp"%>
<h3>Aluno: <%=controlaSessao.getNome() %></h3>

<table class="table table-striped">
<thead>
	<tr>
	<th>Disciplina</th>
	<th>Nota 1</th>
	<th>Nota 2</th>
	<th>Media</th>
	<th>Frequência (%)</th>
	<th>Situação</th>
	</tr>
</thead>
<%
	for (Aluno a : DisciplinaController.consultaTodos(controlaSessao.getCodigo())) {
%>
			<tr>
				<td><%=a.getNomeDisciplina()%>
				<td><%=a.getNota1()%></td>
				<td><%=a.getNota2()%></td>
				<td><%=(a.getNota1() + a.getNota2())/2 %></td>
				<td><%=a.getFrequencia()%></td>
				<td><%=((a.getNota1() + a.getNota2())/2) >= 7 && a.getFrequencia() >=75 ? 
						"<strong><font color='green'>Aprovado</font></strong>" 
					: "<strong><font color='red'>Reprovado</font></strong>"%>
				</td>
			</tr>		
<%
	}
%>
</table>




