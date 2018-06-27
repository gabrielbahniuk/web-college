package edu.asselvi.bean;

public class Aluno {

	private int codigo;
	private String login;
	private String senha; 
	private String nome;
	private float nota1;
	private float nota2;
	private float frequencia;
	private int idTurma;
	private String descTurma;
	private String nomeDisciplina;
	private int idDisciplina;
	
	public void setDescTurma(String descTurma) {
		this.descTurma = descTurma;
	}
	public String getDescTurma() {
		return descTurma;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int getIdTurma() {
		return idTurma;
	}
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	

	
	public Aluno(int id, String login, String senha, String nome,
		     int idTurma, String nomeDisciplina) {
	setCodigo(id);
	setLogin(login);
	setSenha(senha);
	setNome(nome);
	setIdTurma(idTurma);
	setNomeDisciplina(nomeDisciplina);
}

	public Aluno(int id, String login, String senha, String nome,
			     int idTurma, int idDisciplina) {
		setCodigo(id);
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setIdTurma(idTurma);
		setIdDisciplina(idDisciplina);
	}
	
	

	public Aluno(int idAluno, int idDisciplina, float nota1, float nota2, float frequencia) {
		setNota1(nota1);
		setNota2(nota2);
		setFrequencia(frequencia);
		setCodigo(idAluno);
		setIdDisciplina(idDisciplina);
	}
	
	
	public Aluno(int id, String nome, float nota1, float nota2, float frequencia,
			     int idTurma, String nomeDisciplina) {
		setCodigo(id);
		setNome(nome);
		setNota1(nota1);
		setNota2(nota2);
		setFrequencia(frequencia);
		setIdTurma(idTurma);
		setNomeDisciplina(nomeDisciplina);
	}
	
	
	
	
	public Aluno(int id, String login, String senha, String nome,
			     int idTurma) {
		setCodigo(id);
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setIdTurma(idTurma);
	}
	
	 // CONSTRUTOR SEM PARÂMETROS
	public Aluno() {
		setCodigo(codigo);
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setNota1(nota1);
		setNota2(nota2);
		setFrequencia(frequencia);
		setIdTurma(idTurma);
		setNomeDisciplina(nomeDisciplina);
	}
	
	//CONSTRUTOR COM INFORMAÇÕES DO ALUNO (sem login e senha) + idTurma
			public Aluno (int id, String nome, float nota1, float nota2, float frequencia,
					int idTurma) {
				setCodigo(id);
				setNome(nome);
				setNota1(nota1);
				setNota2(nota2);
				setFrequencia(frequencia);
				setIdTurma(idTurma);
			}
			
			//CONSTRUTOR COM INFORMAÇÕES DO ALUNO (sem login e senha) + DescTurma
			public Aluno (int id, String nome, float nota1, float nota2, float frequencia,	String descTurma) {
				setCodigo(id);
				setNome(nome);
				setNota1(nota1);
				setNota2(nota2);
				setFrequencia(frequencia);
				setDescTurma(descTurma);
			}
		
	//CONSTRUTOR com LOGIN E SENHA (fazer login no sistema)
	public Aluno(String login, String senha) {
		setLogin(login);
		setSenha(senha);
	}
}
