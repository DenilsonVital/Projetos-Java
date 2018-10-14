import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//atributo de conexão com o banco de dados
	static Connection status;
	
	/**
	 * Método que conecta ao banco de dados, e caso não exista, cria um
	 * @return 
	 * @throws ClassNotFoundException 
	 */
	public Connection getConection() throws ClassNotFoundException {
		
		Connection conn = null;
		try {
			//comando para abrir a biblioteca do SQLITE
			Class.forName("org.sqlite.JDBC");
			//url de conexão
			String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3º Período/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
			//conectar com o banco
			this.status = DriverManager.getConnection(url);
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return conn;
	}
}