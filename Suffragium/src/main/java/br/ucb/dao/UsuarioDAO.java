package br.ucb.dao;

import javax.persistence.NoResultException;

import br.ucb.entity.Login;
import br.ucb.entity.Usuario;
import br.ucb.generics.GenericCRUD;

public class UsuarioDAO extends GenericCRUD<Usuario, Integer> {
	public UsuarioDAO() {
		super(Usuario.class);
	}


}
