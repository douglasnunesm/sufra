package br.ucb.dao;

import br.ucb.entity.AreaAtuacao;
import br.ucb.generics.GenericCRUD;

public class AreaAtuacaoDAO extends GenericCRUD<AreaAtuacao, Integer> {
	public AreaAtuacaoDAO() {
		super(AreaAtuacao.class);
	}

}
