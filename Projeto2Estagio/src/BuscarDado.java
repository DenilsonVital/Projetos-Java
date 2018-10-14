import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuscarDado {

	private Connection conectar() {
	//url de conexão
			String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3º Período/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
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
	 * Método para buscar os dados da tabela pessoa
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
	
	public static ArrayList<Pessoa> buscarPorNome(String nome) {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try(Connection conn = new Conexao().getConection()) {
			PreparedStatement ps = conn.prepareStatement();
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(rs.getString("nome"));
				pessoa.setRg(rs.getString("rg"));
				pessoas.add(pessoa);
			}
			rs.close();
			ps.close();				
		} catch (SQLException e) {
			System.out.println("Error: pessoa não encontrada!");
			e.getMessage();
		}	
		return pessoas;
}
}
