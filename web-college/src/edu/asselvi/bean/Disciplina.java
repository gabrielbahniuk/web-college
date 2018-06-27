package edu.asselvi.bean;

public class Disciplina {

	private int id;
	private String descricao;
	private String descCurso;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}
	public String getDescCurso() {
		return descCurso;
	}
	
	
	public Disciplina() {
		setId(id);
		setDescricao(descricao);
		setDescCurso(descCurso);
	}

	public Disciplina(int id, String descricao, String descCurso) {
		setId(id);
		setDescricao(descricao);
		setDescCurso(descCurso);
	
	}
	
	public Disciplina(int id, String descricao) {
		setId(id);
		setDescricao(descricao);
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
	
}
