package br.ucb.dao;

import br.ucb.entity.CriterioAvaliacao;
import br.ucb.generics.GenericCRUD;

public class CriterioAvaliacaoDAO extends GenericCRUD<CriterioAvaliacao, Integer> {
	public CriterioAvaliacaoDAO() {
		super(CriterioAvaliacao.class);
	}

}
