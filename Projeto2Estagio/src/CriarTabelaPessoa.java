import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa {
	
	public void criartabela() throws SQLException {//criar uma tabela
		//url de conexão
		String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3º Período/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
		
		//SQL statement para criar uma nova tabela
		String sql = "CREATE TABLE IF NOT EXISTS tabela_pessoa (\n"
					+"id_pessoa integer PRIMARY KEY,\n"//um campo de id para a pessoa
					+"nome text NOT NULL, \n"
					+"rg text NOT NULL \n"
					+");";
		try {
			Connection conn = DriverManager.getConnection(url);
			//instanciar o statement
			Statement stmt = conn.createStatement();
			//criar a nova tabela
			stmt.execute(sql);
			System.out.println("Tabela criada com sucesso!\n");
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			
		}
	}
}
