import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirPessoa {
Scanner teclado = new Scanner (System.in);
	String nome, rg;
	
	//Método para conectar ao Bando de Dados
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
	
	public void inserir(Pessoa p) {
		String sql = "INSERT INTO tabela_pessoa (nome, rg) VALUES (?, ?)";//comando para inserir os dados na tabela, no caso, nome e telefone
		
		try {
			Connection conn = this.conectar();//instanciando o método conexão
			
			PreparedStatement pstnt = conn.prepareStatement(sql);
			
			System.out.println("Digite o nome do cadastro:");
			p.setNome(teclado.nextLine());
			System.out.println("Digite o RG do cadastro:");
			p.setRg(teclado.nextLine());
			
			pstnt.setString(1, p.getNome());
			pstnt.setString(2, p.getRg());
			pstnt.executeUpdate();//insere na tabela os dados informados acima
			System.out.println("Cadastro incluído com sucesso!\n");
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
