import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//atributo de conexão com o banco de dados
	private Connection conexao;
	
	/**
	 * Método que conecta ao banco de dados, e caso não exista, cria um
	 * @return true - a conexão foi realizada
	 * @throws ClassNotFoundException 
	 */
	
	public boolean conectar() throws ClassNotFoundException {
		try {
			//comando para abrir a biblioteca do SQLITE
			Class.forName("org.sqlite.JDBC");
			//url de conexão
			String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3º Período/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
			//conectar com o banco
			this.conexao = DriverManager.getConnection(url);
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
			return false; //caso não conecte, retorna falso
		}
		System.out.println("Conectou com o banco!");
		return true; //caso conecte, retorna verdadeiro
	}
	/**
	 * Método para desconectar do banco de dados
	 * 
	 * @return true - caso desconecte
	 */
	public boolean desconectar() {
		try {
			if(this.conexao.isClosed()==false)//se não estiver fechado {
				this.conexao.close();//então feche
			}catch(SQLException e){
			System.err.println(e.getMessage());
			return false; //caso não desconecte, retorna falso
		}
		System.out.println("Desconectou do banco!");
		return true;//caso desconecte, retorna verdadeiro
		
	}
}
