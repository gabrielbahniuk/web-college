<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="edu.asselvi.sessao.ControlaSessao"%>
<%@page import="javax.sound.sampled.Control"%>
<%@page import="edu.asselvi.bean.Professor"%>
<%@page import="edu.asselvi.bean.Aluno"%>
<%@page import="edu.asselvi.util.Constantes"%>
<%@page import="edu.asselvi.controller.AlunoController"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
<link rel="shortcut icon" type="image/png" href="img/favicon.png" />
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jspdf/0.9.0rc1/jspdf.js"></script>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="scripts/senhas.js"></script>
<script src="scripts/ajax.js"></script>
<script src="scripts/funcoes.js"></script>
<script src="scripts/instrucao.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal Universitário</title>

</head>
