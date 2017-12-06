package br.ucb.dao;

import br.ucb.entity.Formacao;
import br.ucb.generics.GenericCRUD;

public class FormacaoDAO extends GenericCRUD<Formacao, Integer> {
	public FormacaoDAO() {
		super(Formacao.class);
	}

}
