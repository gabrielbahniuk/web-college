<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@page import="edu.asselvi.bean.Turma"%>
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

<h3>Turmas: <%=controlaSessao.getNome() %></h3>
<table class="table table-striped">
<thead>
	<tr>
	<th>ID</th>
	<th>Descrição</th>
	</tr>
</thead>
<%
	for (Turma t : ProfessorController.consultaTurmasProfessor(controlaSessao.getCodigo())) {
%>
			<tr>
				<td><%=t.getCodigo()%></td>
				<td><%=t.getDescricao()%></td>
			</tr>		
<%
	}
%>
</table>
</body>
</html>