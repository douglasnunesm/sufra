package br.ucb.dao;

import br.ucb.entity.ProfessorMateria;
import br.ucb.entity.ProfessorMateriaPK;
import br.ucb.generics.GenericCRUD;

public class ProfessorMateriaDAO extends GenericCRUD<ProfessorMateria, ProfessorMateriaPK> {
	public ProfessorMateriaDAO() {
		super(ProfessorMateria.class);
	}

}
