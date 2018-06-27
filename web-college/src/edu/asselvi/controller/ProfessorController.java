package edu.asselvi.controller;

import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bean.Aluno;
import edu.asselvi.bean.Disciplina;
import edu.asselvi.bean.Professor;
import edu.asselvi.bean.Turma;
import edu.asselvi.dao.ProfessorDAO;

public class ProfessorController {

	public static Professor validaLogin(String login, String senha) throws BDException {
		if (login instanceof String && senha instanceof String) {
			ProfessorDAO professorDAO = new ProfessorDAO();
			return professorDAO.validarProfessor(login, senha);
		}
		return null;
	}
	
	
	public static boolean alterarDadosAluno(String idAluno, String idDisciplina, String nota1, String nota2, String frequencia) throws BDException {
		float bNota1 = 0;
		float bNota2 = 0;
		float bFrequencia = 0;
		int bIdAluno = 0;
		int bIdDisciplina = 0;
		try {
			bIdAluno = Integer.parseInt(idAluno);
			bIdDisciplina = Integer.parseInt(idDisciplina);
			bNota1 = Float.parseFloat(nota1);
			bNota2 = Float.parseFloat(nota2);
			bFrequencia = Float.parseFloat(frequencia);
		} catch (Exception e) {
			return false;
		}
		ProfessorDAO professorDAO = new ProfessorDAO();
		return professorDAO.alterarDadosAluno(new Aluno(bIdAluno, bIdDisciplina, bNota1, bNota2, bFrequencia));
	}
	
	
	public static List<Aluno> consultaAlunoDisciplinaTurma(int idTurma, int idProfessor) throws BDException {
		ProfessorDAO professorDAO = new ProfessorDAO();
		return professorDAO.listarAlunosTurmaDisciplinaDoProfessor(idTurma, idProfessor);
	}
	
	public static List<Turma> consultaTurmasProfessor(int idProfessor) throws BDException {
		ProfessorDAO professorDAO = new ProfessorDAO();
		return professorDAO.listarTurmasProfessor(idProfessor);
	}
	
	public static List<Disciplina> consultaDisciplinasProfessor(int idProfessor) throws BDException {
		ProfessorDAO professorDAO = new ProfessorDAO();
		return professorDAO.listarDisciplinasProfessor(idProfessor);
	}
	
	//RETORNAR TODOS OS PROFESSORES
		public static List<Professor> consultaTodos() throws BDException {
			ProfessorDAO professorDAO = new ProfessorDAO();
			return professorDAO.listarProfessores();
		}	
	
}
