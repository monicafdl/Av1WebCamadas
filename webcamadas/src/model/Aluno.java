package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;


	private int matricula;
	private String nome;
	private Diario diario;
	
	private List<Avaliacao> avaliacoes;

	
	public Aluno() {
		this.avaliacoes = new ArrayList<Avaliacao>();
	}
	
	public Aluno(int matricula, String nome, Diario _diario, List<Avaliacao> avaliacoes) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.diario = _diario;
		this.avaliacoes = avaliacoes;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Diario getDiario() {
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

	
}
