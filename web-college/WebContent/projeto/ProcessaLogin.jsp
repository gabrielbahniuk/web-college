<%@page import="edu.asselvi.controller.ProfessorController"%>
<%@page import="edu.asselvi.sessao.ControlaSessao"%>
<%@page import="javax.sound.sampled.Control"%>
<%@page import="edu.asselvi.bean.Professor"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.bean.Turma"%>
<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Processa Login</title>
</head>
<body>
<%
	
	String login = request.getParameter("edtUsuario");
	String senha = request.getParameter("edtSenha");
	String logout = request.getParameter("L");

	
	int tipoLogin = -1; //inicializando
	
	
	if (logout instanceof String) {
		session.removeAttribute("sessao");
		session.invalidate();
		response.sendRedirect("Login.jsp");
	} else {
		if (request.getParameter("selTipoUsuario").equalsIgnoreCase("aluno")) 
			tipoLogin = 0; 
		else
			tipoLogin = 1;
		Aluno aluno = AlunoController.validaLogin(login, senha);
		Professor professor = ProfessorController.validaLogin(login, senha);
		
		if (aluno instanceof Aluno && tipoLogin == 0) { //SE FOR ALUNO
			
			ControlaSessao controlaSessao = new ControlaSessao(aluno.getCodigo(),
															   aluno.getNome(),
															   Integer.parseInt(request.getParameter("selTempoSessao")),
															   System.currentTimeMillis(),
															   tipoLogin
					);

			session.setAttribute("sessao", controlaSessao);
			response.sendRedirect("Index.jsp?id=" +aluno.getCodigo() + "&tipoLogin="+tipoLogin);
		}
		else if (professor instanceof Professor && tipoLogin == 1) { //SE FOR PROFESSOR
			ControlaSessao controlaSessao = new ControlaSessao(professor.getCodigo(),
				       professor.getNome(),
					   Integer.parseInt(request.getParameter("selTempoSessao")),
					   System.currentTimeMillis(),
					   tipoLogin
					);
		
			session.setAttribute("sessao", controlaSessao);
			response.sendRedirect("Index.jsp?id=" +professor.getCodigo() + "&tipoLogin="+tipoLogin);
		}
		else { // SE NAO FOR NENHUM DOS 2
			response.sendRedirect("Login.jsp?E=" + Constantes.LOGIN_INVALIDO);
		}
	}
%>
</body>
</html>