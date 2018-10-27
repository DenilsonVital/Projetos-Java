package br.unipe.metodologiaavancada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CinemaDAO implements ICinemaDAO{

	private int idCinema;
	private String nome;
	private String sala;
	private String assento;
	
	public IComandosSql cmd = new ComandosSql();
	
	public CinemaDAO() {
		
	}
	
	public CinemaDAO (int idCinema, String nome, String sala, String assento) {
		super();
		this.idCinema = idCinema;
		this.nome = nome;
		this.sala = sala;
		this.assento = assento;
		
	}
	
	@Override
	public String toString() {
		return "CinemaDAO [idCinema=" + idCinema + ", nome=" + nome + ", sala=" + sala + ", assento=" + assento + "]";
	}

	@Override
	public void add (CinemaDAO cinema) {
		
		try (Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(cmd.inserirNaTabela());
			ps.setString(1, cinema.getNome());
			ps.setString(2, cinema.getSala());
			ps.setString(3, cinema.getAssento());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	@Override
	public void remover (CinemaDAO cinema) {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			PreparedStatement ps = conn.prepareStatement (cmd.removerDaTabela());
			ps.setString(1, cinema.getNome());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao deletar o cinema na tabela no banco de dados! Tente de novo...");
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public ArrayList <CinemaDAO> listar (){
		ArrayList <CinemaDAO> lista = new ArrayList<CinemaDAO>();
		PreparedStatement ps;
		
		try (Connection conn = new ConnectionFactory().getConnection()) {
			ps = conn.prepareStatement(cmd.listarNaTabela());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CinemaDAO cinema = new CinemaDAO();
				cinema.setNome(rs.getString("nome"));
				cinema.setSala(rs.getString("sala"));
				cinema.setAssento(rs.getString("assento"));
				lista.add(cinema);
			}
			rs.close();
			ps.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	@Override
	public void alterar (CinemaDAO cinema) {
		try(Connection conn = new ConnectionFactory().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(cmd.alterarTabela());
			ps.setString(1, cinema.getNome());
			ps.setString(2, cinema.getSala());
			ps.setString(3, cinema.getAssento());
			ps.execute(); //executa o comando sql
			ps.close(); //fecha a conexão
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o cinema no banco de dados! Tente outra vez...");
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public ArrayList <CinemaDAO> buscarPeloNome (String nome) {
		ArrayList <CinemaDAO> cinemas = new ArrayList <CinemaDAO>();
		try (Connection conn = new ConnectionFactory ().getConnection()){
			PreparedStatement ps = conn.prepareStatement(cmd.pegarDaTabelaNome());
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CinemaDAO cinema = new CinemaDAO();
				cinema.setNome(rs.getString("nome"));
				cinema.setSala(rs.getString("sala"));
				cinema.setAssento(rs.getString("assento"));
				cinemas.add(cinema);
			}
			rs.close();
			ps.close();
		}catch(SQLException e) {
			System.out.println("ERRO! Não foi possível encontrar o cinema!");
			e.getMessage();
		}
		return cinemas;
	}
		
	@Override
	public ArrayList <CinemaDAO> buscarPorSala(String sala){
		ArrayList<CinemaDAO> cinemas = new ArrayList<CinemaDAO>();
		try (Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(cmd.pegarDaTabelaSala());
			ps.setString(1, "%"+sala+"%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CinemaDAO cinema = new CinemaDAO();
				cinema.setNome(rs.getString("nome"));
				cinema.setSala(rs.getString("sala"));
				cinema.setAssento(rs.getString("assento"));
				cinemas.add(cinema);
			}
			rs.close();
			ps.close();
		}catch (SQLException e) {
			System.out.println("O cinema não foi encontrado! Tente de novo...");
			e.getMessage();
		}
		return cinemas;
	}
	
	public void criarBancoDeDados() {
		try (Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(cmd.criarDatabase());
			ps.executeQuery();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Erro: não foi possível criar o Banco de Dados. Tente de novo!");
			e.getMessage();
		}
				
	}
	
	public void criarTabelaCinema() {
		try (Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(cmd.criarTabela());
			ps.executeQuery();
			ps.close();
		}catch (SQLException e) {
			System.out.println("Erro ao criar a tabela no BD. Tente de novo...");
			e.getMessage();
		}
	}
	
	
	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getAssento() {
		return assento;
	}

	public void setAssento(String assento) {
		this.assento = assento;
	}


	
}
