package br.ucb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@Table(name = "PROFESSOR")
@NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_PROFESSOR", unique = true, nullable = false)
	private Integer idProfessor;

	// bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy = "professor")
	private List<Avaliacao> avaliacaos;

	// bi-directional many-to-one association to Login
	@ManyToOne
	@JoinColumn(name = "ID_LOGIN")
	private Login login;

	// bi-directional many-to-one association to Formacao
	@ManyToOne
	@JoinColumn(name = "ID_FORMACAO")
	private Formacao formacao;

	// bi-directional many-to-one association to AreaAtuacao
	@ManyToOne
	@JoinColumn(name = "ID_AREA_ATUACAO")
	private AreaAtuacao areaAtuacao;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	// bi-directional many-to-one association to ProfessorMateria
	@OneToMany(mappedBy = "professor")
	private List<ProfessorMateria> professorMaterias;

	public Professor() {
	}

	public Integer getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setProfessor(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setProfessor(null);

		return avaliacao;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Formacao getFormacao() {
		return this.formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public AreaAtuacao getAreaAtuacao() {
		return this.areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProfessorMateria> getProfessorMaterias() {
		return this.professorMaterias;
	}

	public void setProfessorMaterias(List<ProfessorMateria> professorMaterias) {
		this.professorMaterias = professorMaterias;
	}

	public ProfessorMateria addProfessorMateria(ProfessorMateria professorMateria) {
		getProfessorMaterias().add(professorMateria);
		professorMateria.setProfessor(this);

		return professorMateria;
	}

	public ProfessorMateria removeProfessorMateria(ProfessorMateria professorMateria) {
		getProfessorMaterias().remove(professorMateria);
		professorMateria.setProfessor(null);

		return professorMateria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProfessor;
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
		Professor other = (Professor) obj;
		if (idProfessor != other.idProfessor)
			return false;
		return true;
	}

}