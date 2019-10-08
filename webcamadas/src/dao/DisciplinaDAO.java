package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Disciplina;
import model.Professor;

public class DisciplinaDAO implements DisciplinaInDAO {
	
    private Connection conexao = null;
	
	public DisciplinaDAO(Connection _conn) {
		this.conexao = _conn;
	}

	@Override
	public Boolean Excluir(int _codigo) throws SQLException {
		// TODO Auto-generated method stub
       String SQL = "DELETE FROM Disciplina WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _codigo);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Disciplina _objeto) throws SQLException {
		// TODO Auto-generated method stub
        String SQL = "UPDATE Disciplina SET codigo = ?, descricao = ?, professor = ? WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setString(2, _objeto.getDescricao());
		ps.setInt(3, _objeto.getProfessor().getCodigo());
		

		
		return ps.execute();
	}

	@Override
	public void Inserir(Disciplina _objeto) throws SQLException {
		// TODO Auto-generated method stub
        String SQL = "INSERT INTO Disciplina (codigo, descricao, professor) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setString(2, _objeto.getDescricao());
		ps.setInt(3, _objeto.getProfessor().getCodigo());
		
		ps.execute();
	}

	@Override
	public Disciplina buscarPorDisciplina(int _codigo) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Disciplina d = null;
		
		String SQL = "SELECT codigo, descricao, professor FROM Disciplina WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int codigo = rs.getInt(1);
			String descricao = rs.getString(2);
			int cod_prof = rs.getInt(3);
			
			ProfessorDAO daoProf = new ProfessorDAO(this.conexao);
			Professor professor = daoProf.buscarProfessor(cod_prof);
		
			d = new Disciplina(codigo, descricao, professor);
		}
		
		return d;
	}

}
