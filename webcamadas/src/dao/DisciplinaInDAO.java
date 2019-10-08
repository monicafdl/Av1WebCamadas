package dao;

import java.sql.SQLException;


import model.Disciplina;


public interface DisciplinaInDAO {

	Boolean Excluir(int _codigo) throws SQLException;
	
	Boolean Atualizar(Disciplina _objeto) throws SQLException;
	
	void Inserir(Disciplina _objeto) throws SQLException;
	
	Disciplina buscarPorDisciplina(int _codigo) throws SQLException;
}