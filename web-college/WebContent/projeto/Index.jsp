<%@ include file="Header.jsp" %>
<body>

<%@include file="controlaSessao.jsp"%>
<div class="container theme-showcase" style="position:absolute; top:10%; width:100%;">
	<%if (controlaSessao.getTipoUsuario() == 0) { %>
	<%@ include file="Top-Bar.jsp"%> <!-- top bar aluno -->	
	 <%} else { %>
	 <%@ include file="Top-Bar-Professor.jsp"%> <!-- top bar professor -->
	<%} %> 
	
	<div id="mostrar_conteudo" style="position:relative;top:10%; width:80%">
	<h1>Bem vindo ao Portal Universitário!</h1>
	<p>
	Aqui você poderá utilizar os menus na barra superior da tela para navegar.
	Aproveite.
	</p>
	</div> <!-- fechamento div mostrar_conteudo -->

</div> <!-- fechamento div container -->

</body>
</html>