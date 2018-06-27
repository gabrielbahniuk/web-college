package edu.asselvi.controller;

import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bean.Aluno;
import edu.asselvi.dao.AlunoDAO;

public class AlunoController {

	public static Aluno validaLogin(String login, String senha) throws BDException {
		if (login instanceof String && senha instanceof String) {
			AlunoDAO alunoDAO = new AlunoDAO();
			return alunoDAO.validarAluno(login, senha);
		}
		return null;
	}
	
	// CONSULTAR SITUAÇÃO DO ALUNO pelo id codigo e id disciplina (DISCIPLINA, NOTA1, NOTA2, FREQUENCIA)
	public static Aluno consulta(int codigo, int idDisciplina) throws BDException {
		AlunoDAO alunoDAO = new AlunoDAO();
		return alunoDAO.consultarSituacao(codigo, idDisciplina);
	}
	
	//RETORNAR TODOS OS ALUNOS
	public static List<Aluno> consultaTodos() throws BDException {
		AlunoDAO alunoDAO = new AlunoDAO();
		return alunoDAO.listarAlunos();
	}	
}
