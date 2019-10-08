package dao;

import java.sql.SQLException;

import model.Professor;

public interface ProfessorInDAO {

    void Inserir(Professor _objeto) throws SQLException;	
	
	Boolean Excluir(int _codigo) throws SQLException;
	
	Boolean Atualizar(Professor _objeto) throws SQLException;
	
	Professor buscarProfessor(int _codigo) throws SQLException;
	
}
