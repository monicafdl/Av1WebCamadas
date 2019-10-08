package dao;

import java.sql.SQLException;
import java.util.List;

import model.Aluno;


public interface AlunoInDAO {


	List<Aluno> listarTodos() throws SQLException;
	
	Boolean Excluir(int _matricula) throws SQLException;
	
	Boolean Atualizar(Aluno _objeto) throws SQLException;
	
	Aluno buscarPorMatricula(int _matricula) throws SQLException;
	
	List<Aluno> ListarPorDiario(int _diario) throws SQLException;

	void Inserir(Aluno _objeto) throws SQLException;
}
