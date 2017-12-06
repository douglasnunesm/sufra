package br.ucb.dao;

import br.ucb.entity.InstituicaoCurso;
import br.ucb.entity.InstituicaoCursoPK;
import br.ucb.generics.GenericCRUD;

public class InstituicaoDAO extends GenericCRUD<InstituicaoCurso, InstituicaoCursoPK> {
	public InstituicaoDAO() {
		super(InstituicaoCurso.class);
	}

}
