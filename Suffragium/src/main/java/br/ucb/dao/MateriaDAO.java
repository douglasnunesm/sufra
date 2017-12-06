package br.ucb.dao;

import br.ucb.entity.Materia;
import br.ucb.generics.GenericCRUD;

public class MateriaDAO extends GenericCRUD<Materia, Integer> {
	public MateriaDAO() {
		super(Materia.class);
	}

}
