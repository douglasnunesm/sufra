package br.ucb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.ucb.entity.Instituicao;
import br.ucb.entity.Turma;
import br.ucb.entity.Usuario;

/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name = "ALUNO")
@NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_ALUNO", unique = true, nullable = false)
	private Integer idAluno;

	// bi-directional many-to-one association to Instituicao
	@ManyToOne
	@JoinColumn(name = "ID_INSTITUICAO")
	private Instituicao instituicao;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	// bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name = "ID_TURMA")
	private Turma turma;

	// bi-directional many-to-one association to Avaliacao
	@OneToMany(mappedBy = "aluno")
	private List<Avaliacao> avaliacaos;

	public Aluno() {
	}

	public Integer getIdAluno() {
		return this.idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Instituicao getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Avaliacao> getAvaliacaos() {
		return this.avaliacaos;
	}

	public void setAvaliacaos(List<Avaliacao> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

	public Avaliacao addAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().add(avaliacao);
		avaliacao.setAluno(this);

		return avaliacao;
	}

	public Avaliacao removeAvaliacao(Avaliacao avaliacao) {
		getAvaliacaos().remove(avaliacao);
		avaliacao.setAluno(null);

		return avaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAluno;
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
		Aluno other = (Aluno) obj;
		if (idAluno != other.idAluno)
			return false;
		return true;
	}

}