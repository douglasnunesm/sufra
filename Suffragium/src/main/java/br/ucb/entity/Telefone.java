package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@Table(name="TELEFONE")
@NamedQuery(name="Telefone.findAll", query="SELECT t FROM Telefone t")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID_TELEFONE", unique=true, nullable=false)
	private Integer idTelefone;

	@Column(name="NUM_PRINCIPAL", length=255)
	private String numPrincipal;

	@Column(name="NUM_SECUNDARIO", length=255)
	private String numSecundario;

	//bi-directional many-to-one association to Instituicao
	@OneToMany(mappedBy="telefone")
	private List<Instituicao> instituicaos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="telefone")
	private List<Usuario> usuarios;

	public Telefone() {
	}

	public Integer getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumPrincipal() {
		return this.numPrincipal;
	}

	public void setNumPrincipal(String numPrincipal) {
		this.numPrincipal = numPrincipal;
	}

	public String getNumSecundario() {
		return this.numSecundario;
	}

	public void setNumSecundario(String numSecundario) {
		this.numSecundario = numSecundario;
	}

	public List<Instituicao> getInstituicaos() {
		return this.instituicaos;
	}

	public void setInstituicaos(List<Instituicao> instituicaos) {
		this.instituicaos = instituicaos;
	}

	public Instituicao addInstituicao(Instituicao instituicao) {
		getInstituicaos().add(instituicao);
		instituicao.setTelefone(this);

		return instituicao;
	}

	public Instituicao removeInstituicao(Instituicao instituicao) {
		getInstituicaos().remove(instituicao);
		instituicao.setTelefone(null);

		return instituicao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTelefone(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTelefone(null);

		return usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTelefone;
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
		Telefone other = (Telefone) obj;
		if (idTelefone != other.idTelefone)
			return false;
		return true;
	}
	
	

}