package br.ucb.dao;

import br.ucb.entity.CursoMateria;
import br.ucb.entity.CursoMateriaPK;
import br.ucb.generics.GenericCRUD;

public class CursoMateriaDAO extends GenericCRUD<CursoMateria, CursoMateriaPK> {
	public CursoMateriaDAO() {
		super(CursoMateria.class);
	}

}
