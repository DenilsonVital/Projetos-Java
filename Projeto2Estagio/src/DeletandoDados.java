import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletandoDados {
	
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
	
	public void deletar(int id_pessoa) {
		String sql = "DELETE FROM tabela_pessoa WHERE id_pessoa = ?";
		
		try {
			Connection conn = this.conectar();
			
			PreparedStatement pstnt = conn.prepareStatement(sql);
			
			pstnt.setInt(1, id_pessoa);
			pstnt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println (e.getMessage());
		}
	}

}
