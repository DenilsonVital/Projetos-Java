import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarDado {

	private Connection conectar() {
	//url de conex�o
			String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3� Per�odo/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection(url);//comando para tentar conectar ao BD
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return conn;
		}
	/**
	 * M�todo para buscar os dados da tabela pessoa
	 */
	
	public void listar() {
		String sql = "SELECT id_pessoa, nome, rg FROM tabela_pessoa";
		
		try {
			Connection conn = this.conectar();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql); //retorna o resultado de uma query
			
			//Loop para trazer os resultados da query
			while(rs.next()) {
				System.out.println(rs.getInt("id_pessoa")+"| "+rs.getString("nome")+" | "+rs.getString("rg"));
				}
			}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
