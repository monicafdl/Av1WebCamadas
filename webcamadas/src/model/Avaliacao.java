package model;

import java.io.Serializable;

public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Diario diario;
	private Aluno aluno;
	private int valor;
	private int codigo;

	public Avaliacao() {
		
	}
	
	public Avaliacao(int codigo, Diario _diario, Aluno _aluno, int valor) {
		super();
		this.codigo = codigo;
		this.diario = _diario;
		this.aluno = _aluno;
		this.valor = valor;
	}

	public Diario getDiario() {
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
}
