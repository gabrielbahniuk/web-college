<%@page import="edu.asselvi.util.Manipulador"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="edu.asselvi.bd.conexao.*"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.asselvi.sessao.ControlaSessao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Processa Criação do BD</title>
</head>
<body>
<% 

String usuario = request.getParameter("user");
String senha = request.getParameter("pass");
String bd = request.getParameter("bd");
String host = request.getParameter("host");
%>

<%
try {	
Manipulador manipulador = new Manipulador();
manipulador.setValorPropertie("server.user", usuario);
manipulador.setValorPropertie("server.pass", senha);
manipulador.setValorPropertie("server.host", host);
manipulador.setValorPropertie("server.schema", bd);

Connection conexao = Conexao.getConnectionInstall();

Conexao.criarBanco();

response.sendRedirect("Login.jsp");
} catch (Exception e) {
	%> <h1>ERRO => <%=e.getMessage() %></h1>
	<%e.printStackTrace();%>
	
<%
} finally {
	 Conexao.fechaConexao();
}
%>
</body>
</html>