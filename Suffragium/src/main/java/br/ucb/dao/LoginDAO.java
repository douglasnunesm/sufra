package br.ucb.dao;

import br.ucb.entity.Login;
import br.ucb.generics.GenericCRUD;

public class LoginDAO extends GenericCRUD<Login, Integer> {
	public LoginDAO() {
		super(Login.class);
	}

}
