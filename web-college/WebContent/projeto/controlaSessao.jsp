<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.sessao.ControlaSessao"%>
<%
	ControlaSessao controlaSessao = (ControlaSessao) session.getAttribute("sessao");
	if (controlaSessao instanceof ControlaSessao) {
		long tempoAtual = System.currentTimeMillis();
		if (controlaSessao.getUltimoAcesso() + controlaSessao.getTempoSessao() > tempoAtual) {
			controlaSessao.setUltimoAcesso(tempoAtual);
			session.setAttribute("sessao", controlaSessao);
		} else {
			session.removeAttribute("sessao");
			session.invalidate();
			response.sendRedirect("../Login.jsp?E=" + Constantes.SESSAO_EXPIRADA);			
		}
	} else {
		response.sendRedirect("../Login.jsp?E=" + Constantes.SESSAO_INVALIDA);
	}
%>