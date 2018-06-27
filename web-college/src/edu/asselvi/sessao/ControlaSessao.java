package edu.asselvi.sessao;

public class ControlaSessao {
	
	private int codigo;
	private String nome;	
	private int tempoSessao;
	private long ultimoAcesso;
	private int tipoUsuario;

	public ControlaSessao() {
		this (0, "Sem nome", 0, 0, 0);
	}

	public ControlaSessao(int codigo, String nome, int tempoSessao,  long ultimoAcesso, int tipoUsuario) {
		setCodigo(codigo);
		setNome(nome);
		setTempoSessao(tempoSessao);
		setUltimoAcesso(ultimoAcesso);
		setTipoUsuario(tipoUsuario);
		
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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

	public int getTempoSessao() {
		return tempoSessao;
	}

	public void setTempoSessao(int tempoSessao) {
		this.tempoSessao = tempoSessao;
	}

	public long getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(long ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	@Override
	public String toString() {
		return getNome();
	}
	

}
