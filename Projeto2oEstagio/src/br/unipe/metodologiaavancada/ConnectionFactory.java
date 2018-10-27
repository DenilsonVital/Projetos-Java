package br.unipe.metodologiaavancada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	static String status;
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/tbl_cinema";
		
			conn = DriverManager.getConnection(url, "root","");
			
			status = "Conexão com o banco de dados feita com sucesso!";
		}catch (SQLException e) {
			status = e.getMessage();
		}
	
		return conn;
	}
}
