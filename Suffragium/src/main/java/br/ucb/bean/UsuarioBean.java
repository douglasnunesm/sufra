/*package br.ucb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;

import br.ucb.dao.UsuarioDAO;
import br.ucb.entity.Usuario;
import br.ucb.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<>();

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	@ManagedProperty(value = "${usuarioService}")
	private UsuarioService usuarioService;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
//		Iterable<Usuario> iterable = usuarioService.getUsuarioRepository().findAll();
//		List<Usuario> list = new ArrayList<>();
//		iterable.forEach(list::add);
//		usuarios.addAll(list);
		return usuarioDAO.getList();
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
*/