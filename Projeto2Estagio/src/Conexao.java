import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//atributo de conex�o com o banco de dados
	private Connection conexao;
	
	/**
	 * M�todo que conecta ao banco de dados, e caso n�o exista, cria um
	 * @return true - a conex�o foi realizada
	 * @throws ClassNotFoundException 
	 */
	
	public boolean conectar() throws ClassNotFoundException {
		try {
			//comando para abrir a biblioteca do SQLITE
			Class.forName("org.sqlite.JDBC");
			//url de conex�o
			String url = "jdbc:sqlite:C:/Users/D'/Desktop/Sistemas para Internet/3� Per�odo/Metodologia e Linguagens de Programacao Avancada - Thiago Rodrigues/Codigos feitos em sala/Projeto2Estagio/banco_de_dados/banco_sqlite.db";
			//conectar com o banco
			this.conexao = DriverManager.getConnection(url);
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
			return false; //caso n�o conecte, retorna falso
		}
		System.out.println("Conectou com o banco!");
		return true; //caso conecte, retorna verdadeiro
	}
	/**
	 * M�todo para desconectar do banco de dados
	 * 
	 * @return true - caso desconecte
	 */
	public boolean desconectar() {
		try {
			if(this.conexao.isClosed()==false)//se n�o estiver fechado {
				this.conexao.close();//ent�o feche
			}catch(SQLException e){
			System.err.println(e.getMessage());
			return false; //caso n�o desconecte, retorna falso
		}
		System.out.println("Desconectou do banco!");
		return true;//caso desconecte, retorna verdadeiro
		
	}
}
