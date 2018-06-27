package edu.asselvi.controller;

import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bean.Aluno;
import edu.asselvi.bean.Professor;
import edu.asselvi.dao.DisciplinaDAO;

public class DisciplinaController {

	public static List<Aluno> consultaTodos(int idAluno) throws BDException {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		return disciplinaDAO.listarDisciplinasAluno(idAluno);
	}
	
	public static List<Professor> consultaProfessores(int idAluno) throws BDException {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		return disciplinaDAO.listarProfessoresAluno(idAluno);
	}
	
}
