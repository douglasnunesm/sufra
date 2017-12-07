package br.ucb.dao;

import javax.persistence.NoResultException;

import br.ucb.entity.Login;
import br.ucb.generics.GenericCRUD;

public class LoginDAO extends GenericCRUD<Login, Integer> {
	public LoginDAO() {
		super(Login.class);
	}

	public Login buscarLogin(String email, String senha) {
		try {
			String query = "SELECT l from Login l where l.login = :email and l.senha = :senha ";
			Login login = (Login) entityManager.createQuery(query).setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();
			return login;
		} catch (NoResultException e) {
			return null;
		}

	}
}
