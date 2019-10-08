package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Diario implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private Disciplina disciplina;
	private Avaliacao avaliacao;
	
	private List<Aluno> alunos;
	

	public Diario() {
		this.alunos = new ArrayList<Aluno>();
	}
	
	public Diario(int codigo, Disciplina _disciplina, Avaliacao _avaliacao, List<Aluno> alunos) {
		super();
		this.codigo = codigo;
		this.disciplina = _disciplina;
		this.avaliacao = _avaliacao;
		this.alunos = alunos; 
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	

	
}