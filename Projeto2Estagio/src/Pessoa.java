import java.util.ArrayList;

public class Pessoa implements IPessoa{
	private int id_pessoa;
	private String nome;
	private String rg;
	ArrayList <Pessoa> ListP;
		
	public Pessoa(int id_pessoa, String nome, String rg) {
		super();
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.rg = rg;
	}
	
	public Pessoa() {;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	public ArrayList<Pessoa> getListP() {
		return ListP;
	}

	public void setListP(ArrayList<Pessoa> listP) {
		ListP = listP;
	}
	
	public void addPessoa(Pessoa p) {
		ListP.add(p);
	}

	@Override
	public String toString() {
		return "Pessoa [id_pessoa=" + id_pessoa + ", nome=" + nome + ", rg=" + rg + "]";
	}

	@Override
	public String inserir(Pessoa p) {
		return "insert into tabela_pessoa (nome, rg) values (?, ?)";
	}

	@Override
	public String deletar() {
		return "delete from pessoa where rg = ?";
		
	}

	@Override
	public String listar() {
		return "select * from tabela_pessoa";
	}

	@Override
	public String alterar(Pessoa pessoa) {
		return "update Pessoa set nome = ?, rg = ? where rg = ?";
		
	}

	@Override
	public ArrayList<Pessoa> buscarPessoa(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
}