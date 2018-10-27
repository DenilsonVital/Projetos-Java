package br.unipe.metodologiaavancada;

import java.util.ArrayList;

public interface ICinemaDAO {

	void remover(CinemaDAO cinema);

	void add(CinemaDAO cinema);

	ArrayList<CinemaDAO> listar();

	void alterar(CinemaDAO cinema);

	ArrayList<CinemaDAO> buscarPeloNome(String nome);

	ArrayList<CinemaDAO> buscarPorSala(String sala);

}
