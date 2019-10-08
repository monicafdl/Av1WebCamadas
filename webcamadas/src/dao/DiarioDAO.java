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
import model.Disciplina;

public class DiarioDAO implements DiarioInDAO {

	private Connection conexao = null;
	
	public DiarioDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Diario _objeto) throws SQLException {
		
		String SQL = "INSERT INTO Diario (codigo, disciplina, avaliacao) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setInt(2, _objeto.getDisciplina().getCodigo());
		ps.setInt(3, _objeto.getAvaliacao().getCodigo());
		
		ps.execute();

	}

	@Override
	public List<Diario> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<Diario> Diarios = new ArrayList<Diario>();
		ResultSet rs = null;
		
		String SQL = "SELECT codigo, disciplina, avaliacao FROM Diario";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			int cod_disciplina = rs.getInt(2);
			int cod_avaliacao = rs.getInt(3);
			
			DisciplinaDAO daoDisciplina = new DisciplinaDAO(this.conexao);
			Disciplina disciplina = daoDisciplina.buscarPorDisciplina(cod_disciplina);
			
			AvaliacaoDAO daoAva = new AvaliacaoDAO(this.conexao);
			Avaliacao avaliacao = daoAva.buscarPorAvaliacao(cod_avaliacao);
			
			AlunoDAO daoAlu = new AlunoDAO(this.conexao);
			List<Aluno> alunos = daoAlu.ListarPorDiario(codigo);
						
			Diario d = new Diario(codigo, disciplina, avaliacao, alunos);
			
			Diarios.add(d);
		}
		
		return Diarios;
	}

	@Override
	public Boolean Excluir(int _codigo) throws SQLException {
	
		String SQL = "DELETE FROM Diario WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _codigo);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Diario _objeto) throws SQLException {

		String SQL = "UPDATE Diario SET codigo = ?, disciplina = ?, avaliacao = ? WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setInt(2, _objeto.getDisciplina().getCodigo());
		ps.setInt(3, _objeto.getAvaliacao().getCodigo());
		

		
		return ps.execute();
	}

	@Override
	public Diario buscarPorDiario(int _codigo) throws SQLException {
		
		ResultSet rs = null;
		String SQL = "SELECT codigo, disciplina, avaliacao FROM Diario WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		Diario d = null;
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int codigo = rs.getInt(1);
			int cod_disciplina = rs.getInt(2);
			int cod_avaliacao = rs.getInt(3);
			
			DisciplinaDAO daoDisciplina = new DisciplinaDAO(this.conexao);
			Disciplina disciplina = daoDisciplina.buscarPorDisciplina(cod_disciplina);
			
			AvaliacaoDAO daoAva = new AvaliacaoDAO(this.conexao);
			Avaliacao avaliacao = daoAva.buscarPorAvaliacao(cod_avaliacao);
			
			AlunoDAO daoAlu = new AlunoDAO(this.conexao);
			List<Aluno> alunos = daoAlu.ListarPorDiario(codigo);
						
			d = new Diario(codigo, disciplina, avaliacao, alunos);
		}
		
		return d;
	}

	

	
}
