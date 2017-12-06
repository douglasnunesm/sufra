package br.ucb.dao;

import br.ucb.entity.Turma;
import br.ucb.generics.GenericCRUD;

public class TurmaDAO extends GenericCRUD<Turma, Integer> {
	public TurmaDAO() {
		super(Turma.class);
	}

}
