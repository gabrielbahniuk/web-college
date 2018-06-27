package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.EErrosBD;
import edu.asselvi.bd.conexao.Conexao;
import edu.asselvi.bean.Aluno;
import edu.asselvi.bean.Professor;

public class DisciplinaDAO {

	public List<Aluno> listarDisciplinasAluno(int idAluno) throws BDException {
		
		List<Aluno> listaDisciplinasAluno = new ArrayList<>();
		
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT a.id, a.nome, t.descricao as 'turma', ad.nota1 as 'nota1', ad.nota2 as 'nota2',"
				+ " ad.frequencia as 'frequencia', a.fk_turma_id,"
				+ " d.descricao as 'disciplina'"
				+ " FROM aluno a INNER JOIN turma t"
				+ " ON a.fk_turma_id = t.id"
				+ " INNER JOIN aluno_disciplina ad"
				+ " ON ad.fk_aluno_id = a.id"
				+ " INNER JOIN disciplina d"
				+ " ON d.id = ad.fk_disciplina_id"
				+ " WHERE a.id = ?";
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, idAluno);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setCodigo(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setNota1(rs.getFloat("nota1"));
				aluno.setNota2(rs.getFloat("nota2"));
				aluno.setFrequencia(rs.getFloat("frequencia"));
				aluno.setDescTurma(rs.getString("turma"));
				aluno.setIdTurma(rs.getInt("fk_turma_id"));
				aluno.setNomeDisciplina(rs.getString("disciplina"));
				listaDisciplinasAluno.add(aluno);
			}
			return listaDisciplinasAluno;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Professor> listarProfessoresAluno(int idAluno) throws BDException {
		
		List<Professor> listaProfessores = new ArrayList<>();
		
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
			while (rs.next()) {
				Professor p = new Professor();
				p.setNome(rs.getString("nome"));
				p.setDisciplinas(rs.getString("disciplina"));
				listaProfessores.add(p);
			}
			return listaProfessores;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
}
