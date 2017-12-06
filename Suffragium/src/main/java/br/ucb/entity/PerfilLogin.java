package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the perfil_login database table.
 * 
 */
@Entity
@Table(name = "PERFIL_LOGIN")
@NamedQuery(name = "PerfilLogin.findAll", query = "SELECT p FROM PerfilLogin p")
public class PerfilLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_PERFIL_LOGIN", unique = true, nullable = false)
	private Integer idPerfilLogin;

	@Lob
	private String descricao;

	// bi-directional many-to-one association to Login
	@OneToMany(mappedBy = "perfilLogin")
	private List<Login> logins;

	public PerfilLogin() {
	}

	public Integer getIdPerfilLogin() {
		return this.idPerfilLogin;
	}

	public void setIdPerfilLogin(Integer idPerfilLogin) {
		this.idPerfilLogin = idPerfilLogin;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setPerfilLogin(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setPerfilLogin(null);

		return login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPerfilLogin;
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
		PerfilLogin other = (PerfilLogin) obj;
		if (idPerfilLogin != other.idPerfilLogin)
			return false;
		return true;
	}

}