package edu.asselvi.bean;

public class Professor {
	
	private int codigo;
	private String nome;
	private String login;
	private String senha;
	private int idTurma;
	private String disciplinas;
	
	public Professor() {
		setCodigo(codigo);
		setNome(nome);
	}
	
	public Professor(int id, String nome, String login, String senha) {
		setCodigo(id);
		setNome(nome);
		setLogin(login);
		setSenha(senha);
	}
	
	public Professor(int id, String nome, String login, String senha, int idTurma) {
		setCodigo(id);
		setNome(nome);
		setLogin(login);
		setSenha(senha);
		setIdTurma(idTurma);
	}
	
	public Professor(String nome, String disciplinas) {
		setNome(nome);
		setDisciplinas(disciplinas);
	}
	
	public void setDisciplinas(String disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getDisciplinas() {
		return disciplinas;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int getIdTurma() {
		return idTurma;
	}
	
	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {
		return login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	
	@Override
	public String toString() {
		return getNome();
	}


	
}
