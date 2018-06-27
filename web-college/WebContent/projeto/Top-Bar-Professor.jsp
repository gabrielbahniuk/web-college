 <!-- Fixed navbar -->
 <%@page import="edu.asselvi.util.Constantes"%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Portal Universitário</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">          
            <li><a href="#" onclick="abrirPag('modulos/professor/Postar.jsp');">Postar Nota</a></li>
            <li><a href="#" onclick="abrirPag('modulos/professor/Turmas.jsp');">Turmas</a></li>
            <li><a href="#" onclick="abrirPag('modulos/professor/Disciplinas.jsp');">Disciplinas</a></li>
            <li><a href="#" onclick="javascript:window.print();">Exportar</a></li>
            <li><a href="ProcessaLogin.jsp?L=<%=Constantes.LOGIN_SAIR%>">Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>