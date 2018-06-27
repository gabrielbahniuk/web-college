<%@include file="controlaSessao.jsp"%>

<%
	try {
		controlaSessao.setTempoSessao(Integer.parseInt(request.getParameter("selTempoSessao")));
		session.setAttribute("sessao", controlaSessao);
		response.sendRedirect("Login.jsp");	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
%>