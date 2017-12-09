package br.ucb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;

import com.mysql.fabric.xmlrpc.base.Array;

import br.ucb.dao.UsuarioDAO;
import br.ucb.entity.Login;
import br.ucb.entity.Usuario;

@ViewScoped
@ManagedBean(name = "professorBean")
public class ProfessorBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4385159599249889753L;

	private String nome;
	private String matricula;
	private Usuario usuarioSelecionado;
	private List<Usuario> professores;
	Usuario prof = new Usuario();
	UsuarioDAO profDao = new UsuarioDAO();

	@PostConstruct
	public void load() {
		professores = new UsuarioDAO().getList();
	}

	public ProfessorBean() {
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

	public void onRowSelect(SelectEvent slc) {
		usuarioSelecionado = (Usuario) slc.getObject();
		System.out.println(usuarioSelecionado.getNomeUsuario());
	}

	public void tabelaFormat() {

		DataTable tabela = new DataTable();
		tabela.setRowsPerPageTemplate("1");

	}
	/*
	 * @PostConstruct public List<Usuario> listaProfsBean() { profs = new
	 * ArrayList<>(); for (Usuario u : dao.getList()) { profs.add(u); } return
	 * profs; }
	 */

	// @PostConstruct
	/*
	 * private void getProfessores(){ profs= dao.getList(); }
	 */

	/*
	 * public List<Usuario> getProfessores() { return dao.getList(); }
	 */

	public List<Usuario> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Usuario> professores) {
		this.professores = professores;
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

	public void concluirVotacao() {
		addMessage("", "Votação concluída com sucesso!");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
