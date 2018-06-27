<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@page import="edu.asselvi.bean.Disciplina"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="../../controlaSessao.jsp"%>

<h3>Disciplinas: <%=controlaSessao.getNome() %></h3>
<table class="table table-striped">
<thead>
	<tr>
	<th>ID</th>
	<th>Descrição</th>
	<th>Curso</th>
	</tr>
</thead>
<%
	for (Disciplina d : ProfessorController.consultaDisciplinasProfessor(controlaSessao.getCodigo())) {
%>
			<tr>
				<td><%=d.getId()%></td>
				<td><%=d.getDescricao()%></td>
				<td><%=d.getDescCurso()%></td>
			</tr>		
<%
	}
%>
</table>
</body>
</html>