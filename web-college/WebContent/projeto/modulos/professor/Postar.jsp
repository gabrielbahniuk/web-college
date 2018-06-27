<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@page import="edu.asselvi.controller.DisciplinaController"%>
<%@page import="edu.asselvi.bean.Professor"%>
<%@page import="edu.asselvi.bean.Disciplina"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.bean.Turma"%>
<%@ page import="java.sql.*"%>
<%@ page import="edu.asselvi.bd.conexao.*"%>

<%@include file="../../controlaSessao.jsp"%>
<form method="get" action="modulos/professor/Pesquisa.jsp">
	<h3>Professor: <%=controlaSessao.getNome()%></h3>
	<hr style="width:100%"/>

	<label> Selecione a Turma:</label>
	<select id="opcao" name="opcao" style="min-width:100px">
	<%
		for (Turma t : ProfessorController.consultaTurmasProfessor(controlaSessao.getCodigo())) {
	%>
		<option value="<%=t.getCodigo()%>"><%=t.getDescricao()%> </option>
	<%
		}
	%>
	</select>
	 
	<input type="submit" value="Pesquisar"/>
	<input type="hidden" name="professor" id="professor" value="<%=controlaSessao.getCodigo()%>">
</form>
