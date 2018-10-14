import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//atributo de conex�o com o banco de dados
	static Connection status;
	
	/**
	 * M�todo que conecta ao banco de dados, e caso n�o exista, cria um
	 * @return 
	 * @throws ClassNotFoundException 
	 */
	public Connection getConection() throws ClassNotFoundException {
		
		Connection conn = null;
		try {
			//comando para abrir a biblioteca do SQLITE
			Class.forName("org.sqlite.JDBC");
			//url de conex�o
			String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3� Per�odo/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
			//conectar com o banco
			this.status = DriverManager.getConnection(url);
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return conn;
	}
}