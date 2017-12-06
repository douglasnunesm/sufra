package br.ucb.dao;

import br.ucb.entity.Aluno;
import br.ucb.generics.GenericCRUD;

public class AlunoDAO extends GenericCRUD<Aluno, Integer> {
	public AlunoDAO() {
		super(Aluno.class);
	}

}
