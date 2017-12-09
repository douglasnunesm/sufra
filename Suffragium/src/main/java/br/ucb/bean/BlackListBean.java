package br.ucb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.ucb.dao.UsuarioDAO;
import br.ucb.entity.Usuario;

@ManagedBean
public class BlackListBean {
	List<Usuario> blackListProf = new ArrayList<>();
	private String nome;
	private String matricula;
	private Usuario usuarioSelecionado;
	private List<Usuario> professores;
	Usuario prof = new Usuario();
	UsuarioDAO profDao = new UsuarioDAO();

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

	public List<Usuario> onRowSelect(SelectEvent slc) {
		usuarioSelecionado = (Usuario) slc.getObject();
		System.out.println(usuarioSelecionado.getNomeUsuario());
		
		List<Usuario> prof = new ArrayList<>();
		for(Usuario element : getBuscarProfessores()){
			if(usuarioSelecionado.equals(element)){
				prof.add(element);
				getBuscarProfessores().remove(element);
			}
		}
		return prof;
	}

/*	public List<Usuario> adicionarProfBlackList(){
		List<Usuario> prof = new ArrayList<>();
		for(Usuario element : getBuscarProfessores()){
			if(o que eu clicar ){
				prof.add(element);
				getBuscarProfessores().remove(element);
			}
		}
		return prof;
	}
*/
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
