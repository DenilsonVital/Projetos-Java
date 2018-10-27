package br.unipe.metodologiaavancada;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		
		try (Connection conn = new ConnectionFactory().getConnection()){
			System.out.println(ConnectionFactory.status);
			
			CinemaDAO cinema = new CinemaDAO();
			
			cinema.setNome("Cinepólis");
			cinema.setSala("3D");
			cinema.setAssento("55");
			
			cinema.add(cinema);
			
			CinemaDAO c1 = new CinemaDAO();
			c1.setNome("Cinemark");
			c1.setSala("2D");
			c1.setAssento("43");
			
			c1.add(cinema);
			
			System.out.println(c1.listar());
			
			System.out.println(c1.buscarPeloNome("poli"));
			System.out.println(c1.buscarPorSala("3D"));
			conn.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
