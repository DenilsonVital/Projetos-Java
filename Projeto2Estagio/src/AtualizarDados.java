import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarDados {
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
	 * Método para atualizar registro da tabela_pessoa
	 * 
	 * @param id
	 * @param nome
	 * @param d
	 */
	public void atualizar(int id_pessoa, String nome, String rg) {
		String nomeMaiusculo = nome.toUpperCase();
		
		//comando SQL para atualizar através do ID
		String sql = "UPDATE tabela_pessoa SET nome = ?, rg = ? WHERE id_pessoa = ?";
		
		try {
			Connection conn = this.conectar();//instanciando o método conexão
			
			PreparedStatement pstnt = conn.prepareStatement(sql);
			pstnt.setString(1, nomeMaiusculo);
			pstnt.setString(2, rg);
			pstnt.setInt(3, id_pessoa);
			pstnt.executeUpdate();//insere na tabela os dados informados acima
			
			System.out.println("Registros atualizados!\n");
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
