package edu.asselvi.dao;

import edu.asselvi.bd.BDException;
import edu.asselvi.bean.Professor;

public interface IProfessor {
	
	public abstract Professor validarProfessor(String login, String senha) throws BDException; 
}
