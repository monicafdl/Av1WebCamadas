package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Professor;

public class ProfessorDAO implements ProfessorInDAO{

	private Connection conexao = null;
	
	public ProfessorDAO(Connection _conn) {
		this.conexao = _conn;
	}

	@Override
	public void Inserir(Professor _objeto) throws SQLException {
		// TODO Auto-generated method stub
        String SQL = "INSERT INTO Professor (codigo, nome) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setString(2, _objeto.getNome());

		
		ps.execute();
	}

	@Override
	public Boolean Excluir(int _codigo) throws SQLException {
		// TODO Auto-generated method stub
        String SQL = "DELETE FROM Professor WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _codigo);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Professor _objeto) throws SQLException {
		// TODO Auto-generated method stub
        String SQL = "UPDATE Professor SET codigo = ?, nome = ? WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setString(2, _objeto.getNome());
		
		return ps.execute();
	}

	@Override
	public Professor buscarProfessor(int _codigo) throws SQLException {
		
		ResultSet rs = null;
		Professor p = null;
		
		String SQL = "SELECT codigo, nome FROM Diario WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			
			
			p = new Professor(codigo, nome);
		}
		
		return p;
	}

}
