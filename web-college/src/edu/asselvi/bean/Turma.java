package edu.asselvi.bean;

public class Turma {
	
	private int codigo;
	private String descricao;
	private int idCurso;
		
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public int getIdCurso() {
		return idCurso;
	}	
	
	public Turma(int codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
	}
	public Turma() {
		setCodigo(codigo);
		setDescricao(descricao);
		setIdCurso(idCurso);
	}
	
	public Turma(int codigo, String descricao, int idCurso) {
		setCodigo(codigo);
		setDescricao(descricao);
		setIdCurso(idCurso);
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
	
	
}
