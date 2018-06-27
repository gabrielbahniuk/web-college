package edu.asselvi.bean;

public class Curso {
	
	private int id;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Curso() {
		setId(id);
		setDescricao(descricao);
	}
	
	public Curso(int id, String descricao) {
		setId(id);
		setDescricao(descricao);
	}
	
	
	
	
	
}
