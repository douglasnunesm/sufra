package br.ucb.dao;

import br.ucb.entity.Curso;
import br.ucb.generics.GenericCRUD;

public class CursoDAO extends GenericCRUD<Curso, Integer> {
	public CursoDAO() {
		super(Curso.class);
	}

}
