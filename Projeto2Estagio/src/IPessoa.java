import java.util.ArrayList;

public interface IPessoa {
	
	public String inserir(Pessoa pessoa);
	
	public void deletar (Pessoa pessoa);
	
	public ArrayList<Pessoa> listar();
	
	public void alterar (Pessoa pessoa);
	
	public ArrayList<Pessoa> buscarPessoa(String nome);
	
}
