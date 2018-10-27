package br.unipe.metodologiaavancada;

public class ComandosSql implements IComandosSql{

	@Override
	public String criarDatabase() {
		return "create database";
	}
	
	@Override
	public String criarTabela() {
		String sql = "";
		sql += "create table tbl_cinema("+"id_cinema int not null auto-increment,"+"nome varchar (60)not null unique,"+"sala varchar (11) not null"+"assentos (5) not null"+")";
		
		return sql;
	}

	@Override
	public String inserirNaTabela() {
		return "insert into cinema (nome, sala, assentos) values (?,?,?)";
	}
	
	@Override
	public String removerDaTabela() {
		return "delete from cinema where sala=?";
	}
	
	@Override
	public String listarNaTabela() {
		return "select * from cinema";
	}
	
	@Override
	public String alterarTabela() {
		return "update Cinema set nome=?, sala=?, assentos=? where id_cinema=?";
	}
	
	@Override
	public String pegarDaTabelaNome() {
		return "select * from cinema where nome LIKE ?";
	}
	
	@Override
	public String pegarDaTabelaSala() {
		return "select * from pessoa where sala LIKE ?";
	}
}
