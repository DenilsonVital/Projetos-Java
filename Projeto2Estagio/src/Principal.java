import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
	}
			public void menu() {
			Scanner entrada = new Scanner (System.in);
			int opcao;
			
			System.out.println(" ---------------------------");
			System.out.println("| OLÁ! BEM VINDO AO MENU:   |");
			System.out.println("|                           |");
			System.out.println("| 1- Adicionar Pessoa;      |");
			System.out.println("| 2- Alterar Cadastro;      |");
			System.out.println("| 3- Excluir Cadastro;      |");
			System.out.println("| 4- Listar Cadastros;      |");
			System.out.println("| 5- Sair;                  |");
			System.out.println(" ---------------------------");
			
			
		opcao = entrada.nextInt();
		
		switch(opcao) {
			case 1:
				InserirPessoa.inserir(Pessoa p);
				menu();
				break;
			case 2:
				AtualizarDados.atualizar(Pessoa p);
				menu();
				break;
			case 3:
				DeletandoDados.deletar();
				menu();
				break;
			case 4:
				BuscarDado.listar();
				menu();
				break;
			case 5:
				wait();
		}
		/*instanciar a classe conexão e CriarTabelaPessoa
		CriarTabelaPessoa criartabelapessoa = new CriarTabelaPessoa();
		Conexao conn = new Conexao();
		//Instanciar a classe inserir pessoa
		//InserirPessoa inserirpessoa = new InserirPessoa();
		//instanciar classe de busca
		BuscarDado buscardado = new BuscarDado();
		
		//instanciar a classe que atualiza os dados da tabela_pessoa
		AtualizarDados atualizar = new AtualizarDados();
		
		//instanciar a classe que deleta os dados da tabela_pessoa
		DeletandoDados deleta = new DeletandoDados();
		
		conn.conectar();//conectar
		
		criartabelapessoa.criartabela();//criar tabela pessoa
		
		//buscar os registros na tabela_pessoa
		buscardado.selecionarDados();
		
		//atualizar o registro
		//atualizar.atualizarDados(1, "DENIS", "8888.8888");
		//atualizar.atualizarDados(2, "DENILSON", "9999.9999");
		conn.desconectar();//desconectar
		
		//deletar o registro
		deleta.deletarDados(1);
		deleta.deletarDados(2);
		
		//buscar os registros na tabela_pessoa
		buscardado.selecionarDados();*/
		}
	}
