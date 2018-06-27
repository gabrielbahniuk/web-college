package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.EErrosBD;
import edu.asselvi.bd.conexao.Conexao;
import edu.asselvi.bean.Aluno;
import edu.asselvi.bean.Professor;

public class AlunoDAO implements IAluno {
	
	public Aluno validarAluno(String login, String senha) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM aluno WHERE login = ? AND senha = ?;");
			pst.setString(1, login);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Aluno(rs.getInt("id"),
										  rs.getString("login"),
										  rs.getString("senha"),
										  rs.getString("nome"),
										  rs.getInt("fk_turma_id")	
					)
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally { 
			Conexao.fechaConexao();
		}
	}
	

	
	public Aluno consultarSituacao(int idAluno, int idDisciplina) throws BDException {
		Connection conexao = Conexao.getConexao();

		String sql = "SELECT a.id, a.nome, ad.nota1, ad.nota2, d.descricao as 'disciplina', ad.frequencia, a.fk_turma_id"
					+ " FROM aluno a INNER JOIN turma t"
					+ " ON a.fk_turma_id = t.id"
					+ " INNER JOIN aluno_disciplina ad"
					+ " ON ad.fk_aluno_id = a.id"
					+ " INNER JOIN disciplina d"
					+ " ON d.id = ad.fk_disciplina_id"
					+ " WHERE a.id = ? AND d.id = ?";
		try {
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setInt(1, idAluno); 
		pst.setInt(2, idDisciplina);
		
		ResultSet rs = pst.executeQuery();
		return rs.first() ? new Aluno (rs.getInt("id"),
									   rs.getString("nome"),
									   rs.getFloat("nota1"),
									   rs.getFloat("nota2"),
									   rs.getFloat("frequencia"),
									   rs.getInt("fk_turma_id"), 
									   rs.getString("disciplina") 
				)
						  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	
	
	public Professor consultarProfessores(int idAluno) throws BDException {
		Connection conexao = Conexao.getConexao();
	
		String sql = "SELECT p.nome, d.descricao as 'disciplina'" 
					+" FROM professor p"
					+" INNER JOIN professor_disciplina pd"
					+" ON pd.fk_professor_id = p.id"
					+" INNER JOIN disciplina d"
					+" ON d.id = pd.fk_disciplina_id"
					+" INNER JOIN aluno_disciplina ad"
					+" ON ad.fk_disciplina_id = pd.fk_disciplina_id"
					+" INNER JOIN aluno a"
					+" ON a.id = ad.fk_aluno_id"
					+" WHERE a.id = ?";
		
		try {
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setInt(1, idAluno); 
		ResultSet rs = pst.executeQuery();
		return rs.first() ? new Professor(
									   rs.getString("nome"),
									   rs.getString("disciplina")		
										 )
						  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	
	public List<Aluno> listarAlunos() throws BDException {
		
			List<Aluno> listaAlunos = new ArrayList<>();
			
			Connection conexao = Conexao.getConexao();
			String sql = "SELECT * from aluno";
			try {
				Statement st = conexao.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setCodigo(rs.getInt("id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setLogin(rs.getString("login"));
					aluno.setSenha(rs.getString("senha"));
					listaAlunos.add(aluno);
				}
				return listaAlunos;
			} catch (Exception e) {
				throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
			} finally {
				Conexao.fechaConexao();
			}
		}

	
}