package edu.asselvi.dao;

import edu.asselvi.bd.BDException;
import edu.asselvi.bean.Aluno;

public interface IAluno {
	
	public Aluno validarAluno(String login, String senha) throws BDException;
}
