package br.ucb.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.ucb.dao.UsuarioDAO;
import br.ucb.entity.Usuario;

//@Stateless
public class ProfessorService implements Serializable {
	@Inject
	private UsuarioDAO userDao;

	public List<Usuario> consultaTodos() {
		return userDao.getList();
	}
	
}
