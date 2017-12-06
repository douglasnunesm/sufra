package br.ucb.dao;

import br.ucb.entity.Instituicao;
import br.ucb.generics.GenericCRUD;

public class InstituicaoCursoDAO extends GenericCRUD<Instituicao, Integer> {
	public InstituicaoCursoDAO() {
		super(Instituicao.class);
	}

}
