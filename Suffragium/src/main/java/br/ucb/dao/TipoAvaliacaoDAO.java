package br.ucb.dao;

import br.ucb.entity.TipoAvaliacao;
import br.ucb.generics.GenericCRUD;

public class TipoAvaliacaoDAO extends GenericCRUD<TipoAvaliacao, Integer> {
	public TipoAvaliacaoDAO() {
		super(TipoAvaliacao.class);
	}

}
