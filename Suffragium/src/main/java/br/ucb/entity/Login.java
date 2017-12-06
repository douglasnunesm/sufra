package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name="LOGIN")
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_LOGIN", unique=true, nullable=false)
	private Integer idLogin;

	@Column(name="EMAIL_RECUPERACAO", length=255)
	private String emailRecuperacao;

	@Column(length=255)
	private String login;

	@Column(length=255)
	private String senha;

	//bi-directional many-to-one association to Instituicao
	@OneToMany(mappedBy="login")
	private List<Instituicao> instituicaos;

	//bi-directional many-to-one association to PerfilLogin
	@ManyToOne
	@JoinColumn(name="ID_PERFIL_LOGIN")
	private PerfilLogin perfilLogin;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="login")
	private List<Professor> professors;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="login")
	private List<Usuario> usuarios;

	public Login() {
	}

	public Integer getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	public String getEmailRecuperacao() {
		return this.emailRecuperacao;
	}

	public void setEmailRecuperacao(String emailRecuperacao) {
		this.emailRecuperacao = emailRecuperacao;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Instituicao> getInstituicaos() {
		return this.instituicaos;
	}

	public void setInstituicaos(List<Instituicao> instituicaos) {
		this.instituicaos = instituicaos;
	}

	public Instituicao addInstituicao(Instituicao instituicao) {
		getInstituicaos().add(instituicao);
		instituicao.setLogin(this);

		return instituicao;
	}

	public Instituicao removeInstituicao(Instituicao instituicao) {
		getInstituicaos().remove(instituicao);
		instituicao.setLogin(null);

		return instituicao;
	}

	public PerfilLogin getPerfilLogin() {
		return this.perfilLogin;
	}

	public void setPerfilLogin(PerfilLogin perfilLogin) {
		this.perfilLogin = perfilLogin;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setLogin(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setLogin(null);

		return professor;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setLogin(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setLogin(null);

		return usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLogin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (idLogin != other.idLogin)
			return false;
		return true;
	}
	
	

}