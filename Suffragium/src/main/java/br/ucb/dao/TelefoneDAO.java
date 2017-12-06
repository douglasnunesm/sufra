package br.ucb.dao;

import br.ucb.entity.Telefone;
import br.ucb.generics.GenericCRUD;

public class TelefoneDAO extends GenericCRUD<Telefone, Integer> {
	public TelefoneDAO() {
		super(Telefone.class);
	}

}
