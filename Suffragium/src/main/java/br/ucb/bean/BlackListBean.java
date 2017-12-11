package br.ucb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.ucb.dao.UsuarioDAO;
import br.ucb.entity.Usuario;

@ManagedBean
@SessionScoped
public class BlackListBean {
	List<Usuario> blackListProf = new ArrayList<>();
	String nome;
	String matricula;
	Usuario usuarioSelecionado;
	List<Usuario> professores;
	Usuario prof = new Usuario();
	UsuarioDAO profDao = new UsuarioDAO();
	List<Usuario> profBlackList = new ArrayList<>();
	List<Usuario> profsExcl = new ArrayList<>();
	public List<Usuario> getBlackListProf() {
		return blackListProf;
	}

	public void setBlackListProf(List<Usuario> blackListProf) {
		this.blackListProf = blackListProf;
	}

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

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Usuario> professores) {
		this.professores = professores;
	}

	public Usuario getProf() {
		return prof;
	}

	public void setProf(Usuario prof) {
		this.prof = prof;
	}

	public List<Usuario> getProfBlackList() {
		return profBlackList;
	}

	public void setProfBlackList(List<Usuario> profBlackList) {
		this.profBlackList = profBlackList;
	}

	public BlackListBean() {
		professores = new UsuarioDAO().getList();
	}

	public List<Usuario> getBuscarProfessores() {
		List<Usuario> profs = new ArrayList<>();
		for (Usuario element : professores) {
			if (element.getLogin().getPerfilLogin().getIdPerfilLogin().equals(2)) {
				profs.add(element);
			}
		}

		return profs;
	}



	public void adicionarProfBlackList(SelectEvent slc) {
		usuarioSelecionado = (Usuario) slc.getObject();
		for (Usuario element : getBuscarProfessores()) {
			if (usuarioSelecionado.equals(element)) {
				profBlackList.add(element);
			}
		}
	}

	public List<Usuario> listaBlackList() {
		return profBlackList;
	}

	public void save() {
		addMessage("Success", "Data saved");
	}

	public void update() {
		addMessage("Success", "Data updated");
	}

	public void delete() {
		addMessage("Success", "Data deleted");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
