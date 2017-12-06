package br.ucb.dao;

import br.ucb.entity.PerfilLogin;
import br.ucb.generics.GenericCRUD;

public class PerfilLoginDAO extends GenericCRUD<PerfilLogin, Integer> {
	public PerfilLoginDAO() {
		super(PerfilLogin.class);
	}

}
