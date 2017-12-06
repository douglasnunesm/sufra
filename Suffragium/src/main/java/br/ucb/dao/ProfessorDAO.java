package br.ucb.dao;

import br.ucb.entity.Professor;
import br.ucb.generics.GenericCRUD;

public class ProfessorDAO extends GenericCRUD<Professor, Integer> {
	public ProfessorDAO() {
		super(Professor.class);
	}

}
