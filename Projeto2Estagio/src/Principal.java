import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		try (Connection conn = new Conexao().getConection()){
			System.out.println(Conexao.status);
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome("Denilson");
			pessoa.setRg("1234567");
			
			//pessoa.adicionar(pessoa);
			
			//System.out.println(pessoa.listar());
			
			pessoa.setRg("22222222");
			
			//pessoa.remover(pessoa);
			
			System.out.println(BuscarDado.buscarPorNome("ryu"));
			
			Pessoa p1 = new Pessoa();
			
			p1.setNome("Paulo");
			p1.setRg("654321");
			
			p1.inserir(p1);
			
			System.out.println(p1.listar());
			
			System.out.println(BuscarDado.buscarPorNome("lson"));
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}