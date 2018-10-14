import java.util.ArrayList;

public class Pessoa {
	private int id_pessoa;
	private String nome;
	private String rg;
	ArrayList <Pessoa> ListP;
		
	public Pessoa(int id_pessoa, String nome, String rg) {
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.rg = rg;
		ListP = new ArrayList();
	}
	
	public Pessoa() {
		ListP = new ArrayList();
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

	
}