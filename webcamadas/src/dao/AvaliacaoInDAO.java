package dao;

import java.sql.SQLException;
import java.util.List;

import model.Avaliacao;

public interface AvaliacaoInDAO {

	void Inserir(Avaliacao _objeto) throws SQLException;
	
	Boolean Excluir(int _ordem) throws SQLException;
	
	Boolean Atualizar(Avaliacao _objeto) throws SQLException;
	
	List<Avaliacao> listarAvaliacaoPorPessoa(int _matriculaAluno) throws SQLException;
	
	public Avaliacao buscarPorAvaliacao(int _codigo) throws SQLException;
}
