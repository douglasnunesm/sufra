package br.ucb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.ucb.dao.UsuarioDAO;
import br.ucb.entity.Usuario;
import br.ucb.service.ProfessorService;

@ManagedBean (name = "professorBean")
public class ProfessorBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4385159599249889753L;
	//@Inject
	private ProfessorService profService;

	private String nome;
	private String matricula;

	private List<Usuario> profs;

	Usuario prof = new Usuario();
	UsuarioDAO profDao = new UsuarioDAO();

	@PostConstruct
	public List<Usuario> getProfessores() {
		List<Usuario> professores = profDao.getList();
		return professores;
	}

	/*@PostConstruct
	public List<Usuario> listaProfsBean() {
		profs = new ArrayList<>();
		for (Usuario u : dao.getList()) {
			profs.add(u);
		}
		return profs;
	}*/



	// @PostConstruct
	/*
	 * private void getProfessores(){ profs= dao.getList(); }
	 */

	/*
	 * public List<Usuario> getProfessores() { return dao.getList(); }
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
