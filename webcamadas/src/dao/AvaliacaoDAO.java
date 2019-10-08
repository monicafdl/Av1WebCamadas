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

public class AvaliacaoDAO implements AvaliacaoInDAO {

	private Connection conexao = null;
	
	public AvaliacaoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Avaliacao _objeto) throws SQLException {
		
		String SQL = "INSERT INTO avalicao (codigo, diario, aluno, valor) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setInt(2, _objeto.getDiario().getCodigo());
		ps.setInt(3, _objeto.getAluno().getMatricula());
		ps.setInt(4, _objeto.getValor());

		
		ps.execute();

	}

	@Override
	public Boolean Excluir(int _aluno) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM Avaliacao WHERE aluno = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _aluno);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Avaliacao _objeto) throws SQLException {
		// TODO Auto-generated method stub
 	    String SQL = "UPDATE Avaliacao SET codigo = ?, diario = ?, aluno = ?, valor =? WHERE ordem = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getCodigo());
		ps.setInt(2, _objeto.getDiario().getCodigo());
		ps.setInt(3, _objeto.getAluno().getMatricula());
		ps.setInt(4, _objeto.getValor());
				
		return ps.execute();
	}

	

	@Override
	public List<Avaliacao> listarAvaliacaoPorPessoa(int matricula) throws SQLException {
		
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		ResultSet rs = null;
		
		String SQL = "SELECT codigo, diario, aluno, valor FROM nota WHERE matricula = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, matricula);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			int id_diario = rs.getInt(1);
			int matricula_aluno = rs.getInt(2);
			int valor = rs.getInt(3);
			
			DiarioDAO daoDiario = new DiarioDAO(this.conexao);
			Diario diario = daoDiario.buscarPorDiario(id_diario);	
			
			AlunoDAO daoAluno = new AlunoDAO(this.conexao);
			Aluno aluno = daoAluno.buscarPorMatricula(matricula_aluno);
			
		}
		
		return avaliacoes;
	}


	@Override
	public Avaliacao buscarPorAvaliacao(int _codigo) throws SQLException {
		ResultSet rs = null;
		String SQL = "SELECT codigo, diario, aluno, valor FROM nota WHERE codigo = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
		rs = ps.executeQuery();
		
		Avaliacao a = null;
		
		if (rs.next()) {
			
			int codigo = rs.getInt(1);
			int coddiario = rs.getInt(2);
			int mataluno = rs.getInt(3);
			int valor = rs.getInt(4);
			
			DiarioDAO daoDiario = new DiarioDAO(this.conexao);
			Diario diario = daoDiario.buscarPorDiario(coddiario);	
			
			AlunoDAO daoAluno = new AlunoDAO(this.conexao);
			Aluno aluno = daoAluno.buscarPorMatricula(mataluno);
						
			a = new Avaliacao(codigo,diario,aluno,valor);
		 	
		   
	}
		 return a;
			
}
		

}
