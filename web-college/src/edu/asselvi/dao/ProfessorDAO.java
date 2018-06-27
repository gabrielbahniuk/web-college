package edu.asselvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.bd.BDException;
import edu.asselvi.bd.EErrosBD;
import edu.asselvi.bd.conexao.Conexao;
import edu.asselvi.bean.Aluno;
import edu.asselvi.bean.Disciplina;
import edu.asselvi.bean.Professor;
import edu.asselvi.bean.Turma;

public class ProfessorDAO implements IProfessor {

		public Professor validarProfessor(String login, String senha) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			PreparedStatement pst = conexao.prepareStatement("SELECT * FROM professor WHERE login = ? AND senha = ?;");
			pst.setString(1, login);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			return rs.first() ? new Professor(rs.getInt("id"),
										  rs.getString("nome"),
										  rs.getString("login"),
										  rs.getString("senha")
					)
							  : null;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public boolean alterarDadosAluno(Aluno aluno) throws BDException {
		Connection conexao = Conexao.getConexao();
		String sql = "UPDATE aluno_disciplina SET nota1 = ?, nota2 = ?, frequencia = ?"
					+ " WHERE fk_aluno_id = ? AND fk_disciplina_id = ?";
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setFloat(1, aluno.getNota1());
			pst.setFloat(2, aluno.getNota2());
			pst.setFloat(3, aluno.getFrequencia());
			pst.setInt(4, aluno.getCodigo());
			pst.setInt(5, aluno.getIdDisciplina());
			
			return pst.executeUpdate() > 0;
			
		} catch (SQLException e) {
			throw new BDException(EErrosBD.INSERE_DADO, e.getMessage());
		}
	}

	public List<Aluno> listarAlunos(int idDisciplina) throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			String sql = "SELECT a.nome, t.descricao FROM aluno a"
						+" INNER JOIN aluno_disciplina ad"
						+" ON a.id = ad.fk_aluno_id"
						+" INNER JOIN disciplina d"
						+" ON d.id = ad.fk_disciplina_id"
						+" WHERE d.id = ?;";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, idDisciplina);
			ResultSet rs = pst.executeQuery();
			List<Aluno> listaAlunosDisciplina = new ArrayList<Aluno>();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setNota1(rs.getFloat("nota1"));
				a.setNota2(rs.getFloat("nota2"));
				a.setFrequencia(rs.getFloat("frequencia"));
				listaAlunosDisciplina.add(a);
			}
			return listaAlunosDisciplina;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}

	
	public List<Aluno> listarAlunosTurmaDisciplinaDoProfessor(int idTurma, int idProfessor) throws BDException {
		//Lista os alunos da mesma Turma que o Professor dá aula e as Disciplinas em comum que ele dá aula.
		
		List<Aluno> listaAlunos = new ArrayList<>();
		
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT DISTINCT a.id, a.nome, ad.nota1, ad.nota2, ad.frequencia, a.fk_turma_id, t.descricao as 'turma',"
				+ " d.descricao as 'disciplina', d.id as 'id_disciplina' FROM aluno a"
					+" INNER JOIN aluno_disciplina ad"
					+" ON ad.fk_aluno_id = a.id"
					+" INNER JOIN disciplina d"
					+" ON d.id = ad.fk_disciplina_id"
					+" INNER JOIN professor_disciplina pd"
					+" ON pd.fk_disciplina_id = ad.fk_disciplina_id"
					+" INNER JOIN professor p"
					+" ON p.id = pd.fk_professor_id"
					+" INNER JOIN turma t"
					+" ON t.id = a.fk_turma_id"
					+" WHERE t.id = ?"
					+" AND p.id = ?"
					+ " ORDER BY a.nome ASC";
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, idTurma);
			pst.setInt(2, idProfessor);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setCodigo(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setNota1(rs.getFloat("nota1"));
				aluno.setNota2(rs.getFloat("nota2"));
				aluno.setFrequencia(rs.getFloat("frequencia"));
				aluno.setIdTurma(rs.getInt("fk_turma_id"));
				aluno.setDescTurma(rs.getString("turma"));
				aluno.setIdDisciplina(rs.getInt("id_disciplina"));
				aluno.setNomeDisciplina(rs.getString("disciplina"));
				listaAlunos.add(aluno);
			}
			return listaAlunos;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}

	public List<Disciplina> listarDisciplinasProfessor(int idProfessor) throws BDException {
		List<Disciplina> listaDisciplinas = new ArrayList<>();
		
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT DISTINCT d.id, d.fk_curso_id, d.descricao, c.descricao as 'curso' from disciplina d"
					+" INNER JOIN professor_disciplina pd"
					+" ON pd.fk_disciplina_id = d.id"
					+" INNER JOIN professor p"
					+" ON p.id = pd.fk_professor_id"
					+" INNER JOIN curso c"
					+" ON c.id = d.fk_curso_id"
					+" WHERE p.id = ?";
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, idProfessor);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Disciplina d = new Disciplina();
				d.setId(rs.getInt("id"));
				d.setDescricao(rs.getString("descricao"));
				d.setDescCurso(rs.getString("curso"));
				listaDisciplinas.add(d);
			}
			return listaDisciplinas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Turma> listarTurmasProfessor(int idProfessor) throws BDException {
		//Lista turmas que o professor dá aula
		
		List<Turma> listaTurmas = new ArrayList<>();
		
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT DISTINCT t.id, t.fk_curso_id, t.descricao from turma t"
					+" INNER JOIN professor_turma pt"
					+" ON pt.fk_turma_id = t.id"
					+" INNER JOIN professor p"
					+" ON p.id = pt.fk_professor_id"
					+" WHERE p.id = ?";
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, idProfessor);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Turma t = new Turma();
				t.setCodigo(rs.getInt("id"));
				t.setDescricao(rs.getString("descricao"));
				t.setIdCurso(rs.getInt("fk_curso_id"));
				listaTurmas.add(t);
			}
			return listaTurmas;
		} catch (Exception e) {
			throw new BDException(EErrosBD.CONSULTA_DADO, e.getMessage());
		} finally {
			Conexao.fechaConexao();
		}
	}
	
	public List<Professor> listarProfessores() throws BDException {
		Connection conexao = Conexao.getConexao();
		try {
			String sql = "SELECT * FROM professor";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Professor> listaProfessores = new ArrayList<Professor>();
			while (rs.next()) {
				Professor p = new Professor();
				p.setCodigo(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setLogin(rs.getString("login"));
				p.setSenha(rs.getString("senha"));
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
