package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Avaliacao;
import model.Diario;

public class AlunoDAO implements AlunoInDAO {

	private Connection conexao = null;
	
	public AlunoDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Aluno _objeto) throws SQLException {
		
		String SQL = "INSERT INTO Aluno (matricula, nome, diario) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getMatricula());
		ps.setString(2, _objeto.getNome());
		ps.setInt(3, _objeto.getDiario().getCodigo());
		
		ps.execute();

	}

	@Override
	public List<Aluno> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<Aluno> Aluno = new ArrayList<Aluno>();
		ResultSet rs = null;
		
		String SQL = "SELECT matricula, nome, diario FROM Aluno";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int matricula = rs.getInt(1);
			String nome = rs.getString(2);
			int id_diario = rs.getInt(3);
			
			DiarioDAO daoDiario = new DiarioDAO(this.conexao);
			Diario diario = daoDiario.buscarPorDiario(id_diario);
			
			AvaliacaoDAO daoAva = new AvaliacaoDAO(this.conexao);
			List<Avaliacao> avaliacoes = daoAva.listarAvaliacaoPorPessoa(matricula);
			
			Aluno a = new Aluno(matricula,nome, diario, avaliacoes);
			
			Aluno.add(a);
		}
		
		return Aluno;
	}

	@Override
	public Boolean Excluir(int _matricula) throws SQLException {
	
		String SQL = "DELETE FROM Aluno WHERE matricula = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _matricula);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Aluno _objeto) throws SQLException {

		String SQL = "UPDATE Aluno SET matricula = ?, nome = ?, diario = ? WHERE matricula = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getMatricula());
		ps.setString(2, _objeto.getNome());
		ps.setInt(3, _objeto.getDiario().getCodigo());
		

		
		return ps.execute();
	}

	@Override
	public Aluno buscarPorMatricula(int _matricula) throws SQLException {
		
		ResultSet rs = null;
		Aluno a = null;
		
		String SQL = "SELECT matricula, nome, diario FROM Aluno WHERE matricula = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int matricula = rs.getInt(1);
			String nome = rs.getString(2);
            int id_diario = rs.getInt(3);
			
			DiarioDAO daoDiario = new DiarioDAO(this.conexao);
			Diario diario = daoDiario.buscarPorDiario(id_diario);
			
			AvaliacaoDAO daoAva = new AvaliacaoDAO(this.conexao);
			List<Avaliacao> avaliacoes = daoAva.listarAvaliacaoPorPessoa(matricula);
			
			a = new Aluno(matricula,nome, diario, avaliacoes);
		}
		
		return a;
	}

	@Override
	public List<Aluno> ListarPorDiario(int _diario) throws SQLException {
		
		List<Aluno> Aluno = new ArrayList<Aluno>();
		ResultSet rs = null;
		
		Aluno a = null;
		
		String SQL = "SELECT matricula, nome, diario FROM Aluno WHERE diario = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int matricula = rs.getInt(1);
			String nome = rs.getString(2);
            int id_diario = rs.getInt(3);
			
			DiarioDAO daoDiario = new DiarioDAO(this.conexao);
			Diario diario = daoDiario.buscarPorDiario(id_diario);
			
			AvaliacaoDAO daoAva = new AvaliacaoDAO(this.conexao);
			List<Avaliacao> avaliacoes = daoAva.listarAvaliacaoPorPessoa(matricula);
			
			a = new Aluno(matricula,nome, diario, avaliacoes);
		}
		
		return a;
		
		
	}



	
}
