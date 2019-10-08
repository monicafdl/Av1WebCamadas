package dao;

import java.sql.SQLException;
import java.util.List;

import model.Diario;


public interface DiarioInDAO {


	List<Diario> listarTodos() throws SQLException;
	
	Boolean Excluir(int _codigo) throws SQLException;
	
	Boolean Atualizar(Diario _objeto) throws SQLException;
	
	Diario buscarPorDiario(int _codigo) throws SQLException;

	void Inserir(Diario _objeto) throws SQLException;
}
