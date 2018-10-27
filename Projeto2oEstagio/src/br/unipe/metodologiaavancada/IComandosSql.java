package br.unipe.metodologiaavancada;

public interface IComandosSql {

	String inserirNaTabela();

	String removerDaTabela();

	String listarNaTabela();

	String criarDatabase();

	String criarTabela();

	String alterarTabela();

	String pegarDaTabelaNome();

	String pegarDaTabelaSala();

}
