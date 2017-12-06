package br.ucb.dao;

import br.ucb.entity.Avaliacao;
import br.ucb.generics.GenericCRUD;

public class AvaliacaoDAO extends GenericCRUD<Avaliacao, Integer> {
	public AvaliacaoDAO() {
		super(Avaliacao.class);
	}

}
