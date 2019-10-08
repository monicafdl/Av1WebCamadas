package model;

import java.io.Serializable;

public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String descricao;
	private Professor professor;
	

	public Disciplina() {
		
	}
	
	public Disciplina(int codigo, String descricao, Professor _professor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.professor = _professor;
	}

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	
		
	
}